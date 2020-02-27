package com.ycz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.ycz.mapper.SysUserMapper;
import com.ycz.mapper.SysUserMapperCustom;
import com.ycz.pojo.SysUser;

import tk.mybatis.mapper.entity.Example;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private SysUserMapper userMapper;// 自动注入映射文件

	@Autowired
	private SysUserMapperCustom uCustom;// 注入自定义的查询接口

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveUser(SysUser user) throws Exception {
		userMapper.insert(user);

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateUser(SysUser user) {
		// userMapper.updateByPrimaryKeySelective(user);//通过主键修改信息
		userMapper.updateByPrimaryKey(user);// 注意这两个方法的区别

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteUser(String id) {
		userMapper.deleteByPrimaryKey(id);

	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public SysUser queryUserById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<SysUser> queryUserList(SysUser user) {
		Example example = new Example(SysUser.class);// 获取example实例
		Example.Criteria criteria = example.createCriteria();
		if (!StringUtils.isEmptyOrWhitespace(user.getProvince())) {
			criteria.andEqualTo("province", user.getProvince());
		}
		if (!StringUtils.isEmptyOrWhitespace(user.getJob().toString())) {
			criteria.andEqualTo("job", user.getJob());
		}
		List<SysUser> userList = userMapper.selectByExample(example);
		return userList;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);// 开始分页
		Example example = new Example(SysUser.class);
		Example.Criteria criteria = example.createCriteria();
		if (!StringUtils.isEmptyOrWhitespace(user.getFaceimage())) {
			criteria.andEqualTo("faceimage", user.getFaceimage());
		}
		example.orderBy("username").desc();// 按用户名排序
		List<SysUser> userList = userMapper.selectByExample(example);
		return userList;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<SysUser> queryUserByAge(int age) {
		List<SysUser> userList = uCustom.queryUserByAge(age);
		if (userList != null && !userList.isEmpty()) {
			return userList;
		} else {
			return null;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveUserTransactional(SysUser user) {
		userMapper.insert(user);
		int a = 1 /0;
		user.setIsdelete(1);
		userMapper.updateByPrimaryKeySelective(user);
	}

}
