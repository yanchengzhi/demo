package com.ycz.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ycz.pojo.JSONResult;
import com.ycz.pojo.Resource;

@RestController
public class HelloController {
	
	@Autowired
	private Resource resource;//注入依赖的类
	
	@RequestMapping("/hello")
	public Object hello() {
		return "hello鸭，何立立！";
	}
	
	@RequestMapping("/getResource")
	public JSONResult getResource() {
		Resource bean = new Resource();
		BeanUtils.copyProperties(resource, bean);//将resource里面的属性复制给bean对象
		return JSONResult.ok(bean);
	}


}
