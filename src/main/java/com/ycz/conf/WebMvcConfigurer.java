package com.ycz.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ycz.controller.interceptor.OneInterceptor;
import com.ycz.controller.interceptor.TwoInterceptor;

/**
 * 此类作为拦截器使用，需要继承WebMvcConfigurerAdapter类
 * @author Administrator
 *
 */
@Configuration//必须标注
public class WebMvcConfigurer extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 拦截器按照顺序执行
		 */
		//注册两个拦截器
		registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");//这个只会拦截one里面的方法
		registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**")
		                                             .addPathPatterns("/one/**");//这个会拦截one和two里面的方法
		super.addInterceptors(registry);
	}
	
	

}
