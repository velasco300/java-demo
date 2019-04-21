package com.aaa.javademo.common;

import com.aaa.javademo.util.ThreadParam;
import com.aaa.javademo.util.Watch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class LogIntercepter implements HandlerInterceptor {

	private static final Logger log = LoggerFactory.getLogger(LogIntercepter.class);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Watch w = new Watch(request.getRequestURI() + sdf.format(new Date()));
		w.start();
		ThreadParam.set(w);
		log.info(w.startSummary());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if ("/error".equals(request.getRequestURI())) {
			throw new Exception("URL不正确");
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		Watch w = ThreadParam.get();
		w.stop();
		log.info(w.finishSummary());
		ThreadParam.remove();
	}

}
