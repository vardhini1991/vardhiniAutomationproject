package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{ //Rule 1:create pom class for every webpage
	
  //Rule 2 :Identify all the web elements using annotations
	
	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement HomePageIcon ;
	
	@FindBy(xpath="//a[text()='Calendar']")
	private WebElement CalendarModule;
	
	@FindBy(xpath="//a[@href='index.php?module=Leads&action=index']")
	private WebElement LeadsModule;
	
	@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
	private WebElement OrganizationsModule1;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsModule;
	
	@FindBy(xpath="//a[@href='index.php?module=Potentials&action=index']")
	private WebElement OpportunitiesModule;
	
	@FindBy(xpath="//a[@href='index.php?module=Products&action=index']")
	private WebElement ProductsModule;
	

	@FindBy(xpath="//a[@href='index.php?module=Documents&action=index']")
	private WebElement DocumentsModule;
	
	@FindBy(xpath="//a[@href='index.php?module=Emails&action=index']")
	private WebElement EmailModule;
	
	@FindBy(xpath="//a[@href='index.php?module=HelpDesk&action=index']")
	private WebElement TroubleTicketsModule;
	
	@FindBy(xpath="//a[@href='index.php?module=Dashboard&action=index']")
	private WebElement DashBoardModule;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement SignOutIcon;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOut;
	

	@FindBy(xpath="//img[@src='themes/softed/images/info.PNG']")
	private WebElement InfoIcon;
	
	@FindBy(xpath="//img[@src='themes/softed/images/mainSettings.PNG']")
	private WebElement SettingsIcon;
	
	@FindBy(name="query_string")
	private WebElement SearchEdt;
	
	@FindBy(xpath="//img[@src='themes/images/arrow_down_black.png']")
	private WebElement SearchDd;
	
	@FindBy(className="searchBtn")
	private WebElement SearchBtn;   
	
   //Rule 3:Initialize these WebElements with a constructor
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Rule 4:provide getters to access these elements
	
	public WebElement getHomePageIcon() {
		return HomePageIcon;
	}

	public WebElement getCalendarModule() {
		return CalendarModule;
	}

	public WebElement getLeadsModule() {
		return LeadsModule;
	}

	public WebElement getOrganizationsModule1() {
		return OrganizationsModule1;
	}

	public WebElement getContactsModule() {
		return ContactsModule;
	}

	public WebElement getOpportunitiesModule() {
		return OpportunitiesModule;
	}

	public WebElement getProductsModule() {
		return ProductsModule;
	}

	public WebElement getDocumentsModule() {
		return DocumentsModule;
	}

	public WebElement getEmailModule() {
		return EmailModule;
	}

	public WebElement getTroubleTicketsModule() {
		return TroubleTicketsModule;
	}

	public WebElement getDashBoardModule() {
		return DashBoardModule;
	}

	public WebElement getSignOutIcon() {
		return SignOutIcon;
	}

	public WebElement getSignOut() {
		return SignOut;
	}

	public WebElement getInfoIcon() {
		return InfoIcon;
	}

	public WebElement getSettingsIcon() {
		return SettingsIcon;
	}

	public WebElement getSearchEdt() {
		return SearchEdt;
	}

	public WebElement getSearchDd() {
		return SearchDd;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public void clickOnOrganizationLink() {
		// TODO Auto-generated method stub
		
	}

	public void logoutOfApp(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
