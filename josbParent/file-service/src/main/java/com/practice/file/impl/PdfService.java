package com.practice.file.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.practice.file.FileService;
import com.practice.service.TeacherService;
import com.practice.service.domain.Teacher;
import com.practice.service.impl.TeacherServiceImpl;

public class PdfService implements FileService {

	private static TeacherService techerService = new TeacherServiceImpl();

	@Override
	public void input(String textPath) throws Exception {
		// TODO Auto-generated method stub

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

		Document document = new Document(PageSize.A4);
		PdfWriter instance = PdfWriter.getInstance(document,
				new FileOutputStream(file));
		instance.setInitialLeading(30);
		document.open();

		for (int i = 0; i < teachers.size(); i++) {
			document.add(new Chunk(JSON.toJSONString(teachers.get(i))));
			document.add(Chunk.NEWLINE);
		}
		document.close();
	}

	public static void main(String[] args) throws Exception {
		PdfService xmlService = new PdfService();
		xmlService
				.output("C:\\Users\\yanghd\\Desktop\\temp\\xfile\\testPDf.pdf");
	}
}
