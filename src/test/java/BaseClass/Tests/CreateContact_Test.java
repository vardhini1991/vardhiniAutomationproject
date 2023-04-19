package BaseClass.Tests; 
import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.HomePageActual;
   
@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
 public class CreateContact_Test extends BaseClass
	{
		  
	@Test(groups="SmokeSuite")	     
			             
	  public void createContactTest() throws Throwable, IOException
	   {	
		String LASTNAME=eUtil.readDataFromExcel("Contact",1,2)+jUtil.getRandomNumber();
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
	
		}
	@Test
	public void demo()
	{
		System.out.println("demo");
	}

}
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		

		

		


