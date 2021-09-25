package com.qa.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	//Constructor to load the Excel so that we dont have to pass the path again and again.
	
	public ExcelDataProvider()
	{
		
		File src = new File("./TestData/Data.xlsx");
		
		//FileInputStream to conver this file into Raw data.
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			 wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			
			System.out.println("Unable to read the excel file"+ e.getMessage());
		}
		}
		
	     
	public String getStringData(int sheetIndex, int row, int col)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
	}
	
	
	
	public String getStringData(String sheetName, int row, int col)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}
	
	
	public double getNumbericData(String sheetName, int row, int col)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}
	
	
	
	
	
	
	
	}

