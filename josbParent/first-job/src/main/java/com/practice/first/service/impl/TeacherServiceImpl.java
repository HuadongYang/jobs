package com.practice.first.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.practice.first.dao.TeacherDao;
import com.practice.first.dto.Teacher;
import com.practice.first.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherDao teacherDao;

	@Override
	public void save(Teacher techer) {
		
		teacherDao.save(techer);
	}

}
