package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {
  
	//public static final String currentDir = System.getProperty("user.dir");  // to get current folder directory
	 
	private static String filePath = ".\\resources\\TestData.xlsx";
	private static Workbook wb;
	private static Sheet ws;
	private static Row row;
	private static Cell cell;
	public static int rowNumber;
	public static int colNumber;	
	
	private static void readExcel() {
		//Create an object of File class to open xlsx file
		
        try {
			FileInputStream fs = new FileInputStream(filePath);
			wb = new XSSFWorkbook(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        catch (Exception e) {
        	e.printStackTrace();
        } 
	}
	
	public static void readSheet(String sheetName) {
		if (wb == null) {
			readExcel();
		}			
		ws = wb.getSheet(sheetName);	
		System.out.println("readSheet = " + sheetName);
		System.out.println("readSheet getNumberOfSheets: " + wb.getNumberOfSheets());
		System.out.println("readSheet getSheetName: " + ws.getSheetName());
	}
		
        
	public static String getValue(int rowNumber,int colNumber) {
		System.out.println("getValue: " + rowNumber+" "+colNumber  +  " " + ws.getSheetName());
		DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
		
		row = ws.getRow(rowNumber);
		cell = row.getCell(colNumber);		
		return formatter.formatCellValue(cell); //Returns the formatted value of a cell 
	}
	
	
}
