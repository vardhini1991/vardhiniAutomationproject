package Vtiger_practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice 
{
 @Test
 public void hardAssertTest()
 {
	System.out.println("Test1");
	System.out.println("Test2");
	Assert.assertEquals("A","A");
	
	System.out.println("Test3");
	Assert.assertEquals(false, true);
	System.out.println("Test4");
	
 }
 @Test
 public void softAssertTest()
 { 
	 SoftAssert sa=new SoftAssert();
	 System.out.println("practice-1");
	 
	 sa.assertEquals(false, false);
	 
	 System.out.println("practice-2");
	 sa.assertEquals("a", "b");
	 System.out.println("practice-3");
	 System.out.println("practice-4");
	 
	 sa.assertAll();
		
		
 }
}
