package test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import pojo.Browser;
import pom.SwagLabLoginpage;
import utility.HtmlExtentReport;


public class SwagLabLoginExtendReportTestusingTestNG extends BaseTest {
//	WebDriver driver;
	//ExtentTest test;
	 @BeforeTest
	 public  void ConfigureReporting(){
		reports =  HtmlExtentReport.configureReports();
	 }
	 
	 @BeforeMethod	
		 public void openSwagLab() throws InterruptedException {
		   driver = Browser.launchBrowser("https://www.saucedemo.com");
		((JavascriptExecutor)driver).executeScript("window.scrollBy(100,100)")	;
		   Thread.sleep(3000);	 
	 }
	   
	 @Test(priority=1) 
	 public void loginWithValidUser() throws InterruptedException {
     test = reports.createTest("loginWithValidUser");//ExtentReport method -are nonstatic hence call through object
	 SwagLabLoginpage swaglabloginpage = new SwagLabLoginpage(driver);
	 swaglabloginpage.enterusername("standard_user");
	 swaglabloginpage.enterpassword("secret_sauce");	
	 Thread.sleep(3000);
	 swaglabloginpage.clickonloginbutton();
	 }
	 
	 @Test(priority=2) 
	 public void lockedoutuser()  {
		test = reports.createTest("lockedoutuser");
	   SwagLabLoginpage swaglabloginpage = new SwagLabLoginpage(driver);
	   swaglabloginpage.enterusername("locked_out_user");
	   swaglabloginpage.enterpassword("secret_sauce");	
	   swaglabloginpage.clickonloginbutton();
	 //  Assert.assertTrue(false);
		 
	}

	 @Test(priority=3) 
	 public void performanceglitchuser() {
	 test = reports.createTest("performanceglitchuser");	
	  SwagLabLoginpage swaglabloginpage = new SwagLabLoginpage(driver);
		 swaglabloginpage.enterusername("performance_glitch_user");
		 swaglabloginpage.enterpassword("secret_sauce");	
		 swaglabloginpage.clickonloginbutton();
	}

	@Test(priority=4)  
	 public void problemuser()  {
		test = reports.createTest("problemuser");
	  SwagLabLoginpage swaglabloginpage = new SwagLabLoginpage(driver);
		 swaglabloginpage.enterusername("problem_user");
		 swaglabloginpage.enterpassword("secret_sauce");	
		 swaglabloginpage.clickonloginbutton();
		 Assert.assertTrue(false);
	}

//  @AfterMethod
//	  public void closeBrowser() {
//		  driver.close();
//	  }
	@AfterMethod
	public void addReportStatus(ITestResult result) {
	if(result.getStatus()==ITestResult.SUCCESS)	
	{
	test.log(Status.PASS,result.getName());
	}
	else if(result.getStatus()==ITestResult.FAILURE)
	{
		test.log(Status.FAIL,result.getName());
	}
	else
	{
		test.log(Status.SKIP,result.getName());
	}
	
}
	@AfterTest
	public void publishReport() {
		reports.flush();
	}
}










