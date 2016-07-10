/**
* @author hongbo.zhao 
* @date 2016年7月10日 下午2:25:56 
 */
package com.obob.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * 请输入类用途描述，与人方便自己方便
 * @author hongbo.zhao
 * 2016年7月10日 下午2:25:56
 */
@Controller
public class BaseController {

	protected String viewPath = "/webapps/jsp/";
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	
	protected ModelAndView init(String pathName) {
		ModelAndView mv = new ModelAndView(viewPath + pathName);
		mv.addObject("ctx", request.getContextPath());
		return mv;
	}
}
