package com.ycz.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class User {
	
	private String name;
	@JsonIgnore//密码字段不显示出来
	private String password;
	private Integer age;
	//返回的日期进行格式化
	@JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss a",locale = "zh",timezone = "GMT+8")
	private Date birth;
	@JsonInclude(Include.NON_NULL)//字段为null时，不显示出来
	private String descs;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getDescs() {
		return descs;
	}
	public void setDescs(String descs) {
		this.descs = descs;
	}
	
	public User() {
		
	}
	
	public User(String name,String password,Integer age,Date birth,String descs) {
		this.name = name;
		this.password = password;
		this.age = age;
		this.birth = birth;
		this.descs = descs;
	}

}
