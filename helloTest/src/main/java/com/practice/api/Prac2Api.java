package com.practice.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/showrec")
public class Prac2Api {
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getPage() {
		return "prac2/showrec";
	}
	
	@RequestMapping(value = "/showTable", method = RequestMethod.GET)
	public ModelAndView getTablePage(ModelAndView mv) {
		List<String> week = Arrays.asList("����һ","���ڶ�","������","������","������","������","������");
		List<String> fruit = Arrays.asList("ƻ��","�㽶", "â��", "����", "���ܹ�", "����", "⨺���" );
		mv.setViewName("prac2/showtable");
		mv.addObject("week", week);
		mv.addObject("fruit", fruit);
		return mv;
	}
}
