package sprint1;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Excel Tester.
 *
 * @author <Authors name>
 * @since <pre>Jun 30, 2021</pre>
 * @version 1.0
 */
public class ExcelTest {
    private Workbook workbook;
    private Excel excel;
    private Name name;
    //private String name;
    Cell cell, cell1;
    private int number;
    private int place;
    private String country;
    private Row row;
    private Sheet sh, sh2;
    private String excelName;

    /**
     * Method: decaColumnA()
     */
    @Test
    public void testDecaColumnACreateNameMaxBoundry() throws Exception {
        workbook = new HSSFWorkbook ();
        this.sh = workbook.createSheet ("lasjdhfgotiyurewqutrhegsnabzxcvp");
        this.name = workbook.createName ();

        assertNotNull (sh);
        assertNotSame ("lasjdhfgotiyurewqutrhegsnabzxcvp", sh.getSheetName ());
    }

    @Test
    public void testDecaColumnACreateNameSingle() throws Exception {
        workbook = new HSSFWorkbook ();
        this.sh = workbook.createSheet ("D");
        this.name = workbook.createName ();

        assertNotNull (sh);
        assertEquals ("D", sh.getSheetName ());
    }

    @Test
    public void testDecaColumnA() throws Exception {
        workbook = new HSSFWorkbook ();
        excel = new Excel (excelName, false);
        this.sh = workbook.createSheet ("Decathlon");
        //this.name = row.setRowNum ();

        assertNotNull (sh);
        assertEquals ("Decathlon", sh.getSheetName ());
    }

    /**
     * Method: heptaContestantRegistration(Contestant cont)
     */
    @Test
    public void testHeptaContestantRegistration2() throws Exception {
        Contestant cont = new Contestant ("Simone Biles", 232, "USA");

        HSSFWorkbook wb = new HSSFWorkbook ();
        Sheet sh = wb.createSheet ();
        Row row = sh.createRow (0);

        Cell name = row.createCell (0);
        name.setCellValue (cont.getName ());

        Cell number = row.createCell (1);
        number.setCellValue (cont.getNumber ());

        Cell country = row.createCell (2);
        country.setCellValue (cont.getCountry ());

        assertEquals (cont.getName (), "Simone Biles");
        assertEquals (cont.getNumber (), 232);
        assertEquals (cont.getCountry (), "USA");
        assertEquals (row.getCell (0), name);
        assertEquals (row.getCell (1), number);
        assertEquals (row.getCell (2), country);

    }

    /**
     * Method: heptaColumnA()
     */
    @Test
    public void testHeptaColumnA() throws Exception {
        workbook = new HSSFWorkbook ();
        this.sh2 = workbook.createSheet ("Heptathlon");

        assertNotNull (sh2);
        assertEquals ("Heptathlon", sh2.getSheetName ());
    }


    @Test
    public void testDecaContestantRegistration2() throws Exception {
        Contestant cont = new Contestant ("Calvin Hall", 187, "USA");

        HSSFWorkbook wb = new HSSFWorkbook ();
        Sheet sh = wb.createSheet ();
        Row row = sh.createRow (0);

        Cell name = row.createCell (0);
        name.setCellValue (cont.getName ());

        Cell number = row.createCell (1);
        number.setCellValue (cont.getNumber ());

        Cell country = row.createCell (2);
        country.setCellValue (cont.getCountry ());

        assertEquals (cont.getName (), "Calvin Hall");
        assertEquals (cont.getNumber (), 187);
        assertEquals (cont.getCountry (), "USA");
        assertEquals (row.getCell (0), name);
        assertEquals (row.getCell (1), number);
        assertEquals (row.getCell (2), country);

    }

}
