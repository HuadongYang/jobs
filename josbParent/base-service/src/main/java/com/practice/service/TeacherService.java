package com.practice.service;

import java.util.List;

import com.practice.service.domain.Teacher;



public interface TeacherService {
	
	void save(Teacher techer);
	
	List<Teacher> getTeachers();

}
