package com.ycz.task;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task/")
public class DoTask {

	@Autowired
	private AsyncTask asyncTask;// 自动注入依赖类

	@RequestMapping("test1")
	public String test1() throws Exception {
		long st = System.currentTimeMillis();
		Future<Boolean> a = asyncTask.doTask1();
		Future<Boolean> b = asyncTask.doTask2();
		Future<Boolean> c = asyncTask.doTask3();

		while (!a.isDone() || !b.isDone() || !c.isDone()) {
			if (a.isDone() && b.isDone() && c.isDone()) {
				break;
			}
		}

		long et = System.currentTimeMillis();
		String times = "任务全部完成，总耗时：" + (et - st) + "ms";
		System.out.println(times);
		return times;
	}

}
