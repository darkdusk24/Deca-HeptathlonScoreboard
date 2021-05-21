package sprint1;

import java.io.*;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;

public class Excel {

	public static void main(String[] args) {

		// Create workbook in .xls format
		Workbook workbook = new HSSFWorkbook();
		// For .xslx workbooks use XSSFWoorkbok();
		// Create Sheets
		Sheet sh = workbook.createSheet("Decathlon");
		Sheet sh2 = workbook.createSheet("Heptathlon");

		Cell cell, cell1;
		Row row, row1;
		CellStyle cellStyle, cellStyle1;
		Font font;
		// Values for Column A for Decathlon
		Object columnA[][] = { { "Name" }, 
							   { "Number" }, 
							   { "Country" }, 
							   { "" }, 
							   { "1. 100 metres" }, 
							   { "2. Long jump" },
							   { "3. Shot put" }, 
							   { "4. High jump" }, 
							   { "5. 400 metres" }, 
							   { "DAY 1 TOTAL" }, 
							   { "DAY 1 PLACE" } 
							 };
		// Create Cells and Column A for Decathlon
		int rowCount = 0;
		for (Object emp[] : columnA) {
			row = sh.createRow(rowCount++);
			int columnCount = 0;
			for (Object value : emp) {
				cell = row.createCell(columnCount++);
				if (value instanceof String)
					cell.setCellValue((String) value);
				if (value instanceof Integer)
					cell.setCellValue((Integer) value);
				if (value instanceof Boolean)
					cell.setCellValue((Boolean) value);
				// Make the column A "bold text"
				cellStyle = workbook.createCellStyle();
				font = workbook.createFont();
				font.setBold(true);
				cellStyle.setFont(font);
				cell.setCellStyle(cellStyle);
			}
		}
		// Values for Column B for Decathlon
		Object columnB[][] = { { "Calvin hall" }, 
							   { 100 }, 
							   { "USA" }, 
							   { "RESULT", "SCORE", "PLACE" },
							   { "E1 Result", "E1 Score", "E1 Place" }, 
							   { "E2 Result", "E2 Score", "E2 Place" },
							   { "E3 Result", "E3 Score", "E3 Place" }, 
							   { "E4 Result", "E4 Score", "E4 Place" },
							   { "E5 Result", "E5 Score", "E5 Place" }, 
							   { "D1 TOTAL" }, 
							   { "D1 PLACE" } };
		// Create Row and Column B for Decathlon
		int rowCount1 = 0;
		for (Object emp1[] : columnB) {
			row1 = sh.getRow(rowCount1++);
			int columnCount1 = 1;
			for (Object value1 : emp1) {
				cell1 = row1.createCell(columnCount1++);
				if (value1 instanceof String)
					cell1.setCellValue((String) value1);
				if (value1 instanceof Integer)
					cell1.setCellValue((Integer) value1);
				if (value1 instanceof Boolean)
					cell1.setCellValue((Boolean) value1);
				CellUtil.setAlignment(cell1, HorizontalAlignment.CENTER);
			}
		}
		// Make the row 4 to "bold text" in Decathlon
		cellStyle1 = workbook.createCellStyle();
		font = workbook.createFont();
		font.setBold(true);
		cellStyle1.setFont(font);
		row1 = sh.getRow(3);
		cell1 = row1.getCell(0);
		cell1.setCellStyle(cellStyle1);
		for (int j = 0; j <= 3; j++)
			row1.getCell(j).setCellStyle(cellStyle1);
		// Merge cells on row 1,2,3,10,11 Column B, C and D in Decathlon
		sh.addMergedRegion(new CellRangeAddress(0, 0, 1, 3));
		sh.addMergedRegion(new CellRangeAddress(1, 1, 1, 3));
		sh.addMergedRegion(new CellRangeAddress(2, 2, 1, 3));
		sh.addMergedRegion(new CellRangeAddress(9, 9, 1, 3));
		sh.addMergedRegion(new CellRangeAddress(10, 10, 1, 3));
		// Autosize Decathlon-columns
		for (int i = 0; i < 16; i++) {
			sh.autoSizeColumn(i);
		}
//-----------------------------------------------------------------------------------------
		// Values for Column A for Heptathlon
		Object columnA1[][] = { { "Name" }, 
								{ "Number" }, 
								{ "Country" }, 
								{ "" }, 
								{ "1. 100 metres hurdles" },
								{ "2. High jump" }, 
								{ "3. Shot put" }, 
								{ "4. 200 metres" }, 
								{ "DAY 1 TOTAL" }, 
								{ "DAY 1 PLACE" } };
		// Create Cells and Column A for Heptathlon
		int rowCount0 = 0;
		for (Object emp[] : columnA1) {
			row = sh2.createRow(rowCount0++);
			int columnCount = 0;
			for (Object value : emp) {
				cell = row.createCell(columnCount++);
				if (value instanceof String)
					cell.setCellValue((String) value);
				if (value instanceof Integer)
					cell.setCellValue((Integer) value);
				if (value instanceof Boolean)
					cell.setCellValue((Boolean) value);
				// Make the column A "bold text"
				cellStyle = workbook.createCellStyle();
				font = workbook.createFont();
				font.setBold(true);
				cellStyle.setFont(font);
				cell.setCellStyle(cellStyle);
			}
		}
		// Values for Column B for Heptathlon
		Object columnB1[][] = { { "Johan Svensson" }, 
								{ 250 }, 
								{ "SWE" }, 
								{ "RESULT", "SCORE", "PLACE" },
								{ "E1 Result", "E1 Score", "E1 Place" }, 
								{ "E2 Result", "E2 Score", "E2 Place" },
								{ "E3 Result", "E3 Score", "E3 Place" }, 
								{ "E4 Result", "E4 Score", "E4 Place" }, 
								{ "D1 TOTAL" },
								{ "D1 PLACE" } };
		// Create Row and Column B for Heptathlon
		int rowCount01 = 0;
		for (Object emp1[] : columnB1) {
			row1 = sh2.getRow(rowCount01++);
			int columnCount1 = 1;
			for (Object value1 : emp1) {
				cell1 = row1.createCell(columnCount1++);
				if (value1 instanceof String)
					cell1.setCellValue((String) value1);
				if (value1 instanceof Integer)
					cell1.setCellValue((Integer) value1);
				if (value1 instanceof Boolean)
					cell1.setCellValue((Boolean) value1);
				CellUtil.setAlignment(cell1, HorizontalAlignment.CENTER);
			}
		}
		// Make the row 4 to "bold text" in Heptathlon
		cellStyle1 = workbook.createCellStyle();
		font = workbook.createFont();
		font.setBold(true);
		cellStyle1.setFont(font);
		row1 = sh2.getRow(3);
		cell1 = row1.getCell(0);
		cell1.setCellStyle(cellStyle1);
		for (int j = 0; j <= 3; j++)
			row1.getCell(j).setCellStyle(cellStyle1);
		// Merge cells on row 1,2,3,9,10 Column B, C and D in Heptathlon
		sh2.addMergedRegion(new CellRangeAddress(0, 0, 1, 3));
		sh2.addMergedRegion(new CellRangeAddress(1, 1, 1, 3));
		sh2.addMergedRegion(new CellRangeAddress(2, 2, 1, 3));
		sh2.addMergedRegion(new CellRangeAddress(8, 8, 1, 3));
		sh2.addMergedRegion(new CellRangeAddress(9, 9, 1, 3));
		// Autosize Heptathlon-columns
		for (int i = 0; i < 16; i++) {
			sh2.autoSizeColumn(i);
		}
		try {
			// Write the output to file
			FileOutputStream output = new FileOutputStream("src//main//java//Deca-HeptathlonScoreboard.xls");
			workbook.write(output);
			output.close();
			workbook.close();
			System.out.println("Excel-file is Completed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}