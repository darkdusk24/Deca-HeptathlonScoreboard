package sprint1;

import java.util.ArrayList;
import java.io.*;
import java.util.List;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;

public class Excel {

	ScoreCalculator calc = new ScoreCalculator();
	Workbook workbook;
	Cell cell, cell1;
	Row row, row1;
	CellStyle cellStyle;
	Font font;
	Sheet sh, sh2;
	private String excelName;

	Excel(String name, Boolean con) {
		excelName = name;
		// For .xslx workbooks use XSSFWoorkbok();

		if (con == true) {
			try {
				FileInputStream input = new FileInputStream(new File("src//main//java//" + excelName + ".xls"));
				try {
					workbook = new HSSFWorkbook(input);
					this.sh = workbook.getSheet("Decathlon");
					this.sh2 = workbook.getSheet("Heptathlon");
					input.close();
					write();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			// Create workbook in .xls format
			workbook = new HSSFWorkbook();
			// Create Sheets
			this.sh = workbook.createSheet("Decathlon");
			this.sh2 = workbook.createSheet("Heptathlon");
			decaColumnA();
			heptaColumnA();
			write();
		}
	}

	public void decaColumnA() {
		// Values for Column A for Decathlon
		Object columnA[][] = { { "Name" }, { "Number" }, { "Country" }, { "" }, { "100 m" }, { "Long jump" },
				{ "Shot put" }, { "High jump" }, { "400 m" }, { "DAY 1 TOTAL" }, { "DAY 1 PLACE" }, { "110 m hurdles" },
				{ "Discus throw" }, { "Pole vault" }, { "Javelin throw" }, { "1500 m" }, { "TOTAL POINTS" },
				{ "TOTAL PLACE" }, };
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

	public void decaContestantRegistration(Contestant cont) {
		int column = 0;
		while (true) {
			Row checkRow = sh.getRow(0);
			if (checkRow.getCell(column) == null) {
				break;
			} else {
				column++;
			}
		}

		Cell name = sh.getRow(0).createCell(column);
		CellUtil.setAlignment(name, HorizontalAlignment.CENTER);
		Cell number = sh.getRow(1).createCell(column);
		CellUtil.setAlignment(number, HorizontalAlignment.CENTER);
		Cell country = sh.getRow(2).createCell(column);
		CellUtil.setAlignment(country, HorizontalAlignment.CENTER);
		int mergedColumnEnd = column + 1;

		Cell nameSecondColumn = sh.getRow(0).createCell(mergedColumnEnd);
		nameSecondColumn.setCellValue("");

		name.setCellValue(cont.getName());
		number.setCellValue(cont.getNumber());
		country.setCellValue(cont.getCountry());

		sh.addMergedRegion(new CellRangeAddress(0, 0, column, mergedColumnEnd));
		sh.addMergedRegion(new CellRangeAddress(1, 1, column, mergedColumnEnd));
		sh.addMergedRegion(new CellRangeAddress(2, 2, column, mergedColumnEnd));
		sh.addMergedRegion(new CellRangeAddress(16, 16, column, mergedColumnEnd));

		// Creating the cells for Result and Score text
		cellStyle = workbook.createCellStyle();
		font = workbook.createFont();
		font.setBold(true);
		cellStyle.setFont(font);

		Row resultScore = sh.getRow(3);
		Cell result = resultScore.createCell(column);
		result.setCellValue("Result");
		result.setCellStyle(cellStyle);
		Cell score = resultScore.createCell(mergedColumnEnd);
		score.setCellValue("Score");
		score.setCellStyle(cellStyle);
		for (int i = 0; i < 16; i++) {
			sh.autoSizeColumn(i);
		}

		write();
	}

	public void heptaContestantRegistration(Contestant cont) {
		int column = 0;
		while (true) {
			Row checkRow = sh2.getRow(0);
			if (checkRow.getCell(column) == null) {
				break;
			} else {
				column++;
			}
		}

		Cell name = sh2.getRow(0).createCell(column);
		CellUtil.setAlignment(name, HorizontalAlignment.CENTER);
		Cell number = sh2.getRow(1).createCell(column);
		CellUtil.setAlignment(number, HorizontalAlignment.CENTER);
		Cell country = sh2.getRow(2).createCell(column);
		CellUtil.setAlignment(country, HorizontalAlignment.CENTER);
		int mergedColumnEnd = column + 1;

		Cell nameSecondColumn = sh2.getRow(0).createCell(mergedColumnEnd);
		nameSecondColumn.setCellValue("");

		name.setCellValue(cont.getName());
		number.setCellValue(cont.getNumber());
		country.setCellValue(cont.getCountry());

		sh2.addMergedRegion(new CellRangeAddress(0, 0, column, mergedColumnEnd));
		sh2.addMergedRegion(new CellRangeAddress(1, 1, column, mergedColumnEnd));
		sh2.addMergedRegion(new CellRangeAddress(2, 2, column, mergedColumnEnd));
		sh2.addMergedRegion(new CellRangeAddress(13, 13, column, mergedColumnEnd));

		// Creating the cells for Result and Score text
		cellStyle = workbook.createCellStyle();
		font = workbook.createFont();
		font.setBold(true);
		cellStyle.setFont(font);

		Row resultScore = sh2.getRow(3);
		Cell result = resultScore.createCell(column);
		result.setCellValue("Result");
		result.setCellStyle(cellStyle);
		Cell score = resultScore.createCell(mergedColumnEnd);
		score.setCellValue("Score");
		score.setCellStyle(cellStyle);
		for (int i = 0; i < 16; i++) {
			sh2.autoSizeColumn(i);
		}

		write();
	}

	public void setDecaContestantEventResultAndScore(Contestant cont, String event) {
		int row = 4;
		int column = 0;

		while (true) {
			Row checkRow = sh.getRow(row);
			if (checkRow.getCell(0).getStringCellValue().equalsIgnoreCase(event)) {
				break;
			} else {
				row++;
			}
		}

		while (true) {
			Row checkNameRow = sh.getRow(0);
			if (checkNameRow.getCell(column).getStringCellValue().equalsIgnoreCase(cont.getName())) {
				break;
			} else {
				column++;
			}
		}

		Row assign = sh.getRow(row);
		Cell result = assign.createCell(column);
		CellUtil.setAlignment(result, HorizontalAlignment.CENTER);
		Cell score = assign.createCell((column + 1));
		CellUtil.setAlignment(score, HorizontalAlignment.CENTER);
		ContestantSportEvent temp = cont.getSportEvent(event);
		result.setCellValue(temp.getResult());
		score.setCellValue(temp.getScore());
		// Autosize Decathlon-Columns
		for (int i = 0; i < 81; i++) {
			sh.autoSizeColumn(i);
		}

		write();
		// Merge cells on row 1,2,3,10,11,17,18 Column B, C and D in Decathlon
//      sh.addMergedRegion(new CellRangeAddress(9, 9, 1, 3));
//		sh.addMergedRegion(new CellRangeAddress(10, 10, 1, 3));
//		sh.addMergedRegion(new CellRangeAddress(17, 17, 1, 3));
	}

	public void heptaColumnA() {
		// Values for Column A for Heptathlon
		Object columnA1[][] = { { "Name" }, { "Number" }, { "Country" }, { "" }, { "100 m hurdles" }, { "High jump" },
				{ "Shot put" }, { "200 m" }, { "DAY 1 TOTAL" }, { "DAY 1 PLACE" }, { "Long jump" }, { "Javelin throw" },
				{ "800 m" }, { "TOTAL POINTS" }, { "TOTAL PLACE" }, };
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

	public void setHeptaContestantEventResultAndScore(Contestant cont, String event) {
		int row = 4;
		int column = 0;

		while (true) {
			Row checkRow = sh2.getRow(row);
			if (checkRow.getCell(0).getStringCellValue().equalsIgnoreCase(event)) {
				break;
			} else {
				row++;
			}
		}

		while (true) {
			Row checkNameRow = sh2.getRow(0);
			if (checkNameRow.getCell(column).getStringCellValue().equalsIgnoreCase(cont.getName())) {
				break;
			} else {
				column++;
			}
		}

		Row assign = sh2.getRow(row);
		Cell result = assign.createCell(column);
		CellUtil.setAlignment(result, HorizontalAlignment.CENTER);
		Cell score = assign.createCell((column + 1));
		CellUtil.setAlignment(score, HorizontalAlignment.CENTER);
		ContestantSportEvent temp = cont.getSportEvent(event);
		result.setCellValue(temp.getResult());
		score.setCellValue(temp.getScore());

		// Autosize Heptathlon-columns
		for (int i = 0; i < 81; i++) {
			sh2.autoSizeColumn(i);
		}

		write();
		// Merge cells on row 1,2,3,9,10,15,16 Column B, C and D in Heptathlon
//			sh2.addMergedRegion(new CellRangeAddress(8, 8, 1, 3));
//			sh2.addMergedRegion(new CellRangeAddress(9, 9, 1, 3));
//			sh2.addMergedRegion(new CellRangeAddress(13, 13, 1, 3));
//			sh2.addMergedRegion(new CellRangeAddress(14, 14, 1, 3));
	}

	public void setContestantsTotalScore(Contestant cont, String mainEvent) {
		int column = 0;

		while (true) {
			if (mainEvent.equalsIgnoreCase("Decathlon")) {
				Row checkNameRow = sh.getRow(0);
				if (checkNameRow.getCell(column).getStringCellValue().equalsIgnoreCase(cont.getName())) {
					break;
				} else {
					column++;
				}
			} else if (mainEvent.equalsIgnoreCase("Heptathlon")) {
				Row checkNameRow = sh2.getRow(0);
				if (checkNameRow.getCell(column).getStringCellValue().equalsIgnoreCase(cont.getName())) {
					break;
				} else {
					column++;
				}
			}
		}

		if (mainEvent.equalsIgnoreCase("Decathlon")) {
			Row totalScoreRow = sh.getRow(16);
			Cell totalScore = totalScoreRow.createCell(column);
			CellUtil.setAlignment(totalScore, HorizontalAlignment.CENTER);
			totalScore.setCellValue(calc.totalScoreCalculation(cont.getSportEvents()));
		} else if (mainEvent.equalsIgnoreCase("Heptathlon")) {
			Row totalScoreRow = sh2.getRow(13);
			Cell totalScore = totalScoreRow.createCell(column);
			CellUtil.setAlignment(totalScore, HorizontalAlignment.CENTER);
			totalScore.setCellValue(calc.totalScoreCalculation(cont.getSportEvents()));
		}

		for (int i = 0; i < 81; i++) {
			sh.autoSizeColumn(i);
		}
		write();
	}

	public void write() {
		try {
			FileOutputStream output = new FileOutputStream(new File("src//main//java//" + excelName + ".xls"));
			workbook.write(output);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Contestant> continuingEvent(String main) {
		List<Contestant> scoreboard = new ArrayList<>();

		Row nameRow;
		Cell nameCell;
		Row numberRow;
		Cell numberCell;
		Row countryRow;
		Cell countryCell;
		String name;
		int number;
		String country;
		int column = 1;

		while (true) {

			int events = 1;
			Contestant contestant;

			if (main.equalsIgnoreCase("Decathlon")) {
				nameRow = sh.getRow(0);
				numberRow = sh.getRow(1);
				countryRow = sh.getRow(2);

				nameCell = nameRow.getCell(column);
				numberCell = numberRow.getCell(column);
				countryCell = countryRow.getCell(column);

				try {
					name = nameCell.getStringCellValue();
				} catch (Exception e) {
					break;
				}

				number = (int) numberCell.getNumericCellValue();
				country = countryCell.getStringCellValue();

				contestant = new Contestant(name, number, country);

				while (events <= 10) {
					Row eventRow = null;
					if (events < 6) {
						eventRow = sh.getRow((3 + events));
					} else {
						eventRow = sh.getRow((5 + events));
					}
					Cell eventCell = eventRow.getCell(0);
					Cell eventResultCell;
					Cell eventScoreCell;
					double result;
					int score;
					String event;

					eventResultCell = eventRow.getCell(column);
					eventScoreCell = eventRow.getCell((column + 1));

					try {
						result = eventResultCell.getNumericCellValue();
					} catch (Exception e) {
						events = 11;
						break;
					}

					score = (int) eventScoreCell.getNumericCellValue();
					event = eventCell.getStringCellValue();
					contestant.addSportEvent(event, score, result);

					events++;
				}
				scoreboard.add(contestant);
			} else if (main.equalsIgnoreCase("Heptathlon")) {
				nameRow = sh2.getRow(0);
				numberRow = sh2.getRow(1);
				countryRow = sh2.getRow(2);

				nameCell = nameRow.getCell(column);
				numberCell = numberRow.getCell(column);
				countryCell = countryRow.getCell(column);

				try {
					name = nameCell.getStringCellValue();
				} catch (Exception e) {
					break;
				}

				number = (int) numberCell.getNumericCellValue();
				country = countryCell.getStringCellValue();

				contestant = new Contestant(name, number, country);

				while (events <= 7) {
					Row eventRow = null;
					if (events < 4) {
						eventRow = sh2.getRow((3 + events));
					} else {
						eventRow = sh2.getRow((5 + events));
					}
					Cell eventCell = eventRow.getCell(0);
					Cell eventResultCell;
					Cell eventScoreCell;
					double result;
					int score;
					String event;

					eventResultCell = eventRow.getCell(column);
					eventScoreCell = eventRow.getCell((column + 1));

					try {
						result = eventResultCell.getNumericCellValue();
					} catch (Exception e) {
						events = 11;
						break;
					}

					score = (int) eventScoreCell.getNumericCellValue();
					event = eventCell.getStringCellValue();
					contestant.addSportEvent(event, score, result);

					events++;
				}
				scoreboard.add(contestant);
			}
			column += 2;
		}

		return scoreboard;
	}
}