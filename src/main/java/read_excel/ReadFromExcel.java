package read_excel;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {

	public static void main(String[] args) throws IOException {

		// Open the Excel workbook

		FileInputStream fis = new FileInputStream("src\\main\\java\\testdata\\January income expense sheet..xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Open the sheet in that workbook
		XSSFSheet sheet1 = workbook.getSheet("Sheet1");

		// Read rows
		Row row1 = sheet1.getRow(9);
		Row row2 = sheet1.getRow(9);

		// Read columns/cells
		Cell cell1 = row1.getCell(0);
		Cell cell2 = row2.getCell(1);

		// Get the value in it
		String cell1Value = cell1.getStringCellValue();
		System.out.println(cell1Value);
		double cell2Value = cell2.getNumericCellValue();
		System.out.println(cell2Value);

	}

}
