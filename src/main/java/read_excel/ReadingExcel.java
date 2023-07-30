package read_excel;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

	public static void main(String[] args) throws IOException {

		String excelFilePath = "src\\main\\java\\testdata\\February income expense sheet..xlsx";
		FileInputStream inputStream = new FileInputStream(excelFilePath);

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();

		for (int r = 0; r <= rows; r++) {
			XSSFRow row = sheet.getRow(r);

			if (row != null) {
				for (int c = 0; c < cols; c++) {
					XSSFCell cell = row.getCell(c);

					if (cell != null) {
						switch (cell.getCellType()) {
						case STRING:
							System.out.print(cell.getStringCellValue());
							break;
						case NUMERIC:
							System.out.print(cell.getNumericCellValue());
							break;
						case BOOLEAN:
							System.out.print(cell.getBooleanCellValue());
							break;
						default:
							System.out.print(""); // Empty cell value
						}
					} else {
						System.out.print(""); // Null cell value
					}
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		workbook.close();
		inputStream.close();
	}
}
