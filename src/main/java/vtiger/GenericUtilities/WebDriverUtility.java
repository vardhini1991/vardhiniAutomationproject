package vtiger.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class consists of generic methods related to webdriver actions 
 * @author vardhini
 *
 */
public class WebDriverUtility 
{
  /**
   * 1.This method will maximize window
   * @param driver
   */
	public void maximizewindow(WebDriver driver)
     {
	  driver.manage().window().maximize(); 
     }
	/**
	 *2.This method will minimize window
	 * @param driver
	 */
    public void minimizewindow(WebDriver driver)
    {
	 driver.manage().window().minimize(); 
    }
    /**
     * 3.This method will wait until a page is loaded
     * @param driver
     */
    public void waitForPageLoad(WebDriver driver)
    {
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    /**
     * 4.This method will wait until a particular webElement is visible
     * @param driver
     * @param element
     */
    public void waitForElementToBeVisible(WebDriver driver,WebElement element)
    {
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	 wait.until(ExpectedConditions.visibilityOf(element));
    }
    /**
     * 5.This method will wait until a particular WebElement is clickable
     * @param driver
     * @param element
     */
    public void waitForElementToBeClickable(WebDriver driver,WebElement element)
    {
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	 wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    /**
     *6.1.This method will handle Dropdown by index
     * @param element
     * @param index
     */
    public void handleDropdown(WebElement element,int index)
    {
    	Select s=new Select(element);
    	s.selectByIndex(index);
    }
    /**
     * 6.2.This method will handle Dropdown by value
     * @param element
     * @param value
     */
    public void handleDropdown(WebElement element,String value)
    {
    	Select s=new Select(element);
    	s.selectByValue(value);
    }
    /**
     * 6.3.This method will handle Dropdown by visibletext
     * @param Text
     * @param element
     */
    public void handleDropdown(String Text,WebElement element)
    {
    	Select s=new Select(element);
    	s.selectByVisibleText(Text);
    }
    /**
     * 7.1.This method will perform mouse Hover action on a web element
     * @param driver
     * @param element
     */
    public void mouseHoverAction(WebDriver driver,WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.moveToElement(element).perform();
    	
    }
    /**
     * 7.2.This method will perform right click anywhere on the page
     * @param driver
     */
    public void rightClickAction(WebDriver driver)
    {
    	Actions act=new Actions(driver);
    	act.contextClick().perform();
    	
    }
    /**
     * 7.3.This method will perform right click on particular web element
     * @param driver
     * @param element
     */
    public void rightClickAction(WebDriver driver,WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.contextClick(element).perform();
    }
    /**
     * 7.4.This method will perform double click anywhere on the page
     * @param driver
     */
    public void doubleClickAction(WebDriver driver)
    {
    	Actions act=new Actions(driver);
    	act.doubleClick().perform();
    }
    /**
     * 7.5.This method will perform double click on particular web element
     * @param driver
     * @param element
     */
    public void doubleClickAction(WebDriver driver,WebElement element)
      {
    	Actions act=new Actions(driver);
    	act.doubleClick(element).perform();
      }
    /**
     * 7.6.This method will perform drag and drop from one element to another
     * @param driver
     * @param src
     * @param target
     */
   public void dragAndDropAction(WebDriver driver,WebElement src,WebElement target)
    {
	   Actions act=new Actions(driver);
	   act.dragAndDrop(src, target).perform();
    }
   /**
    * 8.1.This method will presss Enter key
    * @throws AWTException
    */
   public void  pressEnterKey() throws AWTException
    {
	   Robot r=new Robot();
	   r.keyPress(KeyEvent.VK_ENTER);
    }
   /**
    * 8.2.This method will Release Enter key
    * @throws AWTException
    */
   public void  releaseEnterKey() throws AWTException
   {
	   Robot r=new Robot();
	   r.keyRelease(KeyEvent.VK_ENTER);
   }
   /**
    * 9.1.This method will handle frame with index
    * @param driver
    * @param index
    */
   public void handleFrame(WebDriver driver,int index)
   {
	   driver.switchTo().frame(index);
   }
   /**
    * 9.2.This method will handle frame with nameOrId
    * @param driver
    * @param nameOrId
    */
   public void handleFrame(WebDriver driver,String nameOrId)
   {
	   driver.switchTo().frame(nameOrId);
   }
   /**
    * 9.3.This method will handle frame with Web element
    * @param driver
    * @param element
    */
   public void handleFrame(WebDriver driver,WebElement element)
   {
	   driver.switchTo().frame(element);
   }
   /**
    * 9.4.This method will switch to immidiate parent frame
    * @param driver
    */
   public void handleParentFrame(WebDriver driver)
   {
	 driver.switchTo().parentFrame();  
   }
   /**
    *9.5.This method will switch to default frame 
    * @param driver
    */
   public void handleDefaultFrame(WebDriver driver)
   {
	 driver.switchTo().defaultContent();  
   }
   /**
    * 10.1.This method will accept alert pop up
    * @param driver
    */
   public void acceptAlert(WebDriver driver)
   {
	  driver.switchTo().alert().accept();
   }
   /**
    *  10.2.This method will dismiss alert pop up
    * @param driver
    */
   public void dismissAlert(WebDriver driver)
   {
	  driver.switchTo().alert().dismiss();
   }
   /**
    * 10.3.This method will capture and return the alert text
    * @param driver
    * @return
    */
   public String getAlertText(WebDriver driver)
   {
	 return driver.switchTo().alert().getText();
   }
   
   /**
    * 11.This method will take screenshot and save it in screenshots folder
    * @param driver
    * @param Screenshot
    * @return
    * @throws IOException
    */
   public String takesScreenShot(WebDriver driver,String Screenshot) throws IOException
   {
	   TakesScreenshot ts=(TakesScreenshot) driver;
	  File src= ts.getScreenshotAs(OutputType.FILE);
	  File dest=new File(".\\Screenshots\\"+Screenshot+".png");
	  FileUtils.copyFile(src, dest); //commons io dependency
	  return dest.getAbsolutePath(); //used in extent reports
   }
   
   /**
    * 12.This method will switch to window based on partial window title
    * @param driver
    * @param partialWinTitle
    */
   public void switchToWindow(WebDriver driver,String partialWinTitle)
   {
	   //step1:Capture all the window ids
	     Set<String>winIds=driver.getWindowHandles();
	   
	   //step2:Use for each loop and navigate to each window
	     for(String win:winIds)
	     {
	    	//step3:capture the title of each window 
	    	  String currentTitle=driver.switchTo().window(win).getTitle(); 
	    	//step4:compare the current title with partial windoe title
	    	  if(currentTitle.contains(partialWinTitle))
	    	  {
	    		  break;
	    	  }
	     }	     
   }
   
   /**
    * 13.1.This method will scroll randomly downwards
    * @param driver
    */
   public void scrollAction(WebDriver driver)
   {
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,500)", "");   
	}
   
   /**
    * 13.2.This method will scroll down until the particular web element
    * @param driver
    * @param element
    */
   public void scrollAction(WebDriver driver,WebElement element)
   {
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   int y=element.getLocation().getY();
	   js.executeScript("window.scrollBy(0,"+y+")",element);   
	}
   
 }   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

