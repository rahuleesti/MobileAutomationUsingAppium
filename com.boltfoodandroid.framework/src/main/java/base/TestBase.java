package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class TestBase {
	
	public static AndroidDriver<AndroidElement> driver;
	public static AppiumDriverLocalService service;
	
	public AppiumDriverLocalService  startServer()
	{
		//
		boolean flag = checkIfServerIsRunnning(4723);
		if(!flag)
		{
			

		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
			
		}
		return service;
	}
	
public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} 
		return isServerRunning;
	}

//D:\eclipse-java-oxygen-3a-win32-x86_64\AppiumFrameworkPO\src\main\java\resources\startEmulator.bat	

public static void startEmulator() throws IOException
{
	Runtime.getRuntime().exec(System.getProperty("user.dir") + "src\\main\\java\\resources\\startEmulator.bat");
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	public static AndroidDriver<AndroidElement> capabilities() throws IOException, MalformedURLException {
		
		
		System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\Utilities\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		//prop.get(appname);
		
		//D:\eclipse-java-oxygen-3a-win32-x86_64\com.boltfoodandroid.framework\src\main\java\Utilities\    //umcomment this if apk is available
		//C:\Users\rahul\AppData\Local\Android\Sdk\tools\bin
		
		//File appDir = new File("src");

		//File app = new File(appDir, (String) prop.get(appname));
		
		DesiredCapabilities cap = new DesiredCapabilities();

		
		String device = (String) prop.get("device");
		if(device.contains("emulator"))
		{
			startEmulator();
		}
		
		//if(prop.get("device").)
		//start emulator or device on the fly - goto path of emulator in cmd then ->emulator -avd	emulator -5554
		//create bat file to execute the command

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		

		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");// new step
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10);
		cap.setCapability("unicodeKeyboard",false);
		cap.setCapability("resetKeyboard",false);

		//cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());   //uncomment if apk file is availabled
		cap.setCapability("appPackage", "com.bolt.deliveryclient");
		cap.setCapability("appActivity", "com.boltdeliveryclientapp.MainActivity");
		//cap.setCapability("autoGrantPermissions", "true");
		//enableAndDisableLocation(driver);

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		// AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new
		// URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		return driver;

	}
	
	public static void getScreenShot(String s) throws IOException
	{
		File srcfile  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  //convert/send this file into local machine folder and cast driver into take screenshot method
		
		FileUtils.copyFile(srcfile, new File("D:\\eclipse-java-oxygen-3a-win32-x86_64\\com.boltfoodandroid.framework\\test-output\\"+s+".png"));
		//it will create file with same name all the time
	}

}
