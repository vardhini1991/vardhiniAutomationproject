package Vtiger_practice;
import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class TC05_contcats_orglookup 
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
		  	
		 //4.create contact
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("priya"+value);
			driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		//5.select organisation from lookup
			driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
			String parentid=driver.getWindowHandle();
			Set<String>childid=driver.getWindowHandles();
			//switching driver focus to childid
			for(String all:childid)
			{
				if(!all.equals(parentid))
						{
					     driver.switchTo().window(all);
						}
			}
			driver.findElement(By.xpath("//a[text()='WIPRO']")).click();
	    //6.save//switching driver focus to parentid
			for(String all:childid)
			{
				if(!all.equals(parentid))
						{
					     driver.switchTo().window(parentid);
						}
			}
			driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
			
			//String Name=driver.findElement(By.xpath("(//input[@type='text'])[4]")).getText();
		//7.verify
			String contactheader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			System.out.println(contactheader);
			if(contactheader.contains("priya"))
			{
				System.out.println(contactheader+"account verified");
			}
			else
				System.out.println("not verified");
	    //8.signout operation
			WebElement element2=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act=new Actions(driver);
			act.moveToElement(element2).perform();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			System.out.println("signout successfully");
	    //9.close browser
			driver.quit();
			
	}
	
}
