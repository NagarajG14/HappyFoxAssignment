package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import junit.framework.Assert;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class logoutTest extends BaseClass{
	private LoginPage loginpage;
	private HomePage homepage;

	@BeforeMethod
	public void setup(){
		launchApp();
	}

	
	@AfterMethod()
	public void tearDown() {
		getDriver().quit();
	}

	
	@Test
	public void logout() throws Exception
	{
		loginpage = new LoginPage();
		loginpage.enterUsername();
		loginpage.enterPassword();
		homepage = loginpage.clickOnloginBtn();
		boolean hm = homepage.validateHomePage();
		Assert.assertTrue(hm);
		homepage.logout();
		String ActualResult = homepage.validateLogout();
		String ExceptResult = "You have logged out successfully";
		verifyEquals(ExceptResult, ActualResult);	
	}
}
