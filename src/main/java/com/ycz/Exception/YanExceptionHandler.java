package com.ycz.Exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.ycz.pojo.JSONResult;

/**
 * 定义一个助手类 用于处理异常
 * 
 * @author Administrator
 *
 */
@ControllerAdvice // 表明这是一个错误助手类
public class YanExceptionHandler {

	// 错误页面的名称，定义为常量
	public static final String ERROR_VIEW = "error";

//	@ExceptionHandler(value = Exception.class)
//	public Object errorHandler(HttpServletRequest request, HttpServletResponse response,
//			Exception e) throws Exception{
//		e.printStackTrace();// 打印异常轨迹
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("exception", e);
//		mav.addObject("url", request.getRequestURL());
//		mav.setViewName(ERROR_VIEW);// 设置视图名称
//		return mav;
//	}

	@ExceptionHandler(value = Exception.class)
	public Object errorHandler(HttpServletRequest reqest, HttpServletResponse response, 
			Exception e) throws Exception {

		e.printStackTrace();

		if (isAjax(reqest)) {
			return JSONResult.errorException(e.getMessage());
		} else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("exception", e);
			mav.addObject("url", reqest.getRequestURL());
			mav.setViewName(ERROR_VIEW);
			return mav;
		}
	}

	/**
	 * 
	 * @Title: IMoocExceptionHandler.java
	 * @Package com.imooc.exception
	 * @Description: 判断是否是ajax请求 Copyright: Copyright (c) 2017
	 *               Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
	 * 
	 * @author leechenxiang
	 * @date 2017年12月3日 下午1:40:39
	 * @version V1.0
	 */
	public static boolean isAjax(HttpServletRequest httpRequest) {
		return (httpRequest.getHeader("X-Requested-With") != null
				&& "XMLHttpRequest".equals(httpRequest.getHeader("X-Requested-With").toString()));
	}

}
