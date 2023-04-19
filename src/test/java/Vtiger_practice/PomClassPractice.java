package Vtiger_practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePageActual;
import vtiger.ObjectRepository.LoginPage;

public class PomClassPractice {

	public static void main(String[] args) 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		LoginPage lp=new LoginPage(driver);
		//lp.getUserNameEdt().sendKeys("admin");
		//lp.getPasswordEdt().sendKeys("manager");
		//lp.getSubmitBtn().click();
		
		lp.loginToApp("admin","admin");//code optimization
		
		HomePageActual hp=new HomePageActual(driver);
		hp.logoutApp(driver);
		
	}

}
