package Vtiger_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertyfile_practice {



	public static void main(String[] args) throws IOException 
	{
		//step1:Load the file in java readable format using FileInputstream
		  FileInputStream fis= new  FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step2:create an object of properties from java.util
		  Properties pObj=new Properties();
		  
		//step3:Load fileInputstream into properties
		   pObj.load(fis);
		   
		//step4:using the keys read the value
		   String BROWSER=  pObj.getProperty("browser");
		   System.out.println(BROWSER);
		   

	}

}
