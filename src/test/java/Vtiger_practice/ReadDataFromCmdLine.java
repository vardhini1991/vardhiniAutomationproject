package Vtiger_practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine 
{
  @Test
   public void test()
   {
	  String BROWSER=System.getProperty("browser"); //run time parameters
	  System.out.println(BROWSER);
   }
  
}
