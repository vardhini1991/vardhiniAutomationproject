package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

 public class HomePageActual extends WebDriverUtility
 {
 //Declaration
	
	@FindBy(linkText="Organizations")
	private WebElement Organizationlink;
	
	@FindBy(linkText="Contacts")
	private WebElement Contactslink;
	
	@FindBy(linkText="Opportunities")
	private WebElement Opportunitieslink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutlink;
	
	//Initialization
	
	public HomePageActual(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization
	
	public WebElement getOrganizationlink() {
		return Organizationlink;
	}

	public WebElement getContactslink() {
		return Contactslink;
	}

	public WebElement getOpportunitieslink() {
		return Opportunitieslink;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutlink() {
		return SignOutlink;
	}
	
	//Business logic
	/**
	 * This method will click on Organization link
	 * @author Vardhini
	 */
	public void clickOnOrganizationLink()
	{
		Organizationlink.click();
	}
	
	/**
	 * This method will click on contacts link
	 * @author Vardhini
	 */
	public void clickOnContactsLink()
	{
		Contactslink.click();
	}
	
	/**
	 * This method will logout of app
	 * @author Vardhini
	 */
	public void logoutApp(WebDriver driver)
	{ 
		mouseHoverAction(driver, AdministratorImg);
		SignOutlink.click();
	}
 }	

