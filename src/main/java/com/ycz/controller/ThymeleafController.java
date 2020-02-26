package com.ycz.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ycz.pojo.User;

@Controller
@RequestMapping("/th/")
public class ThymeleafController {

	@RequestMapping("index")
	public String index(ModelMap map) {
		map.addAttribute("name", "thymeleaf-yanchengzhi");
		return "thymeleaf/index";
	}

	@RequestMapping("center")
	public String center() {
		return "thymeleaf/center/center";
	}

	@RequestMapping("test")
	public String test(ModelMap map) {
		List <User> userList = new ArrayList<User>();
		User u = new User("何立立", "hl123456", 20, new Date(), "<font color='green'><b>超级喜欢你！</b></font>");
		User u2 = new User("鄢承志","ycz951824",25,new Date(),"想要追求何立立！");
		User u3 = new User("游子意","yzy123456",22,new Date(),"你个油兔子！");
		userList.add(u);
		userList.add(u2);
		userList.add(u3);
		map.addAttribute("user", u);
		map.addAttribute("userList",userList);
		return "thymeleaf/test";
	}

	@PostMapping("postForm")
	public String postForm(User u) {
		System.out.println("名字：" + u.getName());
		System.out.println("年龄：" + u.getAge());
		// 重定向
		return "redirect:/th/test";
	}

}
