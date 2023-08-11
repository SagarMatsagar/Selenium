package SeleniumAd;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

    public void readExcel(String filePath,String fileName,String sheetName) throws IOException{

	    File file =    new File(filePath+"\\"+fileName);
	    FileInputStream inputStream = new FileInputStream(file);
	
	    Workbook bookobj = null;
	
	    String fileExtensionName = fileName.substring(fileName.indexOf("."));
	
	    if(fileExtensionName.equals(".xlsx")){
	
	    	bookobj = new XSSFWorkbook(inputStream);
	
	    }
	    else if(fileExtensionName.equals(".xls")){
	
	    	bookobj = new HSSFWorkbook(inputStream);
	    }
	
	    Sheet Sheetobj = bookobj.getSheet(sheetName);
	
	    int rowCount = Sheetobj.getLastRowNum()-Sheetobj.getFirstRowNum();
	    String Data[][]=new String[10][2];
	    for (int i = 0; i < rowCount+1; i++) {
	        Row row = Sheetobj.getRow(i);
	
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	        	Data[i][j]=row.getCell(j).getStringCellValue();
	            //System.out.print(row.getCell(j).getStringCellValue()+"|| ");
	        }
//	    Row row = Sheetobj.getRow(1);
//	    System.out.print(row.getCell(1).getStringCellValue());
//	    
//	        System.out.println();
	    } 
	    int i=2, j=2;
	    System.out.print(Data[i-1][j-1]);
    }  

    public static void main(String...strings) throws IOException{

     ExcelRead objExcelFile = new ExcelRead();

     String filePath ="C:\\Users\\a865093\\eclipse-workspace\\ExcelFiles";
    
    objExcelFile.readExcel(filePath,"Book.xlsx","LoginData");

    }

}
