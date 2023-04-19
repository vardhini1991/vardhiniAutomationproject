package BaseClass.Tests;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.CreateOrganizationPage;
import vtiger.ObjectRepository.HomePageActual;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;
@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateContactWithOrganization_Test extends BaseClass
{
  @Test(groups="RegressionSuite")
   public void createContactWithOrgTest() throws Throwable, IOException
   {
	  String LASTNAME=eUtil.readDataFromExcel("Contact",4,2)+jUtil.getRandomNumber();
      String ORGNAME=eUtil.readDataFromExcel("Organisation", 4, 2)+jUtil.getRandomNumber();
	  	
	 //Step 1:.create organisation
			HomePageActual hp=new HomePageActual(driver);
			hp.clickOnOrganizationLink();
			
	//Step 2 :.click on createOrganization look up image
			OrganizationPage op=new OrganizationPage(driver);
			op.clickOnCreateOrganizationLookupImg();
			
	//Step 3:.create organistion with mandatory data	
			CreateOrganizationPage cop=new CreateOrganizationPage(driver);
			cop.createNewOrganization(ORGNAME);
			
	//Step 4:verify organization
			OrganizationInfoPage oip=new OrganizationInfoPage(driver);
			String orgheader=oip.OrganisationInfo();
			System.out.println(orgheader);
			if(orgheader.contains(ORGNAME))
			{
				System.out.println(orgheader+"---ORGANISATION Created---");
			}
			else
				System.out.println("---ORG not created---");
			
	//Step5:create contact with organisation name
		 //1.Navigate to contacts link	
			hp.clickOnContactsLink();
	
 	     //2.Click on createcontact lookup image
			ContactsPage cp=new ContactsPage(driver);
			cp.clickOnCreateContactLookUpImg();
			
		//3.create contact with lastname and org name
			CreateContactPage ccp=new CreateContactPage(driver);
			ccp.createContact(driver, LASTNAME, ORGNAME);;
			
	
	//Step 6 :verify
				
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
			
    }
}