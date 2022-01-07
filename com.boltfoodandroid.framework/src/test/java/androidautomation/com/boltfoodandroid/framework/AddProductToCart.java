package androidautomation.com.boltfoodandroid.framework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.CartPage;
import pageobjects.HomePage;
import pageobjects.MenuPage;
import pageobjects.RegistrationPage;
import reuseables.ReusableFunctions;

public class AddProductToCart extends TestBase {
	
	@Test
	public void addToCartTest() throws MalformedURLException, IOException
	{
		startServer();
		AndroidDriver<AndroidElement> driver = capabilities(); //make app name globalized
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		RegistrationPage reg = new RegistrationPage(driver);
		HomePage homepg = new HomePage(driver);
		MenuPage menupg = new MenuPage(driver);
		CartPage cartpg = new CartPage(driver);
		ReusableFunctions gest = new ReusableFunctions(driver);
		
		
	
		gest.tap(reg.Phonenumber);
		reg.enterText(reg.Phonenumber, "Providephonenumber");  //provide phone number to register on the app
		gest.tap(reg.Continuebtn);
		homepg.permissionmessage.isDisplayed();
		gest.tap(homepg.whileusingapp);
		homepg.hometabsel.isDisplayed();
	
		gest.tap(homepg.searchbtn);
		
		homepg.searchText(homepg.searchtext,"Asianchef");
		
		gest.tap(homepg.searchresult);
		
		menupg.Dish1.click();
		
		String dish1name = menupg.Dish1.getText();
		
        gest.tap(menupg.addbtn);
		
		
		gest.tap(menupg.viewbasketbtn);
		
		String cartdishname = cartpg.dishcart.getText();	
		
		Assert.assertEquals(dish1name,cartdishname );
			
		tearDown();
	}
	 public void tearDown() {
	        driver.quit();
	    }

}
