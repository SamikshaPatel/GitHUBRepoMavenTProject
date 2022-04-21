package com.SuretyCloud.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil2 {

	static Workbook book;
	static Sheet sheet;
	
	public static String TESTDATA_SHEET_PATH="/Users/shamiksha/Documents/SeleniumProject2020/TestDataFiles/TestData2-XLSX.xlsx";
	
	public static Object[][] getTestData(String sheetName) {
	
	
		FileInputStream file= null;
		try {
			file= new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		sheet=book.getSheet(sheetName);		
		
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		Object [] [] data = new Object [lastRowNum][lastCellNum];
	
		for (int i=0; i< lastRowNum;i++){
			int lastCellRowNum = sheet.getRow(i).getLastCellNum();
			for (int k=0; k< lastCellRowNum ;k++) {
				Cell cell = sheet.getRow(i+1).getCell(k);
//				if (cell == null) {
//					cell = "";
//				}
					data[i][k]= cell.toString();
					//data[i][k]= sheet.getRow(i).getCell(k).toString();
			}
		}
			return data;	
	}	
}
