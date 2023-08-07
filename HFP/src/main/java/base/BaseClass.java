package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;




import io.github.bonigarcia.wdm.WebDriverManager;
import utility.CustomListeners;
import utility.Screenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;




public class BaseClass 
{
	public static Properties prop;
	public static ExtentTest test;
	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	//loadConfig method is to load the configuration
	@BeforeSuite
	public void loadConfig() {
		//DOMConfigurator.configure("log4j.xml");

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}
	
	public void launchApp()
	{
		 String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}
		//Maximize the screen
	getDriver().manage().window().maximize();
		//Delete all the cookies
		getDriver().manage().deleteAllCookies();
		//Implicit TimeOuts
		getDriver().manage().timeouts().implicitlyWait
		(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
		//PageLoad TimeOuts
		getDriver().manage().timeouts().pageLoadTimeout
		(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
		//Launching the URL
		getDriver().get(prop.getProperty("url"));
	}
	
	public static void verifyEquals(String expected, String actual) throws IOException {

		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {

			Screenshot.captureScreenshot();
			// ReportNG
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + Screenshot.screenshotName + "><img src=" + Screenshot.screenshotName
					+ " height=400 width=400></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			// Extent Reports
			CustomListeners.testReport.get().log(Status.FAIL, " Verification failed with exception : " + t.getMessage());
			CustomListeners.testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.screenshotName)
					.build());

		}

	}
	
	@AfterSuite
	public void afterSuite() {
		//ExtentManager.endReport();
			if(getDriver()!=null)
			{
				getDriver().quit();
			}
		}

}