package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage
 {
  //Rule 1:create seperate POM class for every webpage
	 
 //Rule 2:Identify Webelements using Annotations
	//Declaration
	
   @FindBy(xpath="//img[@title='Create Organization...']")
   private WebElement CreateOrgLookUp ;
   
   //Initializtion
    public OrganizationPage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }

   //Utilization
	public WebElement getCreateOrgLookUp() {
		return CreateOrgLookUp;
	}
	
	//Business logic
	/**
	 * This method will click on Org lookup image
	 */
	 public void clickOnCreateOrganizationLookupImg()
	 {
		 CreateOrgLookUp.click(); 
	 }
   
 
    
   
   
 }
 
