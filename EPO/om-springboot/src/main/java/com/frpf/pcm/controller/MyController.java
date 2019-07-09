package com.frpf.pcm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //controller里面的方法都以json格式输出，不用再写什么jackjson配置的了
public class MyController {
	@RequestMapping(value = "/my")
	public String hello(){
		return "index indsddp";
	}
}
