package com.ycz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ycz.pojo.Resource;

@Controller
@RequestMapping("/ftl/")
public class FreemarkerController {
	
	@Autowired
	private Resource resource;//自动注入依赖
	
	@RequestMapping("index")
	public String index(ModelMap map) {
		map.addAttribute("resource", resource);
		return "freemarker/index";
	}
	
	@RequestMapping("center")
	public String center() {
		return "freemarker/center/center";
	}

}
