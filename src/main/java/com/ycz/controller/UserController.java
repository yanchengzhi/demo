package com.ycz.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ycz.pojo.JSONResult;
import com.ycz.pojo.User;

@RestController   //@RestController = @Controller + @ResponseBody
@RequestMapping("/user/")
public class UserController {

	@RequestMapping("getUser")
	public User getUser() {
		User u = new User();
		u.setName("鄢承志");
		u.setPassword("ycz123456");
		u.setAge(24);
		u.setBirth(new Date());
		return u;
	}

	@RequestMapping("getUserJson")
	public JSONResult getUserJson() {
		User u = new User("何立立", "heli123456", 20, new Date(), "超喜欢你！");
		return JSONResult.ok(u);
	}

}
