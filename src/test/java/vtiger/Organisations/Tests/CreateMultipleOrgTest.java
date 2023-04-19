package vtiger.Organisations.Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyfileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.CreateOrganizationPage;
import vtiger.ObjectRepository.HomePageActual;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;
@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateMultipleOrgTest 
{

  ExcelUtility eUtil=new ExcelUtility();
  JavaUtility jUtil=new JavaUtility();
  @Test(dataProvider="OrgWithIndustry")
 public void createOrgTest(String ORG,String Industry) throws IOException
 {
	//step1:Create object of Generic Utilities
		PropertyfileUtility pUtil=new PropertyfileUtility();
		
		WebDriverUtility wUtil=new WebDriverUtility();
		
  //step2;Read all the required data 
	   String URL=pUtil.readDataFromPropertyFile("url");
     String BROWSER=pUtil.readDataFromPropertyFile("browser");
     String USERNAME=pUtil.readDataFromPropertyFile("username");
     String PASSWORD=pUtil.readDataFromPropertyFile("password");
   
     String ORGNAME=ORG+jUtil.getRandomNumber();
     
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
	
	 //search url	
		wUtil.maximizewindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		
  //Step :4.login operation
		LoginPage lp=new LoginPage (driver);
		lp.loginToApp(USERNAME,PASSWORD);
		
	  	
  //Step 5:.create organisation
		HomePageActual hp=new HomePageActual(driver);
		hp.clickOnOrganizationLink();
		
  //Step 6 :.click on createOrganization look up image
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrganizationLookupImg();
		
  //Step 7:.create organistion with mandatory data	
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createNewOrganization(ORGNAME, Industry);
		
   //Step 8:verify
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String orgheader=oip.OrganisationInfo();
		System.out.println(orgheader);
		if(orgheader.contains(ORGNAME))
		{
			System.out.println(orgheader+"---ORGANISATION Created---");
		}
		else
			System.out.println("---ORG not created---");
		
		
  //Step9:Logout
			hp.logoutApp(driver);
			System.out.println("Signout sucessfully");
			
 }

@DataProvider(name="OrgWithIndustry")
 public Object[][] getData() throws EncryptedDocumentException, IOException
 {
	Object[][] data= eUtil.readDatafromExcelToDataProvider("dataProviderOrg");
	return data;
 }

}
