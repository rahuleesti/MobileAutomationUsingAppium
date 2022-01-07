package reuseables;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ReusableFunctions {
	
	
	AndroidDriver<AndroidElement>  driver;
	TouchAction t;
	
	public ReusableFunctions(AndroidDriver<AndroidElement> driver)
	{
		this.driver = driver;
		t = new TouchAction(driver);
	}
	public void scrollToText(String text)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))");
		//
	}
	
	public void swipeByPoint(int sourceX, int sourceY, int destX, int destY)
	{
		WaitOptions waitOption = WaitOptions.waitOptions(Duration.ofMillis(1000));
		t.press(PointOption.point(sourceX,sourceY)).waitAction(waitOption)
        .moveTo(PointOption.point(destX,destY))
        .release()
        .perform();
	}
	public void tap(WebElement text)
	{
		
		t.tap(tapOptions().withElement(element(text))).perform();
	}
	
	public void longTap(WebElement text)
	{
		
		
		t.longPress(longPressOptions().withElement(element(text)).withDuration(ofSeconds(2))).release().perform();
	}
	
	public void swipe(WebElement source, WebElement dest)
	{
		t.longPress(longPressOptions().withElement(element(source)).withDuration(ofSeconds(2)))
		.moveTo(element(dest)).release().perform();
	}
	
	public void dragDrop(WebElement source, WebElement dest)
	{
		t.longPress(longPressOptions().withElement(element(source)).withDuration(ofSeconds(2))).moveTo(element(dest)).
		release().perform();
		
	}
	
	public void isClickable()
	{
		int clickableelments = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
		
	}
	
	
}
