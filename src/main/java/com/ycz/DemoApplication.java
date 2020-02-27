package com.ycz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//开启自动扫描，找到mapper包路径
@MapperScan(basePackages = "com.ycz.mapper")
//spring扫描需要的组件包
@ComponentScan(basePackages = {"com.ycz","org.n3r.idworker"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
