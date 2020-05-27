package com.practice.file.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.practice.service.domain.Teacher;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TeacherXML {

	private List<Teacher> teachers;

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return "TeacherXML [teachers=" + teachers + "]";
	}

}
