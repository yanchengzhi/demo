package com.ycz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//开启自动扫描，找到mapper包路径
@MapperScan(basePackages = "com.ycz.mapper")
//spring扫描需要的组件包
@ComponentScan(basePackages = {"com.ycz","org.n3r.idworker"})
@EnableScheduling//开启定时任务
@EnableAsync//开启异步调用方法
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
