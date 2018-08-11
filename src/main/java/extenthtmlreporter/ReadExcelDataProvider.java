package extenthtmlreporter;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelDataProvider {
	@Test
	public Object[][] readExcel(String fileName) throws IOException {
		//Goto the workbook
		XSSFWorkbook wBook = new XSSFWorkbook("C:\\Users\\Nagendra\\Desktop\\"+fileName+".xlsx");
		
		//goto the sheet
		XSSFSheet sheet = wBook.getSheetAt(0);
		
		//Find the row count excluding header
		int rowCount = sheet.getLastRowNum();
		
		//find the cell count
		
		short cellCount = sheet.getRow(0).getLastCellNum();
		
		//Read the data
		Object[][] data = new Object[rowCount][cellCount];
		for (int i=1; i<=rowCount; i++) {
			//Jump into the row
			XSSFRow row = sheet.getRow(i);
			for ( int j= 0; j<cellCount; j++) {
				
				//jump into the specific cell
				XSSFCell cell = row.getCell(j);
				 data[i-1][j] = cell.getStringCellValue();
				System.out.println(data);
				
			}
		}
		wBook.close();
		return data;
	}

}
