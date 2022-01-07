package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	private AppiumDriver appiumDriver;
	private Actions actions;
	
	public HomePage(AppiumDriver driver)
	{
		this.appiumDriver = driver;
		actions = new Actions(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 
	}
	
	
	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_message")  
	public WebElement permissionmessage; 
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='While using the app']")
	public WebElement whileusingapp; 
	
	//navigation.GlobalTabBar.Search
	//navigation.GlobalTabBar.HomeStack
	
	@AndroidFindBy(xpath= "//android.widget.TextView[@text='Home']")
	public WebElement hometab; 
	
	@AndroidFindBy(xpath= "//android.widget.TextView[@text='Home']/..")
	public WebElement hometabsel; 
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Search']")
	public WebElement searchbtn; 
	
	//android.widget.EditText
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Restaurants or cuisines']")
	public WebElement searchtext;
	
	//android.widget.TextView
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Asian Chef']") 
	public WebElement searchresult; 
	
	//android.widget.TextView
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='No internet connection']")  
	public WebElement nonetworkbanner; 
	//com.android.permissioncontroller:id/permission_message
	
	public void searchText(WebElement ele, String text)
	{
		ele.click();
		actions.sendKeys(text).perform();
	}
	
	
	
	 public void WifiOn() {
		   
		   
		}
		public void WifiOff() {
		    
		} 
	
	

}
