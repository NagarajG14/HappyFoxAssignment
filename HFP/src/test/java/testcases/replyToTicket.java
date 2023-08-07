package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.TicketsPage;

public class replyToTicket extends BaseClass {
	private LoginPage loginpage;
	private HomePage homepage;
	private TicketsPage ticketspage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod()
	public void tearDown() {
		getDriver().quit();
	}

	@Test
	public void reply() throws Exception {
		loginpage = new LoginPage();
		loginpage.enterUsername();
		loginpage.enterPassword();
		homepage = loginpage.clickOnloginBtn();
		homepage.validateHomePage();

		ticketspage = homepage.clickOnAllTicket();
		ticketspage.replyTicket();
		ticketspage.deleteTicket();
		// homepage.createNewStatus();
		// homepage.createNewPriority();
	}

}
