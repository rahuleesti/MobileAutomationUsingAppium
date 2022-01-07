package androidautomation.com.boltfoodandroid.framework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static java.time.Duration.ofMillis;
import io.appium.java_client.TouchAction;
import base.TestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import pageobjects.CartPage;
import pageobjects.HomePage;
import pageobjects.MenuPage;
import pageobjects.RegistrationPage;
import reuseables.ReusableFunctions;
import reuseables.ReusableFunctions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class NetworkDisabledTest extends TestBase {
	
	@Test
	public void networkDisabledError() throws MalformedURLException, IOException
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
	
		
		driver.openNotifications();
		
		WebElement notificationClear = driver.findElementByXPath("//android.widget.TextView[@text='Clear']");
		
		
		gest.swipeByPoint(200,400,200,1200);
		
		driver.findElementByXPath("//android.view.ViewGroup[@content-desc='Airplane,mode,Off.,Button']").click();
		
		gest.swipeByPoint(200,1200,200,200);
		gest.tap(notificationClear);

		
		String noNetworkText = driver.findElementByXPath("//android.widget.TextView[@text='No internet connection']").getText();
		
		Assert.assertEquals(noNetworkText, "No internet connection");
		
		tearDown();	
	}
	 public void tearDown() {
	        driver.quit();
	    }

}
