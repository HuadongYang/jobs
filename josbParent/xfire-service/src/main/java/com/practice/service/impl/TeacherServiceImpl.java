package com.practice.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.practice.config.DatabaseConnectionService;
import com.practice.domain.Teacher;
import com.practice.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	private static DatabaseConnectionService connectionService = new DatabaseConnectionService(); 

	@Override
	public List<Teacher> getTeachers() {
		// TODO Auto-generated method stub
		String sql = "select * from teacher";
		Connection conn = connectionService.getConnection();
		List<Teacher> teachers = new ArrayList<Teacher>();
		try{
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
	        while (rs.next()) {
	        	Teacher teacher = new Teacher();
				teacher.setMajor(rs.getString("major"));
				teacher.setHiredate(rs.getString("hiredate"));
				teacher.setName(rs.getString("name"));
				teacher.setwNo(rs.getString("wNo"));
				teachers.add(teacher);
	        }
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return teachers;
	}

}
