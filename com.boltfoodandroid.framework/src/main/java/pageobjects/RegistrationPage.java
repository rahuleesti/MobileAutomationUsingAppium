package pageobjects;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegistrationPage {

	private AppiumDriver appiumDriver;
	private Actions actions;
	
	
	public RegistrationPage(AppiumDriver driver) throws IOException, MalformedURLException
	{
		this.appiumDriver = driver;
		actions = new Actions(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Phone number']")  
	public WebElement Phonenumber;    

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Continue']")
	public WebElement Continuebtn; 
	
	@AndroidFindBy(id="screens.Login.agreeToTermsAndConditionsNew")
	public WebElement termandcondlink; 
	
	
	
	
	public boolean btnEnabled ()
	{
		boolean enabled = Continuebtn.isEnabled();
		return enabled;
	}
	
	public boolean btnEnab ()
	{
		boolean enabled = Continuebtn.isEnabled();
		return enabled;
	}
	
	
	
	public void enterText(WebElement ele, String text)
	{ 
		ele.click();
		actions.sendKeys(text).perform();
		
	}
	
	
	
	
	
	
	
	
	
	
}
