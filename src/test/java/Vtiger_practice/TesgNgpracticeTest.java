package Vtiger_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TesgNgpracticeTest 
{

	@Test(invocationCount=2)
	public void createUserTest()
	{
		Assert.fail();
		System.out.println("user created");
	}
	@Test(dependsOnMethods="createUserTest")
	public void modifyUserTest()
	{
		System.out.println("user modified");
	}
	@Test(dependsOnMethods= {"createUserTest","modifyUserTest"})
	public void deleteUserTest()
	{
		System.out.println("user deleted");
	}
	
	
}
