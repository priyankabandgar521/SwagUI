package test;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.SwagLabLoginpage;

@Listeners (test.PracticeListeners.class)

public class PracticeSwagLabLoginTest extends BaseTest{
//	WebDriver driver;
	
	 @BeforeMethod	
	 public void openSwagLab() throws InterruptedException {
		   driver = Browser.launchBrowser("https://www.saucedemo.com");
		((JavascriptExecutor)driver).executeScript("window.scrollBy(100,100)")	;
		   Thread.sleep(3000);	 
	 }
	   
	 @Test(priority=1) 
	 public void loginWithValidUser() throws InterruptedException {
			
	 SwagLabLoginpage swaglabloginpage = new SwagLabLoginpage(driver);
	 swaglabloginpage.enterusername("standard_user");
	 swaglabloginpage.enterpassword("secret_sauce");	
	 Thread.sleep(3000);
	 swaglabloginpage.clickonloginbutton();
	 }
	 
	@Test(priority=2)
	 public void lockedoutuser()  {
	   SwagLabLoginpage swaglabloginpage = new SwagLabLoginpage(driver);
		 swaglabloginpage.enterusername("locked_out_user");
	    swaglabloginpage.enterpassword("secret_sauce");	
		 swaglabloginpage.clickonloginbutton();
		 Assert.assertTrue(false);
		 
	}

	@Test(priority=3,dependsOnMethods="lockedoutuser")
	 public void performanceglitchuser() {
	  SwagLabLoginpage swaglabloginpage = new SwagLabLoginpage(driver);
		 swaglabloginpage.enterusername("performance_glitch_user");
		 swaglabloginpage.enterpassword("secret_sauce");	
		 swaglabloginpage.clickonloginbutton();
		 }
	
    @Test(priority=4)  
	 public void problemuser()  {
		SwagLabLoginpage swaglabloginpage = new SwagLabLoginpage(driver);
		 swaglabloginpage.enterusername("problem_user");
		 swaglabloginpage.enterpassword("secret_sauce");	
		 swaglabloginpage.clickonloginbutton();
		 }
    
     @AfterMethod
	  public void closeBrowser() {
		  driver.close();
	  }
     }
