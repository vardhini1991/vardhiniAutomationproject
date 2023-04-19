package vtiger.Organisations.Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyfileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateOrganisationTest {

	public static void main(String[] args) throws IOException
	{
	//step1:Create object of Generic Utilities
		PropertyfileUtility pUtil=new PropertyfileUtility();
		ExcelUtility eUtil=new ExcelUtility();
		JavaUtility jUtil=new JavaUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
    //step2;Read all the required data 
	   String URL=pUtil.readDataFromPropertyFile("url");
       String BROWSER=pUtil.readDataFromPropertyFile("browser");
       String USERNAME=pUtil.readDataFromPropertyFile("username");
       String PASSWORD=pUtil.readDataFromPropertyFile("password");
       
       String ORGNAME=eUtil.readDataFromExcel("Organisation", 1, 2)+jUtil.getRandomNumber();
       
       //1.launching browser
		 WebDriver driver=null;
		 /*launch browser RUNTIME POLYMORPHISM*/
		 if(BROWSER.equalsIgnoreCase("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		 }
		 else if(BROWSER.equalsIgnoreCase("firefox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		 }
		 else
			 System.out.println("invalid browser name");
	
	 //2.search url	
		wUtil.maximizewindow(driver);
		wUtil.waitForPageLoad(driver);
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
		wUtil.mouseHoverAction(driver, element1);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("signout successfully");
		
	//8.close browser
		driver.quit();
		

	}
       
}
