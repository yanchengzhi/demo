package com.ycz.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser {
    /**
     * 主键ID
     */
    @Id
    private String id;

    /**
     * 登录名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private int sex;

    /**
     * 职业类型
     */
    private Integer job;

    /**
     * 头像地址
     */
    @Column(name = "faceImage")
    private String faceimage;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String district;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 权限的盐
     */
    @Column(name = "authSalt")
    private String authsalt;

    /**
     * 最后一次的登录IP
     */
    @Column(name = "lastLoginIp")
    private String lastloginip;

    /**
     * 最后登录时间
     */
    @Column(name = "lastLoginTime")
    private Date lastlogintime;

    /**
     * 是否删除
     */
    @Column(name = "isDelete")
    private int isdelete;

    /**
     * 注册时间
     */
    @Column(name = "registTime")
    private Date registtime;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取登录名
     *
     * @return username - 登录名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置登录名
     *
     * @param username 登录名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public int getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param i 性别
     */
    public void setSex(int i) {
        this.sex = i;
    }

    /**
     * 获取职业类型
     *
     * @return job - 职业类型
     */
    public Integer getJob() {
        return job;
    }

    /**
     * 设置职业类型
     *
     * @param job 职业类型
     */
    public void setJob(Integer job) {
        this.job = job;
    }

    /**
     * 获取头像地址
     *
     * @return faceImage - 头像地址
     */
    public String getFaceimage() {
        return faceimage;
    }

    /**
     * 设置头像地址
     *
     * @param faceimage 头像地址
     */
    public void setFaceimage(String faceimage) {
        this.faceimage = faceimage;
    }

    /**
     * 获取省
     *
     * @return province - 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省
     *
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取市
     *
     * @return city - 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置市
     *
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取区
     *
     * @return district - 区
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 设置区
     *
     * @param district 区
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * 获取详细地址
     *
     * @return address - 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细地址
     *
     * @param address 详细地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取权限的盐
     *
     * @return authSalt - 权限的盐
     */
    public String getAuthsalt() {
        return authsalt;
    }

    /**
     * 设置权限的盐
     *
     * @param authsalt 权限的盐
     */
    public void setAuthsalt(String authsalt) {
        this.authsalt = authsalt;
    }

    /**
     * 获取最后一次的登录IP
     *
     * @return lastLoginIp - 最后一次的登录IP
     */
    public String getLastloginip() {
        return lastloginip;
    }

    /**
     * 设置最后一次的登录IP
     *
     * @param lastloginip 最后一次的登录IP
     */
    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip;
    }

    /**
     * 获取最后登录时间
     *
     * @return lastLoginTime - 最后登录时间
     */
    public Date getLastlogintime() {
        return lastlogintime;
    }

    /**
     * 设置最后登录时间
     *
     * @param lastlogintime 最后登录时间
     */
    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    /**
     * 获取是否删除
     *
     * @return isDelete - 是否删除
     */
    public int getIsdelete() {
        return isdelete;
    }

    /**
     * 设置是否删除
     *
     * @param i 是否删除
     */
    public void setIsdelete(int i) {
        this.isdelete = i;
    }

    /**
     * 获取注册时间
     *
     * @return registTime - 注册时间
     */
    public Date getRegisttime() {
        return registtime;
    }

    /**
     * 设置注册时间
     *
     * @param registtime 注册时间
     */
    public void setRegisttime(Date registtime) {
        this.registtime = registtime;
    }
}