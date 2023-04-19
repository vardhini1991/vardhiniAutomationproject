package POMclass.Tests;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyfileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.HomePageActual;
import vtiger.ObjectRepository.LoginPage;

public class CreateContact_Test {
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{ 
		// create object of Generic Utilities
		
		PropertyfileUtility pUtil=new PropertyfileUtility();
		ExcelUtility eUtil=new ExcelUtility();
		JavaUtility jUtil=new JavaUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
	//Read data from Generic utilities
		 String URL=pUtil.readDataFromPropertyFile("url");
	     String BROWSER=pUtil.readDataFromPropertyFile("browser");
	     String USERNAME=pUtil.readDataFromPropertyFile("username");
         String PASSWORD=pUtil.readDataFromPropertyFile("password");
         
         String LASTNAME=eUtil.readDataFromExcel("Contact",1,2)+jUtil.getRandomNumber();
         
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
	
		
	//Login
		LoginPage lp=new LoginPage (driver);
		lp.loginToApp(USERNAME,PASSWORD);
		
	//click on contact link
		HomePageActual hp=new HomePageActual(driver);
		hp.clickOnContactsLink();
	
   //click on create contact lookup image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		
	//create contact with mandatory fields
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createContact(LASTNAME);
		
	//Verify contact 	
		ContactInfoPage ci=new ContactInfoPage(driver);
		
		String CONTACTHEADER=ci.contactInfo();
		if(CONTACTHEADER.contains(LASTNAME))
		{
			System.out.println(CONTACTHEADER+"---verified---");
		}
		else
		{
			System.out.println("---Not verified---");
		}
		
	//logout
		hp.logoutApp(driver);
		
	//close Browser
		driver.quit();
	}

}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

	

	
