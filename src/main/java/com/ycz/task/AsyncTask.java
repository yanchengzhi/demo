package com.ycz.task;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {

	@Async//异步方法，不写这个标注就是同步任务，按顺序执行
	public Future<Boolean> doTask1() throws Exception {
		long st = System.currentTimeMillis();
		Thread.sleep(2000);// 休眠两分钟
		long et = System.currentTimeMillis();
		System.out.println("任务1耗时：" + (et - st) + "ms");
		return new AsyncResult<>(true);
	}
	
	@Async
	public Future<Boolean> doTask2() throws Exception {
		long st = System.currentTimeMillis();
		Thread.sleep(1000);// 休眠两分钟
		long et = System.currentTimeMillis();
		System.out.println("任务2耗时：" + (et - st) + "ms");
		return new AsyncResult<>(true);
	}
	
	@Async
	public Future<Boolean> doTask3() throws Exception {
		long st = System.currentTimeMillis();
		Thread.sleep(500);// 休眠两分钟
		long et = System.currentTimeMillis();
		System.out.println("任务3耗时：" + (et - st) + "ms");
		return new AsyncResult<>(true);
	}

}
