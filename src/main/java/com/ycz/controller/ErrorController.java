package com.ycz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycz.pojo.JSONResult;

@Controller
@RequestMapping("/err/")
public class ErrorController {
	
	@RequestMapping("error")
	public String error() {
		 
		int a = 1 / 0;//定义一个0做除数的异常byzero
		return "thymeleaf/error";
	}
	
	@RequestMapping("ajaxError")
	public String ajaxError() {
		return "thymeleaf/ajaxerror";
	}
	
	@ResponseBody
	@RequestMapping("getAjaxerror")
	public JSONResult getAjaxerror() {
		int a = 1 / 0;
		return JSONResult.ok();
	}

}
