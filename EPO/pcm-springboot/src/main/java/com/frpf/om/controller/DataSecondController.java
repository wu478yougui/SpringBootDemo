package com.frpf.om.controller;
import com.frpf.om.dto.AllData;
import com.frpf.om.dto.DataSecond;
import com.frpf.om.service.IDataSecondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataSecondController {

	@Autowired
	private IDataSecondService iDataService;

	@RequestMapping(value = "/dataSecond")
	public AllData hello(){
		List<DataSecond> list = iDataService.findAllUser();
		AllData allData = new AllData();
		allData.setDataList(list);
		allData.setTotal((long)list.size());
		return allData;
	}

	@RequestMapping(value = "/insertSecond")
	public String insert(){
		DataSecond data = new DataSecond();
		data.setUserName("程浩");
		data.setUserSex("女");
		iDataService.insertData(data);
		return "Success";
	}

	@RequestMapping(value = "/insertAutoSecond")
	public String insertAuto(){
		DataSecond data = new DataSecond();
		data.setUserName("程浩");
		data.setUserSex("男");
		iDataService.insertDataAuto(data);
		return "Success";
	}
}
