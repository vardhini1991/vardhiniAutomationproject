package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;

/**
 * This class consists of generic methods related to property file
 * @author vardhini
 *
 */
public class PropertyfileUtility 
{
 /**
  * This method will read data from propertyfile
  * @param key
  * @return
  * @throws IOException
  */
  public String readDataFromPropertyFile(String key)throws IOException
  {
	FileInputStream fis=new FileInputStream(IConstantUtility.propertyfilepath);
	Properties pObj=new Properties();
	pObj.load(fis);
	String value=pObj.getProperty(key);
	return value;
  }
}