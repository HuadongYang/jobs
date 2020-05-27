package com.practice.file.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.practice.file.FileService;
import com.practice.service.TeacherService;
import com.practice.service.domain.Teacher;
import com.practice.service.impl.TeacherServiceImpl;

public class TextService implements FileService {

	private static TeacherService techerService = new TeacherServiceImpl();

	@Override
	public void input(String textPath) throws Exception {
		// TODO Auto-generated method stub
		File file = new File(textPath);
		InputStream in = new FileInputStream(file);
		String encryptString = IOUtils.toString(in, "UTF-8");
		List<Teacher> teachers = JSON.parseObject(encryptString,
				new TypeReference<List<Teacher>>() {
				});
		for (int i = 0; i < teachers.size(); i++) {
			techerService.save(teachers.get(i));
		}
	}

	@Override
	public void output(String fileFolderPath) throws IOException {
		// TODO Auto-generated method stub
		List<Teacher> teachers = techerService.getTeachers();
		String jsonString = JSON.toJSONString(teachers);

		File file = new File(fileFolderPath);
		if (!file.exists()) {
			file.createNewFile();
		}

		BufferedWriter writer = new BufferedWriter(new FileWriter(
				fileFolderPath));
		writer.write(jsonString);
		writer.close();

	}

	public static void main(String[] args) throws Exception {
		TextService xmlService = new TextService();
		xmlService
				.output("C:\\Users\\yanghd\\Desktop\\temp\\xfile\\testWord.docx");
	}
}
