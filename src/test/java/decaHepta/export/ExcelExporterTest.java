package decaHepta.export;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ExcelExporterTest {

    @Test
    public void exportTest() throws IOException {
    	List<String> headers = new ArrayList<>();
    	headers.add("First name");
    	headers.add("Last name");
    	headers.add("Sport Type");
    	headers.add("Result");
    	headers.add("Points");
    	
    	List<List<Object>> rowData = new ArrayList<>();
    	List<Object> competitor1 = new ArrayList<>();
    	competitor1.add("John");
    	competitor1.add("Smith");
    	competitor1.add("100m");
    	competitor1.add("12s");
    	competitor1.add("100");
    	rowData.add(competitor1);
    	List<Object> competitor2 = new ArrayList<>();
    	competitor2.add("Mark");
    	competitor2.add("Dow");
    	competitor2.add("100m");
    	competitor2.add("13s");
    	competitor2.add("90");
    	rowData.add(competitor2);
    	
    	// ExcelExporter.export(headers, rowData);
    }
}
