package com.ycz.service;

import java.util.List;

import com.ycz.pojo.SysUser;

/**
 * 接口
 * @author Administrator
 *
 */
public interface UserService {
	
	public void saveUser(SysUser user) throws Exception;//添加用户
	
	public void updateUser(SysUser user);//修改用户信息
	
	public void deleteUser(String id);//删除用户
	
	public SysUser queryUserById(String id);//通过Id查询用户
	
	public List<SysUser> queryUserList(SysUser user);//按指定条件查询
	
	public List<SysUser> queryUserListPaged(SysUser user,Integer page,Integer pageSize);//分页查询

	public List<SysUser> queryUserByAge(int age);//自定义的查询业务
	
	public void saveUserTransactional(SysUser user);//事务
}
