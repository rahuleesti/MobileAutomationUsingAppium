package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage {
	
	private AppiumDriver appiumDriver;
	private Actions actions;
	
	
	public CartPage(AppiumDriver driver)
	{
		this.appiumDriver = driver;
		actions = new Actions(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 
	}
	
	//for items added displayed in cart
	@AndroidFindBy(xpath="//android.widget.TextView[@text='sample dish1 locator']") //locator of dish1
	public WebElement dishcart;  //compare this with dish added previously
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Add']") 
	public WebElement addbtn;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='sample dish2 locator']")  //locator of the dish 2
	public WebElement Dish2;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='View basket]") 
	public WebElement viewbasketbtn;
	
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/") 
	public WebElement productprice;
	
	
}


