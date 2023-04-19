package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage
{ //Rule 1: create pom class for every webpage
	
 //Rule 2:Identify all the WebElements with a constructor
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement CreatecontactLookUpImg; 
	
	/*
	 @FindBy(xpath="//img[@title='Search in Contacts...']")
	private WebElement SearchcontactIcon1; 
	
	@FindBy(name="search_text")
	private WebElement SearchFor; 
	
	@FindBy(name="search_field")
	private WebElement SearchIn; 
	
	@FindBy(name="submit")
	private WebElement SearchNowBtn; 
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Calendar.gif']")
	private WebElement CalendarIcon; 
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Clock.gif']")
	private WebElement WorldclockIcon; 
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Calc.gif']")
	private WebElement OpenCalculatorIcon; 
	
	@FindBy(xpath="//img[@src='themes/softed/images/tbarChat.gif']")
	private WebElement chatIcon; 
	
	@FindBy(xpath="//img[@src='themes/softed/images/tbarImport.gif']")
	private WebElement ImportContactsIcon; 

	@FindBy(xpath="//img[@src='themes/softed/images/tbarExport.gif']")
	private WebElement ExportContactsIcon; 
	
	@FindBy(name="viewname")
	private WebElement FilterDdown; 

	@FindBy(xpath="//a[text()='Create Filter']")
	private WebElement CreateFilterLink; */
	
 //Rule 3:Intialize these WebElements with a constructor
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	} 

 //Rule 4:provide getters to access these elements
	
	public WebElement getCreatecontactLookUpImg() 
	{
		return CreatecontactLookUpImg;
	}

	/*public WebElement getSearchcontactIcon1() {
		return SearchcontactIcon1;
	}

	public WebElement getSearchFor() {
		return SearchFor;
	}

	public WebElement getSearchIn() {
		return SearchIn;
	}

	public WebElement getSearchNowBtn() {
		return SearchNowBtn;
	}

	public WebElement getCalendarIcon() {
		return CalendarIcon;
	}

	public WebElement getWorldclockIcon() {
		return WorldclockIcon;
	}

	public WebElement getOpenCalculatorIcon() {
		return OpenCalculatorIcon;
	}

	public WebElement getChatIcon() {
		return chatIcon;
	}

	public WebElement getImportContactsIcon() {
		return ImportContactsIcon;
	}

	public WebElement getExportContactsIcon() {
		return ExportContactsIcon;
	}

	public WebElement getFilterDdown() {
		return FilterDdown;
	}

	public WebElement getCreateFilterLink() {
		return CreateFilterLink;
	} */

//Business logic
	/**
	 * This moethod will click on create contact lookup image
	 * @author Vardhini
	 */
	public void clickOnCreateContactLookUpImg()
	{
		 CreatecontactLookUpImg.click();
	}
}	
	
	
	
	
	
	
	 
	
	 


