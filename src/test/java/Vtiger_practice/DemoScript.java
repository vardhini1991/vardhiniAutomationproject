package Vtiger_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoScript {

	public static void main(String[] args) throws IOException
    {
	//step1:read all neccessary data 
	/*read from property file*/
		 FileInputStream fisp= new  FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		 Properties pObj=new Properties();
		 pObj.load(fisp);
		 String BROWSER=pObj.getProperty("browser");
		 String URL=pObj.getProperty("url");
		 String USERNAME=pObj.getProperty("username");
		 String PASSWORD=pObj.getProperty("password");
		 
		Random r=new Random();
		int value=r.nextInt(100000);
		
	/*Read data from Excel sheet*/
		 FileInputStream fise= new  FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		 Workbook wb=WorkbookFactory.create(fise);
		 String ORGNAME=wb.getSheet("Organisation").getRow(1).getCell(2).getStringCellValue()+value;
		 wb.close();
		 
	 //1.launching browser
		 WebDriver driver=null;
		 /*launch browser RUNTIME POLYMORPHISM*/
		 if(BROWSER.equalsIgnoreCase("chrome"))
		 {
			 driver=new ChromeDriver();
		 }
		 else if(BROWSER.equalsIgnoreCase("firefox"))
		 {   WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		 }
		 else
			 System.out.println("invalid browser name");
	
	 //2.search url	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
     //3.login operation
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
	  	
	 //4.create organisation
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
	//5.save
		driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
		
	//6.verify
		String orgheader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(orgheader);
		if(orgheader.contains(ORGNAME))
		{
			System.out.println(orgheader+"account verified");
		}
		else
			System.out.println("not verified");
		
		
	//7.signout operation
		WebElement element1=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(element1).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("signout successfully");
		
	//7.close browser
		driver.quit();
		

	}

}
