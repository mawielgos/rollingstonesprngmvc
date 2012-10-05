package com.rollingstone.orderprocessing.web.tools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * Another exmaple 
 * 
 * public class MeasurementInterceptor extends HandlerInterceptorAdapter {
 * 
 */

public class MeasurementInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		 long startTime = (Long) request.getAttribute("startTime");
	        request.removeAttribute("startTime");
	        long endTime = System.currentTimeMillis();
	        modelAndView.addObject("handlingTime", endTime - startTime);
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		 long startTime = System.currentTimeMillis();
	        request.setAttribute("startTime", startTime);
	        return true;
	}

}
