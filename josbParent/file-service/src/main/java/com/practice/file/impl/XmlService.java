package com.practice.file.impl;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.practice.file.FileService;
import com.practice.file.vo.TeacherXML;
import com.practice.service.TeacherService;
import com.practice.service.domain.Teacher;
import com.practice.service.impl.TeacherServiceImpl;

public class XmlService implements FileService {
	private static TeacherService techerService = new TeacherServiceImpl();

	@Override
	public void input(String textPath) throws Exception {
		// TODO Auto-generated method stub
		File file = new File(textPath);
		if (!file.exists()) {
			file.createNewFile();
		}
		JAXBContext jc = JAXBContext.newInstance(TeacherXML.class);
		Unmarshaller unm = jc.createUnmarshaller();
		TeacherXML data = (TeacherXML) unm.unmarshal(file);
		List<Teacher> teachers = data.getTeachers();
		for (int i = 0; i < teachers.size(); i++) {
			techerService.save(teachers.get(i));
		}

		System.out.println(data);
	}

	@Override
	public void output(String fileFolderPath) throws Exception {
		// TODO Auto-generated method stub
		List<Teacher> teachers = techerService.getTeachers();

		TeacherXML teacherXML = new TeacherXML();
		teacherXML.setTeachers(teachers);

		File file = new File(fileFolderPath);
		if (!file.exists()) {
			file.createNewFile();
		}

		JAXBContext jc = JAXBContext.newInstance(TeacherXML.class);
		Marshaller ms = jc.createMarshaller();
		ms.marshal(teacherXML, file);
	}

	public static void main(String[] args) throws Exception {
		XmlService xmlService = new XmlService();
		xmlService.input("C:\\Users\\yanghd\\Desktop\\temp\\xfile\\test.xml");
	}

}
