package vtiger.Contacts.Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyfileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.CreateOrganizationPage;
import vtiger.ObjectRepository.HomePageActual;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

public class CreateContactWithOrg_POM 
{
	@Test
	public void createContactWithOrgTest() throws IOException
	//public static void main(String[] args) throws IOException 
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
		       
		       String LASTNAME=eUtil.readDataFromExcel("Contact",4,2)+jUtil.getRandomNumber();
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
				cop.createNewOrganization(ORGNAME);
				
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
				
		//Step9:create contact with organisation name
			 //1.Navigate to contacts link	
				hp.clickOnContactsLink();
		
       	     //2.Click on createcontact lookup image
				ContactsPage cp=new ContactsPage(driver);
				cp.clickOnCreateContactLookUpImg();
				
			//3.create contact with lastname and org name
				CreateContactPage ccp=new CreateContactPage(driver);
				ccp.createContact(driver, LASTNAME, ORGNAME);;
				
		
		//Step 10 :verify
					
				ContactInfoPage ci=new ContactInfoPage(driver);
				
				String CONTACTHEADER=ci.contactInfo();

				if(CONTACTHEADER.contains(LASTNAME))
				{
				System.out.println(CONTACTHEADER+"--verified--");
				}
				else
				{
				System.out.println(CONTACTHEADER+"---Not verified--");

				}
				
		//Step11:Logout
			hp.logoutApp(driver);

       //Step12:close browser
				driver.quit();
				
	}

}
