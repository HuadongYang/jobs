package com.practice.file.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.practice.file.FileService;
import com.practice.service.TeacherService;
import com.practice.service.domain.Teacher;
import com.practice.service.impl.TeacherServiceImpl;

public class WordService implements FileService {

	private static TeacherService techerService = new TeacherServiceImpl();

	@Override
	public void input(String textPath) throws Exception {
		// TODO Auto-generated method stub
		InputStream in = new FileInputStream(textPath);

		XWPFDocument xdoc = new XWPFDocument(in);
		XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
		String json = extractor.getText();

		in.close();
		xdoc.close();
		extractor.close();
		List<Teacher> teachers = JSON.parseObject(json,
				new TypeReference<List<Teacher>>() {
				});

		for (int i = 0; i < teachers.size(); i++) {
			techerService.save(teachers.get(i));
		}

	}

	@Override
	public void output(String fileFolderPath) throws Exception {
		// TODO Auto-generated method stub
		List<Teacher> teachers = techerService.getTeachers();
		String jsonString = JSON.toJSONString(teachers);

		File file = new File(fileFolderPath);
		if (!file.exists()) {
			file.createNewFile();
		}

		OutputStream outputStream = new FileOutputStream(fileFolderPath);

		XWPFDocument document = new XWPFDocument();
		XWPFParagraph p1 = document.createParagraph();
		XWPFRun r1 = p1.createRun();
		r1.setText(jsonString);
		document.write(outputStream);
		outputStream.close();
		document.close();
	}

	public static void main(String[] args) throws Exception {
		WordService xmlService = new WordService();
		xmlService
				.input("C:\\Users\\yanghd\\Desktop\\temp\\xfile\\testWord.docx");
	}
}
