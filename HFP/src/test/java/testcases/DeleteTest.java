package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import junit.framework.Assert;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.ManagePage;

public class DeleteTest extends BaseClass {

	private LoginPage loginpage;
	private HomePage homepage;
	private ManagePage managepage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod()
	public void tearDown() {
		getDriver().quit();
	}

	@Test(priority = 0)
	public void DeleteStatus() throws Exception {
		loginpage = new LoginPage();
		loginpage.enterUsername();
		loginpage.enterPassword();
		homepage = loginpage.clickOnloginBtn();
		boolean hm = homepage.validateHomePage();
		Assert.assertTrue(hm);
		homepage.clickonmenu();
		managepage = homepage.gotomanagepage();
		managepage.deleteStatus();
	}

	@Test(priority = 1)
	public void DeletePriority() throws Exception {
		loginpage = new LoginPage();
		loginpage.enterUsername();
		loginpage.enterPassword();
		homepage = loginpage.clickOnloginBtn();
		boolean hm = homepage.validateHomePage();
		Assert.assertTrue(hm);
		homepage.clickonmenu();
		managepage = homepage.gotomanagepage();
		managepage.deletePriority();
	}
}
