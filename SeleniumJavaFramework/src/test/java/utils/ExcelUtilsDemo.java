package utils;

public class ExcelUtilsDemo {
	public static void main(String args[]) {
		String projectPath = System.getProperty("user.dir");
		ExcelUtils obj = new ExcelUtils(projectPath+"/excel/data.xlsx", "Sheet1");
		obj.getRowCount();
		obj.getCellDataString(0, 0);
		obj.getCellDataNumber(1, 1);
	}
}
