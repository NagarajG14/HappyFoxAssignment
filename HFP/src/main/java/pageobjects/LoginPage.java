package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import base.BaseClass;

public class LoginPage extends BaseClass{
	Action action= new Action();
	
	@FindBy(xpath="//input[@id='id_username']")
	WebElement username;

	@FindBy(xpath="//input[@id='id_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='btn-submit']")
	WebElement submit_Btn;

	@FindBy(xpath="//img[@src='/media/img/happyfox-logo.png']")
	WebElement logo;
	
	public LoginPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateLoginpage()
	{
		return action.isDisplayed(getDriver(), logo);
	}
	
	public void enterUsername()
	{
		action.type(username, "Agent");
	}
	
	public void enterPassword()
	{
		action.type(password, "Agent@123");
	}
	public HomePage clickOnloginBtn()
	{
		
		action.click(getDriver(), submit_Btn);
		return new HomePage();
	}
	
	public NewTicketPage loadPage()
	{
		action.launchUrl(getDriver(), "https://interview3.supporthive.com/new/");
		return new NewTicketPage();
	}
	
}
