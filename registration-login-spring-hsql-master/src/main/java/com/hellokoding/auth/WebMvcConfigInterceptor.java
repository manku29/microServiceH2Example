/**
 * 
 */
package com.hellokoding.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.hellokoding.auth.web.RequestProcessingTimeInterceptor;

/**
 * @author Ramavi
 *
 */
@Configuration
public class WebMvcConfigInterceptor extends WebMvcConfigurerAdapter {

	
	/**
	 * {@inheritDoc}
	 * <p>This implementation is empty.
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestProcessingTimeInterceptor()).
		addPathPatterns("/registration");
		
		
		
	}
	
}
