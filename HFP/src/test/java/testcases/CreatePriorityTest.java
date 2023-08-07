package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class CreatePriorityTest extends BaseClass {
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

	@Test
	public void createPriority() throws Exception {
		loginpage = new LoginPage();
		loginpage.enterUsername();
		loginpage.enterPassword();
		homepage = loginpage.clickOnloginBtn();
		homepage.validateHomePage();
		homepage.clickonmenu();
		homepage.createNewPriority();
		// homepage.createNewStatus();
		// homepage.createNewPriority();
	}


}
