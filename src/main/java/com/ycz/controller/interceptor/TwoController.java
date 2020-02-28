package com.ycz.controller.interceptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ycz.pojo.User;

@RestController
@RequestMapping("/two/")
public class TwoController {

	@RequestMapping("index")
	public String index(ModelMap map) {
		map.addAttribute("name", "鄢承志");
		return "thymeleaf/index";
	}

	@RequestMapping("center")
	public String center() {
		return "thymeleaf/center/center";
	}

	@RequestMapping("test")
	public String test(ModelMap map) {
		User u = new User("鄢承志", "ycz123456", 25, new Date(), "时也命也！");
		User u2 = new User("何立立", "hl123456", 20, new Date(), "机灵可爱！");
		User u3 = new User("游子意", "yzy123456", 21, new Date(), "大猪蹄子！");
		List<User> userList = new ArrayList<User>();
		userList.add(u);
		userList.add(u2);
		userList.add(u3);
		map.addAttribute("userList", userList);
		return "thymeleaf/test";
	}

	@RequestMapping("postform")
	public String postform(User user) {
		System.out.println(user.getName() + "：" + user.getAge());
		return "redirect:/th/test";
	}

}
