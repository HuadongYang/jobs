package com.practice.service.impl;

import java.util.List;

import com.practice.service.TeacherService;
import com.practice.service.dao.TeacherDao;
import com.practice.service.domain.Teacher;

public class TeacherServiceImpl implements TeacherService {

	private TeacherDao techerDao = new TeacherDao();

	@Override
	public void save(Teacher techer) {
		techerDao.save(techer);
	}

	@Override
	public List<Teacher> getTeachers() {
		// TODO Auto-generated method stub
		return techerDao.getTeachers();
	}
}
