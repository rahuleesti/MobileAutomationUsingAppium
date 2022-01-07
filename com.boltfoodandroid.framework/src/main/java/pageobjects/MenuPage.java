package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenuPage {
	
	public MenuPage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 
	}
	

	
	
	@AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector()).scrollIntoView(text(\\\"15. Crispy Vegetable Samosa\\")
	public WebElement Dish1;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Add']") 
	public WebElement addbtn;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='16. Vegetable Pakora']") 
	public WebElement Dish2;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='View basket]") 
	public WebElement viewbasketbtn;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='16. Vegetable Pakora. Amount: 1. Price: 4,00 €.  ']") 
	public WebElement abcd;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/") 
	public WebElement productprice;
	
	
}
