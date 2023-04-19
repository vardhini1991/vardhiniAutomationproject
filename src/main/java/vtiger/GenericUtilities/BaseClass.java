package vtiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass 
{
 //step1:Create object of Generic Utilities
     public	PropertyfileUtility pUtil=new PropertyfileUtility();
	 public ExcelUtility eUtil=new ExcelUtility();
	 public JavaUtility jUtil=new JavaUtility();
	 public WebDriverUtility wUtil=new WebDriverUtility();
	 public WebDriver driver=null;
	 public static WebDriver sdriver; //For listeners
 @BeforeSuite(alwaysRun=true)
 public void bsConfig()
 {
	System.out.println("Database connected"); 
 }
 //@Parameters("browser")
@BeforeTest
 //@BeforeClass(alwaysRun=true)
 public void bcConfig(/*String BROWSER*/) throws IOException
 {
	 // String BROWSER=pUtil.readDataFromPropertyFile("browser");
	 String BROWSER=pUtil.readDataFromPropertyFile("browser");
	
	  String URL=pUtil.readDataFromPropertyFile("url");
		 /*launch browser RUNTIME POLYMORPHISM*/
		 if(BROWSER.equalsIgnoreCase("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 System.out.println("<---"+BROWSER+"-->"+" launched successfully");
		 }
		 else if(BROWSER.equalsIgnoreCase("firefox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			 System.out.println("<---"+BROWSER+"-->"+" launched successfully");
		 }
		 else
			 System.out.println("invalid browser name");
	
	 //2.search url	
		 sdriver=driver;
		wUtil.maximizewindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
     
 } 

 @BeforeMethod(alwaysRun=true)
 public void bmConfig() throws IOException
   {
	 String USERNAME=pUtil.readDataFromPropertyFile("username");
     String PASSWORD=pUtil.readDataFromPropertyFile("password");
     LoginPage lp=new LoginPage (driver);
	 lp.loginToApp(USERNAME,PASSWORD);
	 System.out.println("Login to app successfully"); 	
  }
 
 @AfterMethod(alwaysRun=true)
 public void amConfig()
  {
	 HomePage hp=new HomePage(driver);
	 hp.logoutOfApp(driver);
	System.out.println("Logout of app sucessfully"); 
  }
 @AfterTest
 //@AfterClass(alwaysRun=true)
 public void acConfig()
   {
	 driver.quit();
	 System.out.println("Browser closed"); 
   }
 @AfterSuite(alwaysRun=true)
 public void asConfig()
 {
	System.out.println("Database Closed"); 
 }
 
}
