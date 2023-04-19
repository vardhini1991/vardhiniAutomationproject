package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility
{
 //Declaration
	
  @FindBy(name="accountname")
  private WebElement OrgNameEdt;
 
  @FindBy(name="industry")
  private WebElement IndustryDropDown;
 
  @FindBy(xpath="//input[@title='Save [Alt+S]']")
  private WebElement SaveBtn;
  
  //Initializtion
  
   public CreateOrganizationPage(WebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }

   //Utilization
  public WebElement getOrgNameEdt() {
	return OrgNameEdt;
  }

  public WebElement getIndustryDropDown() {
	return IndustryDropDown;
  }

  public WebElement getSaveBtn() {
	return SaveBtn;
 }
  
 //Business logic
  /**
   * This method will create organisation with mandatory fields
   * @author Vardhini
   * @param ORGNAME
   */
  public void createNewOrganization(String ORGNAME)
  {
	  OrgNameEdt.sendKeys(ORGNAME); 
	  SaveBtn.click();
  }
  /**
   * This method will create organization with industry dropdown
   * @author Vardhini
   * @param ORGNAME
   * @param INDUSTRY
   */
  public void createNewOrganization(String ORGNAME,String Industry)
  {
	  OrgNameEdt.sendKeys(ORGNAME); 
	  handleDropdown(IndustryDropDown,Industry);
	  SaveBtn.click();
  }  
	  
}	  
	  
	  
 
  
 
   
   
   
   
   
   
   

