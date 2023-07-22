package read_excel;

import java.io.FileInputStream;

import org.apache.poi.poifs.crypt.temp.SXSSFWorkbookWithCustomZipEntrySource;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {

	public static void main(String[] args) {
		
		// Open the Excel workbook
		
		FileInputStream fis = new FileInputStream(null)
		SXSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		
		// Open the sheet in that workbook
		XSSFSheet sheet1 = workbook.getSheet("Sheet1");
		
		
		
		// Read rows
		Row row1 = sheet1.getRow(2);
		
		
		// Read columns/cells
		Cell cell1 = row1.getCell(0);
		
		
		// Get the value in it
		String cell1Value = cell1 .getStringCellValue();
		System.out.println(cell1Value);
		
	}

}
