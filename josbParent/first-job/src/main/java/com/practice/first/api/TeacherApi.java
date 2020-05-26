package com.practice.first.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.first.dto.Teacher;
import com.practice.first.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherApi {
	
	@Autowired
	private TeacherService techerService;
	
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void saveTeacher(@ModelAttribute Teacher teacher){
		techerService.save(teacher);
	}
	

}
