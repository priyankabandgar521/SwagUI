package test;

import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabLoginpage;
public class SwagLabAddToCartTest {
	WebDriver driver;

	
	@BeforeMethod
	public  void Openbrowser() {
     driver = Browser.launchBrowser("https://www.saucedemo.com");
	}	
	@Test
	public void swaglablogin() {
		 driver = Browser.launchBrowser("https://www.saucedemo.com");
		SwagLabLoginpage swaglabloginpage = new SwagLabLoginpage(driver);
		 swaglabloginpage.enterusername("standard_user");
		 swaglabloginpage.enterpassword("secret_sauce");	
		 swaglabloginpage.clickonloginbutton();
	}
	@Test
	public void Addtocart() {
//	WebElement AddToCart = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));		
//	AddToCart.click();
		 driver = Browser.launchBrowser("https://www.saucedemo.com");
		SwagLabLoginpage swaglabloginpage = new SwagLabLoginpage(driver);
		 swaglabloginpage.enterusername("standard_user");
		 swaglabloginpage.enterpassword("secret_sauce");	
		 swaglabloginpage.clickonloginbutton();
		 swaglabloginpage.clickonaddtocartbutton();
	}
//	@AfterMethod
//	public void CloseBrowser() {
//		driver.close();
//	}
//		
}


