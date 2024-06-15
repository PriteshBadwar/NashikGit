package excelsheetreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Eg1ReadData {
public static void main(String[] args) throws IOException {
	
	String path = System.getProperty("user.dir")+"C:\\Users\\Admin\\OneDrive\\Documents\\ExcelSheetData.xlsx";
	File file = new File(path);
	FileInputStream fis = new FileInputStream(file);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sh1 = wb.getSheetAt(0);
	DataFormatter df = new DataFormatter();
	String data1 = df.formatCellValue(sh1.getRow(11).getCell(0));
	String data2 =df.formatCellValue(sh1.getRow(13).getCell(0));
	
	System.out.println(data1);
	
	
	
	
	
	
	
	
}
}
