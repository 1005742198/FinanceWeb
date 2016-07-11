package com.obob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class WelcomeController extends BaseController {
	
	/**
	 * 欢迎
	 * @return Object
	 * @author hongbo.zhao
	 * 2016年7月10日 下午2:22:27
	 */
	@RequestMapping("/me")
	@ResponseBody
	public Object welcome() {
		ModelAndView mv = init("index");
		return mv;
	}
	@RequestMapping("/info")
	public Object info() {
		return viewPath+"index";
	}
}
