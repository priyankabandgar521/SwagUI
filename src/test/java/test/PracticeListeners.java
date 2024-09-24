package test;
import java.io.IOException;

import org.testng.ITestContext;
//import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import utility.HtmlExtentReport;
import utility.ScreenShot;

public class PracticeListeners extends BaseTest implements ITestListener{
    public void onStart(ITestContext result) {
    	reports = HtmlExtentReport.configureReports();
    }
    
    public void onFinish(ITestContext result) {
    	reports.flush();
    }
    
	//WebDriver driver;
	public void onTestStart(ITestResult result) {
	System.out.println("Test Started " + result.getName());	
	}
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getName());
		System.out.println("Test passed " + result.getName());
	}
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,result.getName());
		System.out.println("Test failed " + result.getName());
	}
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,result.getName());
		System.out.println("Test Skipped " + result.getName());
		
		try {
			ScreenShot.takeScreenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}}}

