package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.LoginPage;
import pageobjects.NewTicketPage;

public class createNewTicket extends BaseClass {
	private LoginPage loginpage;
	private NewTicketPage newticketpage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod()
	public void tearDown() {
		getDriver().quit();
	}

	@Test
	public void newTicket() throws Exception {
		loginpage = new LoginPage();
		newticketpage = loginpage.loadPage();
		newticketpage.createTicket();
		String actualResult = newticketpage.validateTicket();
		String ExptResult = "Your ticket has been created and you have been emailed instructions to activate your account with which you can track your ticket status";
		verifyEquals(ExptResult, actualResult);
	}
}
