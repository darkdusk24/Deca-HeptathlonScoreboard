package sprint1;
import java.util.ArrayList;
import java.util.Collection;
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
	ContestantSportEvent CoSpEv = new ContestantSportEvent();;
	ScoreCalculator calc = new ScoreCalculator();
	public static List<Contestant> scoreboard = new ArrayList<>();
	Workbook workbook;
	Cell cell, cell1;
	Row row, row1;
	CellStyle cellStyle, cellStyle1, cellStyle2 ;
	Font font;
	Sheet sh, sh2;
	
	private String excelName;
	//public static Excel excel;
	
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
						   { "Country" }, 
						   { "Number" }, 
						   { "" }, 
						   { "01. 100 metres" }, 
						   { "02. Long jump" },
						   { "03. Shot put" }, 
						   { "04. High jump" }, 
						   { "05. 400 metres" }, 
						   { "DAY 1 TOTAL" }, 
						   { "DAY 1 PLACE" },
						   { "06. 110 metres hurdles" },
						   { "07. Discus throw" },
						   { "08. Pole vault" },
						   { "09. Javelin throw" },
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
	// Autosize Decathlon-columns
	for (int i = 0; i < 16; i++) {
		sh.autoSizeColumn(i);
	}
	}
	
	public void DecaColumnBtoC(List<Contestant> cont)throws IOException {
		int column = 1;
		
		for(int i =0; i<cont.size(); i++) {
		Contestant output = cont.get(i);
		List<ContestantSportEvent> temp = output.getSportEvents();
		
		// Values for Column B and C for Decathlon
		Object columnB[][] = { { output.getName() }, 
						   	   { output.getCountry() }, 
						   	   { output.getNumber() }, 
						   	   { "RESULT", "SCORE" },
						   	   { temp.get(0).getResult(), temp.get(0).getScore() },
						   	   { temp.get(1).getResult(), temp.get(1).getScore() },
						   	   { temp.get(2).getResult(), temp.get(2).getScore() },
						   	   { temp.get(3).getResult(), temp.get(3).getScore() },
						   	   { temp.get(4).getResult(), temp.get(4).getScore() },
						   	   { "D1 TOTAL" }, 
						   	   { "D1 PLACE" }, 
						   	   { temp.get(5).getResult(), temp.get(5).getScore() },
						   	   { temp.get(6).getResult(), temp.get(6).getScore() },
						   	   { temp.get(7).getResult(), temp.get(7).getScore() },
						   	   { temp.get(8).getResult(), temp.get(8).getScore() },
						   	   { temp.get(9).getResult(), temp.get(9).getScore() },
						   	   { "TOTAL POINTS" },
						   	   { "TOTAL PLACE" },
						   	   };
		
	// Create Row and Column B for Decathlon
	int rowCount1 = 0;
	for (Object emp1[] : columnB) {
		row1 = sh.getRow(rowCount1);
		int check = 0;
		for (Object value1 : emp1) {
			if(check==0) {
				cell1 = row1.createCell(column);
				System.out.println(rowCount1);
				if (rowCount1==4 || rowCount1==5 || rowCount1==6 || rowCount1==7 || rowCount1==8 || rowCount1==11 || rowCount1==12 || rowCount1==13 || rowCount1==14 || rowCount1==15) {
					cell1.setCellValue((double) value1); 
				} else if (rowCount1==2) {
					cell1.setCellValue((Integer) value1);
				} else { 
					cell1.setCellValue((String) value1);
				}
				CellUtil.setAlignment(cell1, HorizontalAlignment.CENTER);
				check++;
			} else if(check == 1) {
				cell1 = row1.createCell((column+1));
				if(rowCount1==3) {
					cell1.setCellValue((String) value1);
				} else {
					cell1.setCellValue((int) value1);
				}
				CellUtil.setAlignment(cell1, HorizontalAlignment.CENTER);
			}
		}
		rowCount1++;
	}
	
	// Make the row 4 to "bold text" in Decathlon
	cellStyle1 = workbook.createCellStyle();
	font = workbook.createFont();
	font.setBold(true);
	cellStyle1.setFont(font);
	row1 = sh.getRow(3);
	cell1 = row1.getCell(0);
	cell1.setCellStyle(cellStyle1);
	for (int j = 0; j <= 2; j++)
		row1.getCell(j).setCellStyle(cellStyle1);
	// Merge cells on row 1,2,3,10,11,17,18 Column B and C in Decathlon
	sh.addMergedRegion(new CellRangeAddress(0, 0, 1, 2));
	sh.addMergedRegion(new CellRangeAddress(1, 1, 1, 2));
	sh.addMergedRegion(new CellRangeAddress(2, 2, 1, 2));
	sh.addMergedRegion(new CellRangeAddress(9, 9, 1, 2));
	sh.addMergedRegion(new CellRangeAddress(10, 10, 1, 2));
	sh.addMergedRegion(new CellRangeAddress(16, 16, 1, 2));
	sh.addMergedRegion(new CellRangeAddress(17, 17, 1, 2));
	column++;
	}
	// Autosize Decathlon-columns
	for (int i = 0; i < 81; i++) {
		sh.autoSizeColumn(i);
	}
}
//-----------------------------------------------------------------------------------------
	public void HeptaColumnA()throws IOException { 
	// Values for Column A for Heptathlon
	Object columnA1[][] = { { "Name"}, 
							{ "Country" }, 
							{ "Number" }, 
							{ "" }, 
							{ "01. 100 metres hurdles" },
							{ "02. High jump" }, 
							{ "03. Shot put" }, 
							{ "04. 200 metres" }, 
							{ "DAY 1 TOTAL" }, 
							{ "DAY 1 PLACE" },
							{ "05. Long jump" }, 
							{ "06. Javelin throw" }, 
							{ "07. 800 metres" },
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
	// Autosize Decathlon-columns
	for (int i = 0; i < 16; i++) {
		sh2.autoSizeColumn(i);
	}
	}
	public void HeptaColumnBtoC(List<Contestant> cont)throws IOException { 
		int column = 1;
		
		for(int i =0; i<cont.size(); i++) {
		Contestant output = cont.get(i);
		List<ContestantSportEvent> temp = output.getSportEvents();
		
		// Values for Column B and C for Heptathlon
	Object columnB1[][] = { { output.getName() }, 
							{ output.getCountry() }, 
							{ output.getNumber() }, 
							{ "RESULT", "SCORE" },
							{ temp.get(0).getResult(), temp.get(0).getScore() }, 
							{ temp.get(1).getResult(), temp.get(1).getScore() },
							{ temp.get(2).getResult(), temp.get(2).getScore() }, 
							{ temp.get(3).getResult(), temp.get(3).getScore() }, 
							{ "D1 TOTAL" },
							{ "D1 PLACE" },
							{ temp.get(4).getResult(), temp.get(4).getScore() }, 
							{ temp.get(5).getResult(), temp.get(5).getScore() },
							{ temp.get(6).getResult(), temp.get(6).getScore() },
							{ "TOTAL POINTS" },
							{ "TOTAL PLACE" }
							};
	// Create Row and Column B for Heptathlon
	int rowCount01 = 0;
	for (Object emp1[] : columnB1) {
		row1 = sh2.getRow(rowCount01);
		int check = 0;
		for (Object value1 : emp1) {
			if(check==0) {
				cell1 = row1.createCell(column);
				System.out.println(rowCount01);
				if (rowCount01==4 || rowCount01==5 || rowCount01==6 || rowCount01==7 || rowCount01==10 || rowCount01==11 || rowCount01==12) {
					cell1.setCellValue((double) value1); 
				} else if (rowCount01==2) {
					cell1.setCellValue((Integer) value1);
				} else { 
					cell1.setCellValue((String) value1);
				}
				CellUtil.setAlignment(cell1, HorizontalAlignment.CENTER);
				check++;
			} else if(check == 1) {
				cell1 = row1.createCell((column+1));
				if(rowCount01==3) {
					cell1.setCellValue((String) value1);
				} else {
					cell1.setCellValue((int) value1);
				}
				CellUtil.setAlignment(cell1, HorizontalAlignment.CENTER);
			}
		}
		rowCount01++;
	}
	
	// Make the row 4 to "bold text" in Heptathlon
	cellStyle2 = workbook.createCellStyle();
	font = workbook.createFont();
	font.setBold(true);
	cellStyle2.setFont(font);
	row1 = sh2.getRow(3);
	cell1 = row1.getCell(0);
	cell1.setCellStyle(cellStyle2);
	for (int j = 0; j <= 2; j++)
		row1.getCell(j).setCellStyle(cellStyle2);
	// Merge cells on row 1,2,3,9,10,14,15 Column B and C in Heptathlon
	sh2.addMergedRegion(new CellRangeAddress(0, 0, 1, 2));
	sh2.addMergedRegion(new CellRangeAddress(1, 1, 1, 2));
	sh2.addMergedRegion(new CellRangeAddress(2, 2, 1, 2));
	sh2.addMergedRegion(new CellRangeAddress(8, 8, 1, 2));
	sh2.addMergedRegion(new CellRangeAddress(9, 9, 1, 2));
	sh2.addMergedRegion(new CellRangeAddress(13, 13, 1, 2));
	sh2.addMergedRegion(new CellRangeAddress(14, 14, 1, 2));
	column++;
	}
	// Autosize Heptathlon-columns
	for (int i = 0; i < 81; i++) {
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
