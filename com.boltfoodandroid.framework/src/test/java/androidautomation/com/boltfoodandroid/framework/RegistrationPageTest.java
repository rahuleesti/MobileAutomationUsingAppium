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
import pageobjects.RegistrationPage;
import reuseables.ReusableFunctions;


public class RegistrationPageTest extends TestBase{

	
	@Test
	public void userRegistration() throws MalformedURLException, IOException
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
	
	
	Assert.assertEquals(homepg.permissionmessage.isDisplayed(), true);
	
	tearDown();
	}
	 public void tearDown() {
	        driver.quit();
	    }
}
