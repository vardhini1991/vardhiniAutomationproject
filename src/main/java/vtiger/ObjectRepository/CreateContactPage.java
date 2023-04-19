package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility
{ 

//Rule 1: create POM class for every webpage 
	
  //Rule 2:Identify all the webElements using annotations
	
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath="//input[@name='account_name' ]//following-sibling:: img[@alt='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement OrgSearchEdt;
	
	@FindBy(name="search")
	private WebElement OrgSearchBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
 //Rule 3: Initialise these WebElements using constructor
	
	public CreateContactPage(WebDriver driver)
	{
	 PageFactory.initElements(driver,this);	
	}
	
 //Rule 4:provide getters to access these elements	

	public WebElement getLastNameEdt()
	{
		return LastNameEdt;
	}

	public WebElement getSaveBtn() 
	{
		return SaveBtn;
	}
	public WebElement getOrgLookUpImg() 
	{
			return OrgLookUpImg;
	}

	public WebElement getOrgSearchEdt() 
	{
			return OrgSearchEdt;
	}

	public WebElement getOrgSearchBtn() 
	{
			return OrgSearchBtn;
	}

	
	
	//Businesslogic-project specific generic methods
	/**
	 * This method will create contact with mandatory information
	 * @author Vardhini
	 * @param LastName
	 */
 
   public void createContact(String LASTNAME)	
   {
	 LastNameEdt.sendKeys(LASTNAME);
	 SaveBtn.click();
   }
   
   /**
    *  This method will create contact with organization
    * @param driver
    * @param LASTNAME
    * @param ORGNAME
    */
   public void createContact(WebDriver driver,String LASTNAME,String ORGNAME)	
   {
	 LastNameEdt.sendKeys(LASTNAME);
	 OrgLookUpImg.click();
	 switchToWindow(driver,"Accounts");
	 OrgSearchEdt.sendKeys(ORGNAME);
	 OrgSearchBtn.click();
	 driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
	 switchToWindow(driver,"Contacts");
	 SaveBtn.click();
   }
}   
  
  
  
  
  


	


