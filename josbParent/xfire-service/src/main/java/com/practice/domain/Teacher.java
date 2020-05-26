package com.practice.domain;

public class Teacher {
	
	private Integer id;
	
	private String wNo;

	private String name;
	
	private String major;
	
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
