package com.frpf.pcm.controller;

import com.frpf.pcm.dto.AllData;
import com.frpf.pcm.dto.Data;
import com.frpf.pcm.service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

	@Autowired
	private IDataService iDataService;

	@RequestMapping(value = "/data")
	public AllData hello(){
		List<Data> list = iDataService.findAllUser();
		AllData allData = new AllData();
		allData.setDataList(list);
		allData.setTotal((long)list.size());
		return allData;
	}

	@RequestMapping(value = "/insert")
	public String insert(){
		Data data = new Data();
		data.setUserName("程浩");
		data.setUserSex("女");
		iDataService.insertData(data);
		return "Success";
	}

	@RequestMapping(value = "/insertAuto")
	public String insertAuto(){
		Data data = new Data();
		data.setUserName("程浩");
		data.setUserSex("男");
		iDataService.insertDataAuto(data);
		return "Success";
	}
}
