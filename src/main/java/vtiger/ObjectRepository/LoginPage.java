package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
 //Rule1:create a seperate POM class for every webpage
	
 //Rule2:Identify all the webElements using annotations
	@FindBy(name="user_name")
	private WebElement UserNameEdt;
	
	@FindBy(name="user_password")
	private WebElement PasswordEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement SubmitBtn ;
	
 //Rule3:Initialize these webElements using constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
 //Rule4:provide getters to access these elements

	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	//Business Library-Generic methods-project specific
	/**
	 * This method will login to Application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME,String PASSWORD)
	{
		UserNameEdt.sendKeys(USERNAME);
		PasswordEdt.sendKeys(PASSWORD);
		SubmitBtn.click();
	}
}
