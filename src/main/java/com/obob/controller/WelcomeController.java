package com.obob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class WelcomeController {
	
	/**
	 * 欢迎
	 * @return Object
	 * @author hongbo.zhao
	 * 2016年7月10日 下午2:22:27
	 */
	@RequestMapping("/me")
	public Object welcome() {
		ModelAndView mv = new ModelAndView("index");
		
	}
}
