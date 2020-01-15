package com.inetBanking.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {
	public static void main(String args[]) throws IOException {
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/java/com/inetBanking/testData/LoginData.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet("Sheet1");// for providing sheet name
		// XSSFSheet sheet = workbook.getSheetAt("0");//By Index \

		int rowcount = sheet.getLastRowNum();// Returns the row count
		int colcount = sheet.getRow(0).getLastCellNum();// Return column/cell count

		for (int i = 0; i < rowcount; i++) {
			XSSFRow currantrow = sheet.getRow(i); // Focused on Currant row

			for (int j = 0; j < colcount; j++) {

				String value = currantrow.getCell(j).toString();// Read the Value from cell
				System.out.print("    "+value);
			}
			System.out.println();
		}
	}
}