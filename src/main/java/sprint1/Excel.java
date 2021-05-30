package sprint1;
import java.util.ArrayList;
import java.io.*;
import java.util.Iterator;
import java.util.List;
//import sprint1.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
		MainProgram mains = new MainProgram();
		CompetitorsScore score = new CompetitorsScore();
		Contestant cont = new Contestant();
		ContestantSportEvent CoSpEv = new ContestantSportEvent();
		ScoreCalculator calc = new ScoreCalculator();
		Workbook workbook;
		Cell cell, cell1;
		Row row, row1;
		CellStyle cellStyle, cellStyle1;
		Font font;
		Sheet sh, sh2;
		private String excelName;
		
		Excel(String name) throws IOException{
		// Create workbook in .xls format
		workbook = new HSSFWorkbook();
		excelName = name;
		// For .xslx workbooks use XSSFWoorkbok();
		// Create Sheets
				sh = workbook.createSheet("Decathlon");
				sh2 = workbook.createSheet("Heptathlon");
		}
		
		public void DecaColumnA() throws IOException{ 
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
							   { "DAY 1 PLACE" },
							   { "6. 110 metres hurdles" },
							   { "7. Discus throw" },
							   { "8. Pole vault" },
							   { "9. Javelin throw" },
							   { "10. 1500 metres" },
							   { "TOTAL POINTS" },
							   { "TOTAL PLACE" },
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
		}
		public void DecaColumnBtoD()throws IOException {
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
							   { "D1 PLACE" }, 
							   { "E6 Result", "E6 Score", "E6 Place" },
							   { "E7 Result", "E7 Score", "E7 Place" },
							   { "E8 Result", "E8 Score", "E8 Place" },
							   { "E9 Result", "E9 Score", "E9 Place" },
							   { "E10 Result", "E10 Score", "E10 Place" },
							   { "TOTAL POINTS" },
							   { "TOTAL PLACE" },
							   };
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
		// Merge cells on row 1,2,3,10,11,17,18 Column B, C and D in Decathlon
		sh.addMergedRegion(new CellRangeAddress(0, 0, 1, 3));
		sh.addMergedRegion(new CellRangeAddress(1, 1, 1, 3));
		sh.addMergedRegion(new CellRangeAddress(2, 2, 1, 3));
		sh.addMergedRegion(new CellRangeAddress(9, 9, 1, 3));
		sh.addMergedRegion(new CellRangeAddress(10, 10, 1, 3));
		sh.addMergedRegion(new CellRangeAddress(16, 16, 1, 3));
		sh.addMergedRegion(new CellRangeAddress(17, 17, 1, 3));
		// Autosize Decathlon-columns
		for (int i = 0; i < 16; i++) {
			sh.autoSizeColumn(i);
		}
		}
//-----------------------------------------------------------------------------------------
		public void HeptaColumnA()throws IOException { 
		// Values for Column A for Heptathlon
		Object columnA1[][] = { { "Name"}, 
								{ "Number" }, 
								{ "Country" }, 
								{ "" }, 
								{ "1. 100 metres hurdles" },
								{ "2. High jump" }, 
								{ "3. Shot put" }, 
								{ "4. 200 metres" }, 
								{ "DAY 1 TOTAL" }, 
								{ "DAY 1 PLACE" },
								{ "5. Long jump" }, 
								{ "6. Javelin throw" }, 
								{ "7. 800 metres" },
								{ "TOTAL POINTS" },
								{ "TOTAL PLACE" },
								};
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
		}
		public void HeptaColumnBtoD()throws IOException { 
		// Values for Column B for Heptathlon
		Object columnB1[][] = { { cont.getName() }, 
								{ cont.getCountry() }, 
								{ cont.getNumber() }, 
								{ "RESULT", "SCORE", "PLACE" },
								{ CoSpEv.getResult(), CoSpEv.getScore(), "E1 Place" }, 
								{ CoSpEv.getResult(), CoSpEv.getScore(), "E2 Place" },
								{ CoSpEv.getResult(), CoSpEv.getScore(), "E3 Place" }, 
								{ CoSpEv.getResult(), CoSpEv.getScore(), "E4 Place" }, 
								{ "D1 TOTAL" },
								{ "D1 PLACE" },
								{ CoSpEv.getResult(), CoSpEv.getScore(), "E5 Place" }, 
								{ CoSpEv.getResult(), CoSpEv.getScore(), "E6 Place" },
								{ CoSpEv.getResult(), CoSpEv.getScore(), "E7 Place" }, 
								{ "TOTAL POINTS" },
								{ "TOTAL PLACE" },
		};
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
		// Merge cells on row 1,2,3,9,10,15,16 Column B, C and D in Heptathlon
		sh2.addMergedRegion(new CellRangeAddress(0, 0, 1, 3));
		sh2.addMergedRegion(new CellRangeAddress(1, 1, 1, 3));
		sh2.addMergedRegion(new CellRangeAddress(2, 2, 1, 3));
		sh2.addMergedRegion(new CellRangeAddress(8, 8, 1, 3));
		sh2.addMergedRegion(new CellRangeAddress(9, 9, 1, 3));
		sh2.addMergedRegion(new CellRangeAddress(13, 13, 1, 3));
		sh2.addMergedRegion(new CellRangeAddress(14, 14, 1, 3));
		// Autosize Heptathlon-columns
		for (int i = 0; i < 16; i++) {
			sh2.autoSizeColumn(i);
			}
		}
		
		public void write() throws IOException {
			try {
			FileOutputStream output = new FileOutputStream("src//main//java//" + excelName + ".xls");
			workbook.write(output);
			output.close();
			workbook.close();
			} catch (Exception e) {
				e.printStackTrace();
				}
		}
}