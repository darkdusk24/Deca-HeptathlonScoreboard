package decaHepta.export;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.ss.usermodel.FillPatternType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class ExcelExporter {
	
	public static void export(List<String> headers, List<List<Object>> rows) throws IOException {
        Workbook workbook = new XSSFWorkbook();

        try {
            Sheet sheet = workbook.createSheet("Scoreboard");

            Row header = sheet.createRow(0);
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            font.setFontName("Arial");
            font.setFontHeightInPoints((short) 16);
            font.setBold(true);
            headerStyle.setFont(font);
            for (int i = 0; i < headers.size(); i++) {
            	String headerName = headers.get(i);
            	Cell headerCell = header.createCell(i);
                headerCell.setCellValue(headerName);
                headerCell.setCellStyle(headerStyle);
            }
 
            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);
            
            for (int i = 0; i < rows.size(); i++) {
            	List<Object> rowData = rows.get(i);
            	Row row = sheet.createRow(i + 1); 
            	for (int j = 0; j < rowData.size(); j++) {
	                Cell cell = row.createCell(j);
	                cell.setCellValue(rowData.get(j) != null ? rowData.get(j).toString() : "");
	                cell.setCellStyle(style);
            	}
            }

            File currDir = new File(".");
            String path = currDir.getAbsolutePath();
            String fileLocation = path.substring(0, path.length() - 1) + "Scoreboard.xlsx";

            FileOutputStream outputStream = new FileOutputStream(fileLocation);
            workbook.write(outputStream);
        } finally {
            if (workbook != null) {
            	workbook.close();
               
            }
        }
    }
}
