package com.practice.service;

public class Rectangle {
	private int width;
	private int height;
	private String bgcolor;
	
	public Rectangle(){}
	
	public Rectangle(int width, int height, String bgcolor) {
		super();
		this.width = width;
		this.height = height;
		this.bgcolor = bgcolor;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getBgcolor() {
		return bgcolor;
	}
	public void setBgcolor(String bgcolor) {
		
		this.bgcolor = bgcolor;
	}
	
	public int area(){
		return this.width * this.height;
	}
	
	
}
