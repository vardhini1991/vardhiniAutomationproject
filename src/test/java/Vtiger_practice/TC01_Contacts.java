package Vtiger_practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC01_Contacts {

	public static void main(String[] args) throws Throwable 
	{
		Random r=new Random();
		int value=r.nextInt(100000);
	 //1.launching browser
		WebDriver driver=new ChromeDriver();
	 //2.search url	
		driver.get("http://localhost:8888");
		/*driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     //3.login operation
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
	  	
	 //4.create contact
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		WebElement element=driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		element.sendKeys("priya35"+value);
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		
    //5.save
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	//6.verify	
		
		String contactheader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(contactheader);
		if(contactheader.contains("priya"))
		{
			System.out.println(contactheader+"account verified");
		}
		else
			System.out.println("not verified");
		
    /*//6.signout operation
		driver.findElement(By.xpath("(//img[@border='0'])[3]")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();	*/
		
	//7.signout operation
		WebElement element1=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(element1).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("signout successfully");
		
    //8.close browser
		driver.quit();
		
}
}