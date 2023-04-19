package Vtiger_practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Writedatainto_Excel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		//step1:load the file into fileinput stream in java readable format
		   FileInputStream fis= new  FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		  
			
		//step2:create a workbook
		   Workbook wb=WorkbookFactory.create(fis);
		   
		//step3:get inside sheet
		   Sheet sh=wb.getSheet("Organisation");
		   
		//step4:get the used row
		   Row rw=sh.getRow(1);
		   
		//step5:create a cell
		   Cell ce=rw.createCell(7);
		   
		//step6:write data into cell
		   ce.setCellValue("Himanya");
		
		//step7:open the file in java writable format and write into workbook
		   FileOutputStream fos=new  FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		   wb.write(fos);
		   System.out.println("Data added");
		   wb.close();
		   }

}
