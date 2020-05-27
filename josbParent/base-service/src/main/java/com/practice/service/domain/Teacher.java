package com.practice.service.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Teacher {
	@ExcelIgnore
	private Integer id;

	@ExcelProperty(index = 0, value = "职工号")
	@XmlAttribute(name = "职工号")
	private String wNo;
	@ExcelProperty(index = 1, value = "姓名")
	@XmlAttribute(name = "姓名")
	private String name;
	@ExcelProperty(index = 2, value = "专业")
	@XmlAttribute(name = "专业")
	private String major;
	@ExcelProperty(index = 3, value = "入职年份")
	@XmlAttribute(name = "入职年份")
	private String hiredate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getwNo() {
		return wNo;
	}

	public void setwNo(String wNo) {
		this.wNo = wNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", wNo=" + wNo + ", name=" + name
				+ ", major=" + major + ", hiredate=" + hiredate + "]";
	}

}
