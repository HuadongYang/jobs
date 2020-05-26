package com.practice.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.practice.service.config.DatabaseConnectionService;
import com.practice.service.domain.Teacher;

public class TeacherDao {

	private static DatabaseConnectionService connectionService = new DatabaseConnectionService();

	public void save(Teacher techer) {
		String sql = "INSERT INTO `teacher` (`wNo`, `name`, `major`,`hiredate`)VALUES('?','?','?','?')";
		sql = sql.replaceFirst("\\?", techer.getwNo())
				.replaceFirst("\\?", techer.getName())
				.replaceFirst("\\?", techer.getMajor())
				.replaceFirst("\\?", techer.getHiredate());

		Connection conn = connectionService.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<Teacher> getTeachers() {
		// TODO Auto-generated method stub
		String sql = "select * from teacher";
		Connection conn = connectionService.getConnection();
		List<Teacher> teachers = new ArrayList<Teacher>();
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
