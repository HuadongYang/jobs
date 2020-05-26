package com.practice.client;

import java.util.List;

import org.codehaus.xfire.XFire;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

import com.practice.domain.Teacher;
import com.practice.service.TeacherService;

public class XFireClient {
	
	public static void main(String[] args) {
		  Service serviceModel = new ObjectServiceFactory().create(TeacherService.class);
		  XFire xfire = XFireFactory.newInstance().getXFire();
		  XFireProxyFactory factory = new XFireProxyFactory(xfire);
		  String serviceUrl = "http://localhost:8080/service/TeacherService";
		  TeacherService client = null;
		  try {
		   client = (TeacherService) factory.create(serviceModel, serviceUrl);
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		  List<Teacher> teachers= client.getTeachers();
		  for (int i = 0; i < teachers.size(); i++) {
			System.out.println(teachers.get(i));
		}
	}

}
