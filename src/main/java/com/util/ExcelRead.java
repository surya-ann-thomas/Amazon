package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.TestBase;


public class ExcelRead extends TestBase {
	

	public ExcelRead() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Map<String,String> getMap() throws IOException {
		HashMap<String,String> data=new HashMap<String,String>();
		try {
			FileInputStream fis=new FileInputStream("D:\\\\selenium_training\\\\AmazonPom\\\\src\\\\main\\\\java\\\\testData\\\\Book4.xlsx");
			
		
			Workbook workbook=new XSSFWorkbook(fis);
		 Sheet sheet=(XSSFSheet)workbook.getSheetAt(0);
		
		for(int i=0;i<2;i++) {
			data.put(sheet.getRow(0).getCell(i).toString(), sheet.getRow(1).getCell(i).toString());
		}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return data;
		
	}

}
