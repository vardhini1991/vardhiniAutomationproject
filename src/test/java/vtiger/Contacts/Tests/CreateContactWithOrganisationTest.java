package vtiger.Contacts.Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyfileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateContactWithOrganisationTest {

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
		       
		       String LASTNAME=eUtil.readDataFromExcel("Contact",4,2);
		       String ORGNAME=eUtil.readDataFromExcel("Organisation", 4, 3)+jUtil.getRandomNumber();
		       
		    //Step3:Creating Organisation
		       
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
					System.out.println(orgheader+"---ORGANISATION Created---");
				}
				else
					System.out.println("---ORG not created---");
				
		//Step4:create contact with organisation name
			 //1.Navigate to contacts link	
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
       	     //2.Click on createcontact lookup image
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
			//3.clickon lastname and send data
				driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
				
			//4.click on organisation lookup image
				driver.findElement(By.xpath(" //input[@name='account_name' ]//following-sibling:: img[@alt='Select']")).click();
				
			//5.switch the control to child window
				wUtil.switchToWindow(driver,"Accounts");
				
		    //6.search for organisation name
				driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ORGNAME);
				driver.findElement(By.xpath("//input[@name='search']")).click();
				
	        //7.choose the organisation
				driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
				
			//8.Switch back the control to main window
				wUtil.switchToWindow(driver, "Contacts");
				
			//9.save
				driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
			
			//10.verify

				String CONTACTHEADER=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

				if(CONTACTHEADER.contains(LASTNAME))
				{
				System.out.println(CONTACTHEADER+"--verified--");
				}
				else
				{
				System.out.println(CONTACTHEADER+"---Not verified--");

				}
				
		//Step5:Logout
				WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			    wUtil.mouseHoverAction(driver, element);

				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

       //Step6:close browser
				driver.quit();
				
	}

}
