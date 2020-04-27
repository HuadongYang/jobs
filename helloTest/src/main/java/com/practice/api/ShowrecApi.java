package com.practice.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/showrec")
public class ShowrecApi {
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getPage() {
		return "showrec/showrec";
	}
}
