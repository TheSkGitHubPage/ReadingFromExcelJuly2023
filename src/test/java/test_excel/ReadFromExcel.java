package test_excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelReader;

public class ReadFromExcel {
	
	@Test(dataProvider = "dataProv1")
	public void test1(String username, String password) {
		System.out.println(username + " : " + password);
	}
	
	@DataProvider
	public Object[][] dataProv1() {
		ExcelReader excelReader = new ExcelReader("src\\main\\java\\excel\\Book1.xlsx", "Sheet1");
		return excelReader.getTableData("Table2");
	}
	
	
}
