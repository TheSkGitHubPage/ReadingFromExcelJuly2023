package reading_file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoExc {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("src\\main\\java\\testdata\\January income expense sheet..xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Open the sheet in that workbook
		XSSFSheet sheet1 = workbook.getSheet("Sheet1");

		// Read rows
		Row row1 = sheet1.getRow(9);
		Row row2 = sheet1.getRow(9);
		
		// Read columns/cells
		Cell cell1 = row1.getCell(0);
		Cell cell2 = row2.getCell(9);

		// Get the value in it
		String cell1Value = cell1.getStringCellValue();
		double cell2Value = cell2.getNumericCellValue();
		System.out.println(cell1Value);
		System.out.println(cell2Value);

	}

}
