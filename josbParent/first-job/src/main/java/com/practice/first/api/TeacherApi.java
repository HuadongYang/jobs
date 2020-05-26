package com.practice.first.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.service.TeacherService;
import com.practice.service.domain.Teacher;
import com.practice.service.impl.TeacherServiceImpl;

@Controller
@RequestMapping("/teacher")
public class TeacherApi {

	private TeacherService techerService = new TeacherServiceImpl();

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void saveTeacher(@ModelAttribute Teacher teacher) {
		techerService.save(teacher);
	}

}
