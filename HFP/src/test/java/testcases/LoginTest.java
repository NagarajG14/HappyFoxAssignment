package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import junit.framework.Assert;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class LoginTest extends BaseClass {

	private LoginPage loginpage;
	private HomePage homepage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod()
	public void tearDown() {
		getDriver().quit();
	}

	@Test(priority = 0)
	public void validatelogin() {
		loginpage = new LoginPage();
		boolean page = loginpage.validateLoginpage();
		Assert.assertTrue("Login page is loaded", page);
	}

	@Test(priority = 1)
	public void loginfirst() throws Exception {
		loginpage = new LoginPage();
		loginpage.enterUsername();
		loginpage.enterPassword();
		homepage = loginpage.clickOnloginBtn();
		boolean hm = homepage.validateHomePage();
		Assert.assertTrue(hm);
		// homepage.createNewStatus();
		// homepage.createNewPriority();
	}
}
