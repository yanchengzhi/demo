package com.ycz.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.support.json.JSONUtils;
import com.ycz.pojo.JSONResult;
import com.ycz.pojo.SysUser;
import com.ycz.pojo.User;
import com.ycz.utils.JsonUtils;
import com.ycz.utils.RedisOperator;

@RestController
@RequestMapping("/redis/")
public class RedisController {
	
	@Autowired
	private StringRedisTemplate strRedis;//注入一个模板组件
	
	@Autowired
	private RedisOperator redis;//注入定义好的组件依赖
	
	/*存取普通的字符出现韩*/
	@RequestMapping("test")
	public JSONResult test() {
		strRedis.opsForValue().set("name", "鄢承志");
		return JSONResult.ok(strRedis.opsForValue().get("name"));
	}
	
	/*存取对象*/
	@RequestMapping("testObj")
	public JSONResult testObj() {
		SysUser user = new SysUser();
		user.setId("100001");
		user.setUsername("何立立");
		user.setPassword("heli520");
		user.setIsdelete(1);
		user.setRegisttime(new Date());
		strRedis.opsForValue().set("json:user", JsonUtils.objectToJson(user));//存值
		SysUser jsonUser = JsonUtils.jsonToPojo(strRedis.opsForValue().get("json:user"), SysUser.class);
		return JSONResult.ok(jsonUser);
	}
	
	/*使用封装好的方法操作*/
	@RequestMapping("test2")
	public JSONResult test2() {
		User u = new User();
		u.setName("鄢承志");
		u.setPassword("ycz123456");
		u.setAge(25);
		u.setBirth(new Date());
		u.setDescs("喜欢何立立！");

		
		User u2 = new User();
		u2.setName("何立立");
		u2.setPassword("hl123456");
		u2.setAge(20);
		u2.setBirth(new Date());
		u2.setDescs("考验考验你！");
		
		User u3 = new User();
		u3.setName("游子意");
		u3.setPassword("yzy123456");
		u3.setAge(21);
		u3.setBirth(new Date());
		u3.setDescs("我就是女汉子！");
		
		List<User> userList = new ArrayList<User>();
		userList.add(u);
		userList.add(u2);
		userList.add(u3);
		
		redis.set("json:info:userlist",JsonUtils.objectToJson(userList),3000);//存值
		String userListJson = redis.get("json:info:userlist");
		List<User> userListBornList = JsonUtils.jsonToList(userListJson, User.class);
		return JSONResult.ok(userListBornList);
	}

}
