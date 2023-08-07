package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import junit.framework.Assert;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class MakeDefaultPriorityTest extends BaseClass {

	private HomePage homepage;
	private LoginPage loginpage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod()
	public void tearDown() {
		getDriver().quit();
	}

	@Test
	public void DefaultForStatus() throws Throwable {
		loginpage = new LoginPage();
		loginpage.enterUsername();
		loginpage.enterPassword();
		homepage = loginpage.clickOnloginBtn();
		boolean hm = homepage.validateHomePage();
		Assert.assertTrue(hm);
		homepage.clickonmenu();
		homepage.clickOnDefaultForPriority();

	}
}
