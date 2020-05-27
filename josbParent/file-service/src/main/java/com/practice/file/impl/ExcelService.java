package com.practice.file.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.event.SyncReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.read.metadata.ReadWorkbook;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.practice.file.FileService;
import com.practice.service.TeacherService;
import com.practice.service.domain.Teacher;
import com.practice.service.impl.TeacherServiceImpl;

public class ExcelService implements FileService {

	private static TeacherService techerService = new TeacherServiceImpl();

	@Override
	public void input(String textPath) throws Exception {
		// TODO Auto-generated method stub
		File file = new File(textPath);
		InputStream in = new FileInputStream(file);
		ReadWorkbook readWorkbook = new ReadWorkbook();
		readWorkbook.setInputStream(in);

		SyncReadListener syncReadListener = new SyncReadListener();

		ExcelReader excelReader = EasyExcel.read(in, Teacher.class,
				syncReadListener).build();
		ReadSheet readSheet = EasyExcel.readSheet(0).build();
		excelReader.read(readSheet);
		List<Object> teachers = syncReadListener.getList();
		excelReader.finish();

		for (int i = 0; i < teachers.size(); i++) {
			techerService.save((Teacher) teachers.get(i));
		}
	}

	@Override
	public void output(String fileFolderPath) throws Exception {
		// TODO Auto-generated method stub
		List<Teacher> teachers = techerService.getTeachers();

		File file = new File(fileFolderPath);
		if (!file.exists()) {
			file.createNewFile();
		}

		OutputStream outputStream = new FileOutputStream(file);

		ExcelWriter excelWriter = EasyExcel.write(outputStream, Teacher.class)
				.build();
		WriteSheet writeSheet = EasyExcel.writerSheet(0, "teacher").build();

		excelWriter.write(teachers, writeSheet);
		excelWriter.finish();

	}

	public static void main(String[] args) throws Exception {
		ExcelService xmlService = new ExcelService();
		xmlService
				.input("C:\\Users\\yanghd\\Desktop\\temp\\xfile\\testExcel.xlsx");
	}

}
