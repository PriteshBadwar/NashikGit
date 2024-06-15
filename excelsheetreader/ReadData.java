package excelsheetreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {
public static void main(String[] args) throws IOException {
	
	 String path = System.getProperty("user.dir") + File.separator + "C:\\Users\\Admin\\OneDrive\\Documents\\ExcelSheetData.xlsx";
     File file = new File(path);
     FileInputStream fis = new FileInputStream(file);
     XSSFWorkbook wb = new XSSFWorkbook(fis);
     XSSFSheet sh1 = wb.getSheetAt(0);
     DataFormatter df = new DataFormatter();
     
	String data = df.formatCellValue(sh1.getRow(2).getCell(0));
	System.out.println(data);
	
	int getRow = sh1.getLastRowNum();
	System.out.println(getRow);
	
	 int allRows = sh1.getLastRowNum()+1;
	 int allCells = sh1.getRow(0).getLastCellNum();
	for(int i=0;i<=allRows;i++)
	{
		for(int j =0;j<=allCells;j++)
		{
			
			
			String allValues = df.formatCellValue( sh1.getRow(i).getCell(j));
			System.out.println(allValues);
			
		}
	}
	
}
	
	
}
