package sprint1;

import java.io.FileOutputStream;
import java.util.List;

//import sprint1.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;

public class Excel {
	
		ScoreCalculator calc = MainProgram.getScoreCalculator();
		Workbook workbook;
		Cell cell, cell1;
		Row row, row1;
		CellStyle cellStyle;
		Font font;
		Sheet decaSheet, heptaSheet;
		private String excelName;
		
		Excel(String name) {
		// Create workbook in .xls format
		workbook = new HSSFWorkbook();
		excelName = name;
		// For .xslx workbooks use XSSFWoorkbok();
		// Create Sheets
		this.decaSheet = workbook.createSheet("Decathlon");
		this.heptaSheet = workbook.createSheet(MainProgram.getMainEvent().eventName);
		decaColumnA();
		heptaColumnA();
		write();
		}
		
		public void decaColumnA() { 
		// Values for Column A for Decathlon
		Object columnA[][] = { { "Name" }, 
							   { "Number" }, 
							   { "Country" }, 
							   { "" }, 
							   { "100 m" }, 
							   { "Long jump" },
							   { "Shot put" }, 
							   { "High jump" }, 
							   { "400 m" }, 
							   { "DAY 1 TOTAL" }, 
							   { "DAY 1 PLACE" },
							   { "110 m hurdles" },
							   { "Discus throw" },
							   { "Pole vault" },
							   { "Javelin throw" },
							   { "1500 m" },
							   { "TOTAL POINTS" },
							   { "TOTAL PLACE" },
							   };
		// Create Cells and Column A for Decathlon
		int rowCount = 0;
		for (Object emp[] : columnA) {
			row = decaSheet.createRow(rowCount++);
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
		
		public void decaContestantRegistration(Contestant cont) {
			int column = 0;
			while(true) {
				Row checkRow = decaSheet.getRow(0);
				if(checkRow.getCell(column) == null) {
					break;
				} else {
					column++;
				}
			}
			
			Cell name = decaSheet.getRow(0).createCell(column);
			CellUtil.setAlignment(name, HorizontalAlignment.CENTER);
			Cell number = decaSheet.getRow(1).createCell(column);
			CellUtil.setAlignment(number, HorizontalAlignment.CENTER);
			Cell country = decaSheet.getRow(2).createCell(column);
			CellUtil.setAlignment(country, HorizontalAlignment.CENTER);
			int mergedColumnEnd = column + 1;
			
			Cell nameSecondColumn = decaSheet.getRow(0).createCell(mergedColumnEnd);
			nameSecondColumn.setCellValue("");
			
			name.setCellValue(cont.getName());
			number.setCellValue(cont.getNumber());
			country.setCellValue(cont.getCountry());
			
			decaSheet.addMergedRegion(new CellRangeAddress(0, 0, column, mergedColumnEnd));
			decaSheet.addMergedRegion(new CellRangeAddress(1, 1, column, mergedColumnEnd));
			decaSheet.addMergedRegion(new CellRangeAddress(2, 2, column, mergedColumnEnd));
			decaSheet.addMergedRegion(new CellRangeAddress(16, 16, column, mergedColumnEnd));
			decaSheet.addMergedRegion(new CellRangeAddress(17, 17, column, mergedColumnEnd));
			
			
			//Creating the cells for Result and Score text
			cellStyle = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBold(true);
			cellStyle.setFont(font);
			
			Row resultScore = decaSheet.getRow(3);
			Cell result = resultScore.createCell(column);
			result.setCellValue("Result");
			result.setCellStyle(cellStyle);
			Cell score = resultScore.createCell(mergedColumnEnd);
			score.setCellValue("Score");
			score.setCellStyle(cellStyle);
			for (int i = 0; i < 16; i++) {
				decaSheet.autoSizeColumn(i);
			}
			
			write();
		}
		
		public void heptaContestantRegistration(Contestant cont) {
			int column = 0;
			while(true) {
				Row checkRow = heptaSheet.getRow(0);
				if(checkRow.getCell(column) == null) {
					break;
				} else {
					column++;
				}
			}
			
			Cell name = heptaSheet.getRow(0).createCell(column);
			CellUtil.setAlignment(name, HorizontalAlignment.CENTER);
			Cell number = heptaSheet.getRow(1).createCell(column);
			CellUtil.setAlignment(number, HorizontalAlignment.CENTER);
			Cell country = heptaSheet.getRow(2).createCell(column);
			CellUtil.setAlignment(country, HorizontalAlignment.CENTER);
			int mergedColumnEnd = column + 1;
			
			Cell nameSecondColumn = heptaSheet.getRow(0).createCell(mergedColumnEnd);
			nameSecondColumn.setCellValue("");
			
			name.setCellValue(cont.getName());
			number.setCellValue(cont.getNumber());
			country.setCellValue(cont.getCountry());
			
			heptaSheet.addMergedRegion(new CellRangeAddress(0, 0, column, mergedColumnEnd));
			heptaSheet.addMergedRegion(new CellRangeAddress(1, 1, column, mergedColumnEnd));
			heptaSheet.addMergedRegion(new CellRangeAddress(2, 2, column, mergedColumnEnd));
			heptaSheet.addMergedRegion(new CellRangeAddress(13, 13, column, mergedColumnEnd));
			heptaSheet.addMergedRegion(new CellRangeAddress(14, 14, column, mergedColumnEnd));
			
			
			//Creating the cells for Result and Score text
			cellStyle = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBold(true);
			cellStyle.setFont(font);
			
			Row resultScore = heptaSheet.getRow(3);
			Cell result = resultScore.createCell(column);
			result.setCellValue("Result");
			result.setCellStyle(cellStyle);
			Cell score = resultScore.createCell(mergedColumnEnd);
			score.setCellValue("Score");
			score.setCellStyle(cellStyle);
			for (int i = 0; i < 16; i++) {
				heptaSheet.autoSizeColumn(i);
			}
			
			write();
		}
		
		public void setDecaContestantEventResultAndScore(Contestant cont, String event) {
		int row = 4;
		int column = 0;
		
		while(true) {
			Row checkRow = decaSheet.getRow(row);
			if(checkRow.getCell(0).getStringCellValue().equalsIgnoreCase(event)) {
				break;
			} else {
				row++;
			}
		}
		
		while(true) {
			Row checkNameRow = decaSheet.getRow(0);
			if(checkNameRow.getCell(column).getStringCellValue().equalsIgnoreCase(cont.getName())) {
				break;
			} else {
				column++;
			}
		}
		
		Row assign = decaSheet.getRow(row);
		Cell result = assign.createCell(column);
		CellUtil.setAlignment(result, HorizontalAlignment.CENTER);
		Cell score = assign.createCell((column + 1));
		CellUtil.setAlignment(score, HorizontalAlignment.CENTER);
		ContestantSportEvent temp = cont.getSportEvent(event);
		result.setCellValue(temp.getResult());
		score.setCellValue(temp.getScore());
		// Autosize Decathlon-Columns
		for (int i = 0; i < 81; i++) {
			decaSheet.autoSizeColumn(i);
		}
		
		write();
		// Merge cells on row 1,2,3,10,11,17,18 Column B, C and D in Decathlon
//      sh.addMergedRegion(new CellRangeAddress(9, 9, 1, 3));
//		sh.addMergedRegion(new CellRangeAddress(10, 10, 1, 3));
//		sh.addMergedRegion(new CellRangeAddress(17, 17, 1, 3));
		}
		
		public void heptaColumnA() { 
		// Values for Column A for Heptathlon
		Object columnA1[][] = { { "Name"}, 
								{ "Number" }, 
								{ "Country" }, 
								{ "" }, 
								{ "100 m hurdles" },
								{ "High jump" }, 
								{ "Shot put" }, 
								{ "200 m" }, 
								{ "DAY 1 TOTAL" }, 
								{ "DAY 1 PLACE" },
								{ "Long jump" }, 
								{ "Javelin throw" }, 
								{ "800 m" },
								{ "TOTAL POINTS" },
								{ "TOTAL PLACE" },
								};
		// Create Cells and Column A for Heptathlon
		int rowCount0 = 0;
		for (Object emp[] : columnA1) {
			row = heptaSheet.createRow(rowCount0++);
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
		
		public void setHeptaContestantEventResultAndScore(Contestant cont, String event) {
			int row = 4;
			int column = 0;
			
			while(true) {
				Row checkRow = heptaSheet.getRow(row);
				if(checkRow.getCell(0).getStringCellValue().equalsIgnoreCase(event)) {
					break;
				} else {
					row++;
				}
			}
			
			while(true) {
				Row checkNameRow = heptaSheet.getRow(0);
				if(checkNameRow.getCell(column).getStringCellValue().equalsIgnoreCase(cont.getName())) {
					break;
				} else {
					column++;
				}
			}
			
			Row assign = heptaSheet.getRow(row);
			Cell result = assign.createCell(column);
			CellUtil.setAlignment(result, HorizontalAlignment.CENTER);
			Cell score = assign.createCell((column + 1));
			CellUtil.setAlignment(score, HorizontalAlignment.CENTER);
			ContestantSportEvent temp = cont.getSportEvent(event);
			result.setCellValue(temp.getResult());
			score.setCellValue(temp.getScore());
			
			// Autosize Heptathlon-columns
			for (int i = 0; i < 81; i++) {
				heptaSheet.autoSizeColumn(i);
				}
			
			write();
			// Merge cells on row 1,2,3,9,10,15,16 Column B, C and D in Heptathlon
//			sh2.addMergedRegion(new CellRangeAddress(8, 8, 1, 3));
//			sh2.addMergedRegion(new CellRangeAddress(9, 9, 1, 3));
//			sh2.addMergedRegion(new CellRangeAddress(13, 13, 1, 3));
//			sh2.addMergedRegion(new CellRangeAddress(14, 14, 1, 3));
		}
		
		public void printContestantTotalScore(Contestant cont, String mainEvent) {
			int column = 0;
			
			while(true) {
				if(mainEvent.equalsIgnoreCase("Decathlon")) {
					Row checkNameRow = decaSheet.getRow(0);
					if(checkNameRow.getCell(column).getStringCellValue().equalsIgnoreCase(cont.getName())) {
						break;
					} else {
						column++;
					}
				} else if(mainEvent.equalsIgnoreCase("Heptathlon")) {
					Row checkNameRow = heptaSheet.getRow(0);
					if(checkNameRow.getCell(column).getStringCellValue().equalsIgnoreCase(cont.getName())) {
						break;
					} else {
						column++;
					}
				}
			}
			//Används inte här
			//int mergedColumnEnd = column + 1;
			
			if(mainEvent.equalsIgnoreCase("Decathlon")) {
				Row totalScoreRow = decaSheet.getRow(16);
				Cell totalScore = totalScoreRow.createCell(column);
				CellUtil.setAlignment(totalScore, HorizontalAlignment.CENTER);
				totalScore.setCellValue(cont.getTotalScore());
			} else if(mainEvent.equalsIgnoreCase("Heptathlon")) {
				Row totalScoreRow = heptaSheet.getRow(13);
				Cell totalScore = totalScoreRow.createCell(column);
				CellUtil.setAlignment(totalScore, HorizontalAlignment.CENTER);
				totalScore.setCellValue(cont.getTotalScore());
			}
			
			for (int i = 0; i < 81; i++) {
				decaSheet.autoSizeColumn(i);
			}
			write();
		}
		
		public void printContestantPlacing(List<Contestant> scoreboard, MainEventType mainEvent) {
			int column = 1;
			Sheet contestSheet = mainEvent == MainEventType.DECATHLON ? decaSheet : heptaSheet;
			for(Contestant cont : scoreboard) {
					column = findContestantColumn(column, contestSheet, cont.getName());
					Row placingRow = mainEvent == MainEventType.DECATHLON ? decaSheet.getRow(17) : heptaSheet.getRow(14);
					Cell contestantPlacingCell = placingRow.createCell(column);
					CellUtil.setAlignment(contestantPlacingCell, HorizontalAlignment.CENTER);
					//!
					contestantPlacingCell.setCellValue(scoreboard.indexOf(cont)+1);
				}// for
			
			for (int i = 0; i < 81; i++) {
				contestSheet.autoSizeColumn(i);
			}
			write();
		}

		private int findContestantColumn(int col, Sheet cs, String cName) {
			String contestantName= cs.getRow(0).getCell(col).getStringCellValue();
			while(!contestantName.equalsIgnoreCase(cName)) {
				col++;
			}
			return col;
		}
		
		public void write() {
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