package Assertions.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.HomePageActual;
@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateContactTest extends BaseClass
{
	@Test	     
    
	  public void createContactTest() throws Throwable, IOException
	   {	
		String LASTNAME=eUtil.readDataFromExcel("Contact",1,2)+jUtil.getRandomNumber();
		//click on contact link
			HomePageActual hp=new HomePageActual(driver);
			hp.clickOnContactsLink();
			Reporter.log("clicked on Contacts link",true);
		
	   //click on create contact lookup image
			ContactsPage cp=new ContactsPage(driver);
			cp.clickOnCreateContactLookUpImg();
			Reporter.log("clicked on create Contact lookup");
		//create contact with mandatory fields
			CreateContactPage ccp=new CreateContactPage(driver);
			ccp.createContact(LASTNAME);
			Reporter.log("created contact with mandatory fields");
		//Verify contact 	
			ContactInfoPage ci=new ContactInfoPage(driver);
			//Assert.fail();
			
			String CONTACTHEADER=ci.contactInfo();
		/*	if(CONTACTHEADER.contains(LASTNAME))
			{
				System.out.println(CONTACTHEADER+"---verified---");
			}
			else
			{
				System.out.println("---Not verified---");
			}
			*/
			Assert.assertTrue(CONTACTHEADER.contains(LASTNAME));
			System.out.println(CONTACTHEADER+"---verified---");
	
		}
}
