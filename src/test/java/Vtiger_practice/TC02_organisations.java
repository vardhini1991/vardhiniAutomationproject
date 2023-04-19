package Vtiger_practice;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC02_organisations {

	public static void main(String[] args) throws Throwable 
	{
		Random r=new Random();
		int value=r.nextInt(100000);
	 //1.launching browser
		WebDriver driver=new ChromeDriver();
	 //2.search url	
		driver.get("http://localhost:8888");
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     //3.login operation
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
	  	
	 //4.create organisation
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("WIPRO"+value);
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
	//5.save
		driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
		Thread.sleep(4000);
	//6.verify
		String orgheader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(orgheader);
		if(orgheader.contains("WIPRO"))
		{
			System.out.println(orgheader+"account verified");
		}
		else
			System.out.println("not verified");
		
		
	//7.signout operation
		WebElement element1=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(element1).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("signout successfully");
		
	//7.close browser
		driver.quit();
		
}
}