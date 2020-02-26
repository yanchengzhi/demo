package com.ycz.Exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ycz.pojo.JSONResult;

/**
 * 处理Ajax错误的助手类
 * 
 * @author Administrator
 *
 */
@ControllerAdvice
public class YanAjaxExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public JSONResult defaultErrorHandler(HttpServletRequest request, Exception e) 
		    throws Exception {
		e.printStackTrace();
		return JSONResult.errorException(e.getMessage());
	}
}
