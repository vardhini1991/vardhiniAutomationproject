package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{
 //Rule 1:create a seperate POM class for every Webpage
	
 //Rule 2:Identify the WebElements using annotations
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactHeader;
	
 //Rule 3:Initialize these WebElements using constructor
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
 //Rule 4:provide getters to access these elements
	
	public WebElement getContactHeader() 
	{
		return ContactHeader;
	}
	
	
	//Business Library-Generic methods-project specific
	 
	public String contactInfo()
	{
		return ContactHeader.getText();

	
	}
	
}
