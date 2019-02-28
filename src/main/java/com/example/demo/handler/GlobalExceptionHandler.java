package com.example.demo.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	private Map<String, Object> exceptionHandler(HttpServletRequest req, Exception e){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", false);
		map.put("errorMsg", "操作错误");
		return map;
	}
	
}
