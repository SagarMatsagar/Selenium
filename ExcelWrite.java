package SeleniumAd;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

    public void writeExcel(String filePath,String fileName,String sheetName,String[] dataToWrite) throws IOException{
    	
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
    Sheet sheet = bookobj.getSheet(sheetName);

    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

    Row row = sheet.getRow(0);
    Row newRow = sheet.createRow(rowCount+1);

    for(int j = 0; j < row.getLastCellNum(); j++){

        Cell cell = newRow.createCell(j);

        cell.setCellValue(dataToWrite[j]);

    }

    inputStream.close();
    
    FileOutputStream outputStream = new FileOutputStream(file);

    bookobj.write(outputStream);

    outputStream.close();
	
    }

    public static void main(String...strings) throws IOException{

        String[] valueToWrite = {"Sagar","Shiv123"};

        ExcelWrite objExcelFile = new ExcelWrite();

        objExcelFile.writeExcel("C:\\Users\\a865093\\eclipse-workspace\\ExcelFiles","Book.xlsx","LoginData",valueToWrite);

    }

}
