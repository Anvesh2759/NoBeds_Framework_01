package com.app.nobeds.genericutility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel implements PathConstants
{
	static Workbook book;
	static Sheet sheet;
	static Row row;
	static Cell cell;
	
	public static void openExcel()
	{
		try 
		{
			book=WorkbookFactory.create(new FileInputStream(excelfilepath));
		} 
		catch (Exception e) 
		{
			
		}
	}
	public static void identifySheet(String sheetname)
	{
		sheet=book.getSheet(sheetname);
	}
	public static int totalRowCount()
	{
		return sheet.getLastRowNum();
	}
	public static void identifyRow(int rownum)
	{
		row=sheet.getRow(rownum);
	}
	public static int totalCellCount()
	{
		return row.getLastCellNum();
	}
	public static String identifyCellData(int cellnum)
	{
		return row.getCell(cellnum).toString();
	}
	


}
