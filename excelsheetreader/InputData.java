package excelsheetreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InputData {
	
	public static void main(String[] args) throws IOException {
		
		String path = "C:\\Users\\Admin\\OneDrive\\Documents\\Book1.xlsx" ;
		 File source  = new File(path);
		 FileInputStream fis = new FileInputStream(source);
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		 XSSFSheet sh1 = wb.getSheetAt(0);
		// DataFormatter df = new DataFormatter();
		 File file = new File(path);
		 FileOutputStream fos = new FileOutputStream(file);
	sh1.getRow(4).getCell(0).setCellValue("First input line");
	sh1.getRow(6).createCell(2).setCellValue("Second input line");
	sh1.createRow(12).createCell(6).setCellValue("Third line of method");
		 
		 wb.write(fos); 
		 
		 
		 
		
		
	}

}
