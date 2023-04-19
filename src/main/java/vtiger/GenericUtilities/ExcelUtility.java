package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consists of generic methods related to excel
 * @author vardhini
 *
 */

public class ExcelUtility 
{
/**
 * This method will read data from excel sheet	
 * @param sheetName
 * @param rowNo
 * @param celNo
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
  public String readDataFromExcel(String sheetName,int rowNo,int celNo) throws EncryptedDocumentException, IOException 
  {
	FileInputStream fis=new FileInputStream(IConstantUtility.excelfilepath);
	Workbook wb=WorkbookFactory.create(fis);
	String value=wb.getSheet(sheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
	wb.close();
	return value;
  }
  /**
   * This methiod will write data into Excel
   * @param sheetName
   * @param rowNo
   * @param celNo
   * @param value
   * @throws IOException
   */
  public void writeDataIntoExcel(String sheetName,int rowNo,int celNo,String value) throws IOException
  {
		FileInputStream fis=new FileInputStream(IConstantUtility.excelfilepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
	    Row rw=sh.createRow(rowNo);
		Cell ce=rw.createCell(celNo);
		ce.setCellValue(value);
		FileOutputStream fos=new  FileOutputStream(IConstantUtility.excelfilepath);
		wb.write(fos);
	    System.out.println("Data added");
		wb.close();
	}
  
  /**
   * This method will read data excel sheet and return it to data provider
   * @author vardhini
   * @param SheetName
   * @return
   * @throws EncryptedDocumentException
   * @throws IOException
   */
  public Object[][] readDatafromExcelToDataProvider(String SheetName) throws EncryptedDocumentException, IOException
  {
		FileInputStream fis=new FileInputStream(IConstantUtility.excelfilepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName); 
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		
		Object[][] data= new Object[lastRow][lastCell]; 
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
		  
  }  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  





















}
		
		
		
		
		
		
		
  
  
  
  
  
  
 
  
  
  
  
  
  
  
  
  
  
  
  
  
