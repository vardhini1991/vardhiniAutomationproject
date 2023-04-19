package BaseClass.Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.CreateOrganizationPage;
import vtiger.ObjectRepository.HomePageActual;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

public class CreateOrgWithIndusrty_Test extends BaseClass
{
	@Test
	public void createOrganisationTest() throws EncryptedDocumentException, IOException
	{
		String ORGNAME=eUtil.readDataFromExcel("Organisation",4,2)+jUtil.getRandomNumber();
	  	String Industry=eUtil.readDataFromExcel("Organisation",4,3); 
	 //1.create organisation
	     
		//click on Organisation link
		HomePageActual hp=new HomePageActual(driver);
		hp.clickOnOrganizationLink();
	
   //click on create contact lookup image
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrganizationLookupImg();
		
	//create contact with mandatory fields
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createNewOrganization(ORGNAME,Industry);

		
	//3.verify
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String orgheader=oip.OrganisationInfo();
		if(orgheader.contains(ORGNAME))
		{
			System.out.println(orgheader+"account verified");
		}
		else
			System.out.println("not verified");
	}
	
	
}
