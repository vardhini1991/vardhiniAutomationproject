package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This is an implementation class for ITestListeners interface of TestNg
 * @author Vardhini
 *
 */
public class ListenersImplementation implements ITestListener
{
    ExtentReports report;
    ExtentTest test;
	public void onTestStart(ITestResult result) 
	{
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---TestScript Execution started---");
		
		test=report.createTest(methodname);
		test.log(Status.INFO,methodname+"---TestScript Execution started---");//execution started -one test script for extent reports
	}

	public void onTestSuccess(ITestResult result) 
	{
		String methodname = result.getMethod().getMethodName();
	   System.out.println(methodname+"---TestScript passed---");
	   
	   test.log(Status.PASS,methodname+"---TestScript passed---");
	   
	}

	public void onTestFailure(ITestResult result) 
	{
		String methodname = result.getMethod().getMethodName();
		//System.out.println(methodname+"---TestScript Failed---");
		//System.out.println(result.getThrowable());  //prints Exception
		
		test.log(Status.FAIL,methodname+"---TestScript Failed---");
		test.log(Status.INFO,result.getThrowable());
		
		WebDriverUtility wUtil=new WebDriverUtility ();
		String screenshotname=methodname+new JavaUtility().getSystemDateInFormat();
		try {
			String path=wUtil.takesScreenShot(BaseClass.sdriver, screenshotname);
			test.addScreenCaptureFromPath(path); //go to the screenshot location and it will attached to the report
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) 
	{
		String methodname = result.getMethod().getMethodName();
		//System.out.println(result.getThrowable());
		//System.out.println(methodname+"---TestScript skipped---");
		
		 
	  test.log(Status.SKIP,methodname+"---TestScript skipped---");
	  test.log(Status.INFO,methodname+result.getThrowable());
		
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
	
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	public void onStart(ITestContext context) 
	{
		System.out.println("---Execution started---");
		
		//ExtentReport configuration
		ExtentSparkReporter htmlreporter=new ExtentSparkReporter(".\\ExtentReports\\Reports-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlreporter.config().setDocumentTitle("vtiger Execution report");
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setReportName("Automation Execution Report");
		
		report=new ExtentReports();
		report.attachReporter(htmlreporter);
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base BROWSER", "FireFox");
		report.setSystemInfo("Reporter Name", "Vardhini");
		report.setSystemInfo("Base Platform", "Windows");
		
	}

	public void onFinish(ITestContext context) 
	{
		System.out.println("---Execution finished---");
		report.flush();  //generate reports
	}

}
