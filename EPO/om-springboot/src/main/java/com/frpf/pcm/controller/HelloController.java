package com.frpf.pcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //controller里面的方法都以json格式输出，不用再写什么jackjson配置的了
public class HelloController {
	@RequestMapping(value = "/in")
	public String hello(){
		return "index";
	}
}
