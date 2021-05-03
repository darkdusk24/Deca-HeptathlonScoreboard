package sprint1;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
public class Excel {
									   
	public static void main(String[] args) {
		//Create workbook in .xls format
		Workbook workbook = new HSSFWorkbook();
		//For .xslx workbooks use XSSFWoorkbok();
		//Create Sheets
		Sheet sh = workbook.createSheet("Decathlon");
		Sheet sh2 = workbook.createSheet("Heptathlon");
				
		//Create Rows and Cells and a value for Decathlon ROW 1
		Row row0 = sh.createRow(0);			
		
		row0.createCell(0).setCellValue("Number");
		row0.createCell(1).setCellValue("First Name");
		row0.createCell(2).setCellValue("Last Name");
		row0.createCell(3).setCellValue("Event 1");
		row0.createCell(4).setCellValue("Event 2");
		row0.createCell(5).setCellValue("Event 3");
		row0.createCell(6).setCellValue("Event 4");
		row0.createCell(7).setCellValue("Event 5");
		row0.createCell(8).setCellValue("Day 1 points");
		row0.createCell(9).setCellValue("Event 6");
		row0.createCell(10).setCellValue("Event 7");
		row0.createCell(11).setCellValue("Event 8");
		row0.createCell(12).setCellValue("Event 9");
		row0.createCell(13).setCellValue("Event 10");
		row0.createCell(14).setCellValue("Day 2 points");
		row0.createCell(15).setCellValue("Total points");
		//Create Rows and Cells and a value for Decathlon ROW 2
		Row row1 = sh.createRow(1);
		row1.createCell(0).setCellValue("1:A");
		row1.createCell(1).setCellValue("Pär");
		row1.createCell(2).setCellValue("Andersson");
		row1.createCell(8).setCellValue(3000);
		row1.createCell(14).setCellValue(4000);
		row1.createCell(15).setCellFormula("I2+O2");
		
		//Autosize columns
		for(int i=0;i<16;i++) {
			sh.autoSizeColumn(i);
		}
		try {
			//Write the output to file
			FileOutputStream output = new FileOutputStream("C:\\Users\\snick\\Desktop\\Deca-HeptathlonScoreboard.xls");
			workbook.write(output);
			output.close();
			workbook.close();
			System.out.println("Excel-file is Completed");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}