package com.Project.Utilities;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Environment {

	@SuppressWarnings("resource")
	public static String ReadExcelData(String SheetName, int RowNumber, int CellNumber) throws IOException {

		File src = null;
		XSSFSheet Sheet = null;
		String dataAtCell = null;
		DataFormatter formatter = new DataFormatter();

		try {
			src = new File(".\\ExcelData.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook excelWorkbook = new XSSFWorkbook(fis);

		try {
			Sheet = excelWorkbook.getSheet(SheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Cell cell = Sheet.getRow(RowNumber).getCell(CellNumber);
			dataAtCell = formatter.formatCellValue(cell);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataAtCell;
	}
}