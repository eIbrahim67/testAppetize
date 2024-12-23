package testAppetize;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility {
	
    String filePath = "C:\\Users\\ibrah\\Documents\\Console\\Java\\testAppetize\\src\\testAppetize\\appetize_data_test.xlsx";
    String sheet;
    File f = new File(filePath);
    FileInputStream fis;
    XSSFWorkbook wb;
    XSSFSheet sht;

    public ExcelUtility(String sheet) throws FileNotFoundException, IOException {
        this.sheet = sheet;
        fis = new FileInputStream(f);
        wb = new XSSFWorkbook(fis);
        sht = wb.getSheet(sheet);
    }

    public String getData(int row, int col) throws IOException {
        Row currentRow = sht.getRow(row); 
        if (currentRow == null || currentRow.getCell(col) == null) {
            return "empty";  
        }

        return currentRow.getCell(col).getStringCellValue();
    }

    public int count() throws IOException {
        //return sht.getPhysicalNumberOfRows();
    	return 1;
    }
}
