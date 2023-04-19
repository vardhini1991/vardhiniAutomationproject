package Vtiger_practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice 
{
@Test(dataProvider="getData")
  public void addToCart(String name,int price,int qty,String color,boolean isAvailable)
  {
	System.out.println("---"+name+"--"+price+"--"+qty+"--"+color+"--"+isAvailable);
  }

@DataProvider
 public Object[][] getData()
 {
	Object[][] data=new Object[2][5];
	data[0][0]	= "SAMSUNG";
	data[0][1]	= 12000;
	data[0][2]	= 12;
	data[0][3]	= "Black";
	data[0][4]	= true;
	
	data[1][0]	= "IPhone";
	data[1][1]	= 120000;
	data[1][2]	= 5;
	data[1][3]	= "white";
	data[1][4]	= false;
	
	return data;
  }
}
