package com.ycz.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTasks {
	
	//指定一个日期格式化的格式
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	//定义每过5秒执行一次
//	@Scheduled(fixedRate = 5000)
	@Scheduled(cron = "10-30 * * * * ? " )//使用core表达式，但是只支持6位，超过会报错
	public void reportCurrentTime() {
		System.out.println("现在时间是："+dateFormat.format(new Date()));
	}
}
