package com.practice.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class Prac1Api {
	
	private static Map<String, String> users = new HashMap<String, String>();
	
	
	private String host = "http://localhost:8080";
	private String rootPath = "/hello";
	private static String path = "/hello";
	private static String loginPage = path + "/login";
	private static String loginSuccessPage = path + "/loginSuccess";
	private static String loginFailurePage = path + "/loginFailure";
	private static String helloPage = path + "/hello";
	static {
		users.put("admin", "admin");
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getPage() {
		return helloPage;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(ModelAndView mv) {
		mv.setViewName(loginPage);
		mv.addObject("curentEnv", host);
		return mv;
	}
	
	@RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
	public ModelAndView loginSuccess(@RequestParam("username") String username, ModelAndView mv) {
		mv.setViewName(loginSuccessPage);
		mv.addObject("username", username);
		return mv;
	}
	
	@RequestMapping(value = "/loginFailure", method = RequestMethod.GET)
	public ModelAndView loginFailure(ModelAndView mv) {
		mv.setViewName(loginFailurePage);
		String loginUrl = host + rootPath + "/login";
		mv.addObject("loginUrl", loginUrl);
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		String realPassword = users.get(username);
		if (realPassword != null && realPassword.equals(password)) {
			return "redirect:"+rootPath+"/loginSuccess?username=" + username;
		}
			
		return "redirect:"+rootPath+"/loginFailure";
	}
}
