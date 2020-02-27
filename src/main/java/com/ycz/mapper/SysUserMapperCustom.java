package com.ycz.mapper;

import java.util.List;

import com.ycz.pojo.SysUser;

public interface SysUserMapperCustom {
	
	public List<SysUser> queryUserByAge(int age);

}
