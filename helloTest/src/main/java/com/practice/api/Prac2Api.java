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
		List<String> week = Arrays.asList("星期一","星期二","星期三","星期四","星期五","星期六","星期日");
		List<String> fruit = Arrays.asList("苹果","香蕉", "芒果", "梨子", "哈密瓜", "西瓜", "猕猴桃" );
		mv.setViewName("prac2/showtable");
		mv.addObject("week", week);
		mv.addObject("fruit", fruit);
		return mv;
	}
}
