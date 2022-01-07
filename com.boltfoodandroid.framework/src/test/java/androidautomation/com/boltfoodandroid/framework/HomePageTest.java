package androidautomation.com.boltfoodandroid.framework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.HomePage;
import reuseables.ReusableFunctions;
import pageobjects.RegistrationPage;

public class HomePageTest extends TestBase
{
	
	@Test
	public void homePage() throws MalformedURLException, IOException
	{
	startServer();
	AndroidDriver<AndroidElement> driver = capabilities(); 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	RegistrationPage reg = new RegistrationPage(driver);
	HomePage homepg = new HomePage(driver);
	ReusableFunctions gest = new ReusableFunctions(driver);
	
	gest.tap(reg.Phonenumber);
	reg.enterText(reg.Phonenumber, "Providephonenumber");  //provide phone number to register on the app
	gest.tap(reg.Continuebtn);
	homepg.permissionmessage.isDisplayed();
	// homepg.whileusingapp.click();
	gest.tap(homepg.whileusingapp);
	homepg.hometabsel.isDisplayed();
	homepg.hometabsel.isSelected();
	
	
	Assert.assertEquals(homepg.hometabsel.isSelected(),true);
	
	tearDown();
	}
	
	 public void tearDown() {
	        driver.quit();
	    }
}
