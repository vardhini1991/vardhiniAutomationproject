package vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This is an implementation class for IRetryAnalyzer interface of TestNg
 * @author 91986
 *
 */
public class RetryAnalyzerImplementation implements IRetryAnalyzer
{
	int count=0;
	int retrycount=4;
	public boolean retry(ITestResult result) 
	{
		
		while(count<retrycount)
		{
			count++;
			return true;
		}
		return false;
	}
  
}
