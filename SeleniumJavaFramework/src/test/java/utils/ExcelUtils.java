package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public static void main(String args[]) {
		//String excelPath = projectPath+"/excel/data.xlsx";
		//String sheetName = "Sheet1";
		//ExcelUtils obj = new ExcelUtils(excelPath,sheetName);
		getRowCount();
		getCellDataString(0,0);
		getCellDataNumber(1,1);
	}

	public ExcelUtils(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static int getRowCount(){
		int rowCount = 0;
		try {

			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Number of rows : "+rowCount);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}
		return rowCount;
	}

	public static int getColumnCount(){
		int columnCount = 0;
		try {

			columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Number of Columns : "+columnCount);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}
		return columnCount;
	}


	public static String getCellDataString(int rowNum, int columnNum) {

			String stringCellData = null;
		try {

			stringCellData = sheet.getRow(rowNum).getCell(columnNum).getStringCellValue();
			//String cellData1 = sheet.getRow(0).getCell(1).getStringCellValue();
			//String cellData2 = sheet.getRow(1).getCell(0).getStringCellValue();
			//double cellData3 = sheet.getRow(1).getCell(1).getNumericCellValue();
			//System.out.println("CellData is : "+cellData + "||" +cellData1 +" || "+cellData2+" || "+ cellData3);
			//System.out.println("Cell Data is : "+stringCellData);

		}catch(Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}
		return stringCellData;
	}
	public static double getCellDataNumber(int rowNum, int columnNum) {
		
		double numericCellData = 0.0;
		try {

			numericCellData = sheet.getRow(rowNum).getCell(columnNum).getNumericCellValue();
			System.out.println("CellData is : "+numericCellData);

		}catch(Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}
		return numericCellData;
	}
}
