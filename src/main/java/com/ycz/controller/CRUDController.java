package com.ycz.controller;

import java.util.Date;
import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ycz.pojo.JSONResult;
import com.ycz.pojo.SysUser;
import com.ycz.service.UserService;

@RestController
@RequestMapping("/mybatis/")
public class CRUDController {

	@Autowired
	private UserService service;// 自动注入服务层组件

	@Autowired
	private Sid sid;// 自动注入工具类组件

	/**
	 * 添加用户
	 */
	@RequestMapping("saveUser")
	public JSONResult saveUser() throws Exception {
		String uId = sid.nextShort();

		SysUser user = new SysUser();
		user.setId(uId);
		user.setUsername("鄢承志" + new Date());
		user.setNickname("鄢承志" + new Date());
		user.setPassword("ycz123456");
		user.setIsdelete(0);
		user.setRegisttime(new Date());

		service.saveUser(user);
		return JSONResult.ok("添加成功！");
	}

	/**
	 * 修改用户信息
	 *
	 */
	@RequestMapping("updateUser")
	public JSONResult updateUser() {
		SysUser user = new SysUser();
		user.setId("20200227");
		user.setUsername("20200227" + new Date());
		user.setNickname("20200227" + new Date());
		user.setPassword("ycz123456-20200227");

		service.updateUser(user);
		return JSONResult.ok("修改成功！");
	}

	/**
	 * 通过主键删除用户
	 */
	@RequestMapping("deleteUser")
	public JSONResult deleteUser(String id) {
		service.deleteUser("12345678");
		return JSONResult.ok("删除成功！");
	}

	/**
	 * 通过id查询用户
	 */
	@RequestMapping("queryUserById")
	public JSONResult queryUserById(String id) {
		return JSONResult.ok(service.queryUserById(id));
	}

	/**
	 * 按指定条件查找用户列表
	 */
	@RequestMapping("queryUserList")
	public JSONResult queryUserList(String province, int job) {
		SysUser user = new SysUser();
		user.setProvince(province);
		user.setJob(job);
		List<SysUser> userList = service.queryUserList(user);
		return JSONResult.ok(userList);
	}

	/**
	 * 
	 * @param page     为当前页码
	 * @param pageSize 为每页有多少条记录
	 * @return
	 */
	@RequestMapping("queryUserListPaged")
	public JSONResult queryUserListPaged(Integer page, Integer pageSize) {
		SysUser user = new SysUser();
		user.setFaceimage("机关");
		;// 只查询性别为男的记录列表
		List<SysUser> userList = service.queryUserListPaged(user, page, pageSize);
		return JSONResult.ok(userList);
	}

	/**
	 * 自定义的查询业务
	 */
	@RequestMapping("queryUserByAge")
	public JSONResult queryUserByAge(int age) {
		return JSONResult.ok(service.queryUserByAge(age));
	}

	/**
	 * 使用事务
	 */
	@RequestMapping("saveUserTransactional")
	public JSONResult saveUserTransactional() {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("lalala" + new Date());
		user.setNickname("lalala" + new Date());
		user.setPassword("abc666666");
		user.setIsdelete(0);
		user.setRegisttime(new Date());
		
		service.saveUserTransactional(user);
		return JSONResult.ok("保存成功！");
	}
}
