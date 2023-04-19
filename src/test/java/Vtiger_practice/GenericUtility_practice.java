package Vtiger_practice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyfileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class GenericUtility_practice {

	public static void main(String[] args) throws Throwable 
	{
  //1.PropertyfileUtility practice	
		
     PropertyfileUtility pUtil=new PropertyfileUtility();
     String data=pUtil.readDataFromPropertyFile("url");
     String data1=pUtil.readDataFromPropertyFile("browser");
     System.out.println(data);
     System.out.println(data1);
     
   //2.ExcelUtility practice
    //a.Read data from excel
     ExcelUtility eUtil=new ExcelUtility();
     String value=eUtil.readDataFromExcel("Organisation", 1, 2);
     System.out.println(value);
    //b.Write data into excel
     eUtil.writeDataIntoExcel("Organisation", 10, 7, value);
     System.out.println("Data added");
     
   //3.JavaUtility practice  
     JavaUtility jUtil=new JavaUtility();
     System.out.println(jUtil.getRandomNumber());
     
     System.out.println(jUtil.getSystemDate());
     
     System.out.println(jUtil.getSystemDateInFormat());
     
    //4.WebdriverUtility practice
     WebDriverManager.firefoxdriver().setup();
     WebDriver driver=new FirefoxDriver();
     
     WebDriverUtility wUtil=new WebDriverUtility();
     wUtil.maximizewindow(driver);
     Thread.sleep(3000);
     wUtil.minimizewindow(driver);
     
     
	}

}
