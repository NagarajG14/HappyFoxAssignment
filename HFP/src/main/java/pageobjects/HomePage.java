package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import base.BaseClass;

public class HomePage extends BaseClass {
	Action action= new Action();
	
	@FindBy(xpath="//span[contains(text(),'New Ticket')]")
	WebElement Dashboard;
	
	@FindBy(xpath="//a[contains(text(),'New')]")
	WebElement newcl;
	
	@FindBy(xpath="//span[@class='hf-top-bar_title_text hf-font-light']")
	WebElement menu;
	
	@FindBy(xpath="//div[contains(text(),'Manage')]")
	WebElement manage;
	
	@FindBy(xpath="//a[contains(text(),'Statuses')]")
	WebElement status;
	
	@FindBy(xpath="//button[@class='hf-mod-create']")
	WebElement addBtn;
	
	@FindBy(xpath="//input[starts-with(@id, 'ember')]")
	WebElement statusName;
	
	@FindBy(xpath="//textarea[starts-with(@id, 'ember')]")
	WebElement descriptionField;
	
	@FindBy(xpath="//button[starts-with(@id, 'ember')]")
	WebElement submitBtn;
	
	@FindBy(xpath="//a[contains(text(),'Priorities')]")
	WebElement priority;
	
	@FindBy(xpath="//button[contains(@class,'hf-mod-create')]")
	WebElement addBtnP;
	
	@FindBy(xpath="//input[starts-with(@id, 'ember')]")
	WebElement priorityName;
	
	
	@FindBy(xpath="//div[@class='hf-bulk-selection-item ember-view']/article/div/child::div[2]/child::div[@class='hf-ticket-box_main_middle_top']/div/a[@title='dasd']")
	WebElement ticketlink;
	
	@FindBy(xpath="//a[contains(text(), 'All Tickets')]")
	WebElement tickets;
	
	
	@FindBy(xpath="//div[@class='lt-body-wrap can-select ember-view']/child::div/child::div[2]/div/table/tbody/tr/td/div/div[@title='IssuecreatedN']/parent::div/parent::td/parent::tr/td[5]/div")
	WebElement makeDefaultForStatus;
	
	@FindBy(xpath="//div[@class='lt-body-wrap can-select ember-view']/child::div/child::div[2]/div/table/tbody/tr/td[2]/span[@title='AssistancerequiredN']/parent::td/parent::tr/td[5]/div")
	WebElement makeDefaultForPriority;

	@FindBy(xpath="//nav[@class='hf-top-bar_navs hf-u-push-right']/div[7]/div/div/div/img[@data-test-id='staff-profile-image']")
	WebElement clickonstafficon;
	
	@FindBy(xpath="//div[@class='ember-view']/child::ul/li[5]/a[@class='hf-staff-menu_item_link hf-mod-staff-menu_item_link_logout']")
	WebElement clickonlogout;
	
	public HomePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateHomePage() throws Exception
	{
		Thread.sleep(35000);
		return action.isDisplayed(getDriver(), Dashboard);
		
	}
	
	public void clickonmenu() throws Exception 
	{
		//action.click(getDriver(), newcl);
		action.moveToElement(getDriver(), menu);
		action.implicitWait(getDriver(), 5);
		action.click(getDriver(), manage);
		
	}
	public void createNewStatus() throws Exception
	{
		Thread.sleep(2000);
		action.click(getDriver(), status);
		action.click(getDriver(), addBtn);
		action.type(statusName, "IssuecreatedN");
		action.type(descriptionField, "Status when a new ticket is created in HappyFox");
		action.click(getDriver(), submitBtn);
	}
	
	public void createNewPriority() throws Exception
	{
		Thread.sleep(3000);
		action.click(getDriver(), priority);
		action.click(getDriver(), addBtnP);
		Thread.sleep(2000);
		action.type(priorityName, "AssistancerequiredN");
		action.type(descriptionField, "Priority of the newly created tickets");
		action.click(getDriver(), submitBtn);
		
	}
	
	public TicketsPage clickOnAllTicket()
	{
		action.implicitWait(getDriver(), 10);
		action.click(getDriver(), tickets);
		return new TicketsPage();
	
	}
	
	public void clickOnDefaultForStatus() throws Exception
	{
		Thread.sleep(5000);
		action.click(getDriver(), status);
		Thread.sleep(6000);
		action.moveToElement(getDriver(), makeDefaultForStatus);
		action.click(getDriver(), makeDefaultForStatus);
		Thread.sleep(2000);
	}
	
	public void clickOnDefaultForPriority() throws Exception
	{
		Thread.sleep(5000);
		action.click(getDriver(), priority);
		Thread.sleep(6000);
		action.moveToElement(getDriver(), makeDefaultForPriority);
		action.click(getDriver(), makeDefaultForPriority);
		Thread.sleep(2000);
	}
	
	
	public ManagePage gotomanagepage()
	{
		action.implicitWait(getDriver(), 10);
		action.click(getDriver(), status);
		return new ManagePage();
		
	}
	
	public void logout() throws Exception
	{
		action.click(getDriver(), clickonstafficon);
		Thread.sleep(2000);
		action.doubleClick(getDriver(), clickonlogout);
		
		
	}
	
	@FindBy(xpath="//div[@class='confirmation']")
	WebElement successfulLogout;
	
	public String validateLogout() throws Exception
	{
		Thread.sleep(10000);
		return successfulLogout.getText();
	}
}
