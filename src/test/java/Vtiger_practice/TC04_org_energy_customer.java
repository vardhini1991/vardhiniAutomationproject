package Vtiger_practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC04_org_energy_customer 
{
	public static void main(String[] args) throws Throwable 
	{
		Random r=new Random();
		int value=r.nextInt(100000);
	 //1.launching browser
		WebDriver driver=new ChromeDriver();
	 //2.search url	
		driver.get("http://localhost:8888");
		 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     //3.login operation
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
	  	
	 //4.create organisations
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Tata"+value);
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
	//5.select energy in industry dropdown	
		WebElement element=driver.findElement(By.xpath("//select[@name='industry']"));
		element.click();
		Select s=new Select(element);
		s.selectByValue("Energy");
		
	//6.select customer in Type dropdown	
		WebElement element1=driver.findElement(By.xpath("//select[@name='accounttype']"));
		element1.click();
		Select s1=new Select(element1);
		Thread.sleep(3000);
		s1.selectByValue("Customer");		
		
	//7.save	
		driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();

	//8.verify
		String orgheader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(orgheader);
		if(orgheader.contains("Tata"))
		{
			System.out.println(orgheader+"account verified");
		}
		else
			System.out.println("not verified");
	//9.signout operation
		WebElement element2=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(element2).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("signout successfully");
	//10.closebrowser
		driver.quit();
}
}