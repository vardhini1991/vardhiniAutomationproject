package Vtiger_practice;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class EXcel_file_practice {
		public static void main(String[] args) throws IOException 
		{
			//step1:load the file in java readable format
			   FileInputStream fis= new  FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			  
				
			//step2:create a workbook
			   Workbook wb=WorkbookFactory.create(fis);
			   
			//step3:get control over sheet
			   Sheet sh=wb.getSheet("Organisation");
			   
			//step4:get control over row
			   Row rw=sh.getRow(1);
			   
			//step5:get control over cell
			   Cell ce=rw.getCell(2);
			   
			//step6:read data inside the cell
			   String value=ce.getStringCellValue();
			   System.out.println(value);

		}

}


