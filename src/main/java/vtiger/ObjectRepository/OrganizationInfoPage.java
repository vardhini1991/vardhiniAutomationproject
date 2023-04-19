package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage
{
 //Declaration
	
	 //Rule 2:Identify the WebElements using annotations
		
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement OrganizationHeader;
		
  //Initialization

		public OrganizationInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}

 //	Utilization
		
		public WebElement getOrganizationHeader() 
		{
			return OrganizationHeader;
		}
		
		
		//Business Library-Generic methods-project specific
		 
		public String OrganisationInfo()
		{
			return OrganizationHeader.getText();

		
		}
		
}
