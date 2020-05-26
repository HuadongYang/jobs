package com.practice.first.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.practice.first.dto.Teacher;

@Component
public class TeacherDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save(Teacher teacher) {
		String sql = "INSERT INTO `teacher` (`wNo`,	`name`,	`major`,`hiredate`)VALUES(?,?,?,?)";
		jdbcTemplate.update(sql, teacher.getwNo(), teacher.getName(), teacher.getMajor(), teacher.getHiredate());
	}

}
