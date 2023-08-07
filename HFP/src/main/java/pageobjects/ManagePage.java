package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import base.BaseClass;

public class ManagePage extends BaseClass{

Action action= new Action();

	@FindBy(xpath="//a[contains(text(),'Statuses')]")
	WebElement status;
	
	@FindBy(xpath="//div[@class='lt-body-wrap can-select ember-view']/child::div/child::div[2]/div/table/tbody/tr/td/div/div[@title='IssuecreatedN']")
	WebElement createdStatus;
	
	@FindBy(xpath="//aside[@class='hf-u-slide-in   ']/child::header/child::a[@data-test-id='status-delete-trigger']")
	WebElement deletelinkforstatus;
	
	@FindBy(xpath="//div[@class='hf-confirmation-dialog_body_dependant']/child::section/child::div/div/child::div/child::div/span[1]")
	WebElement dropdownforstatus;
	
	@FindBy(xpath="//div[@class='hf-confirmation-dialog_body_dependant']/child::section/child::div/div/child::div/child::div/span[1]/parent::div/parent::div/child::div[2]/child::div/child::ul/child::li[@data-option-index='1']")
	WebElement selectFromDropDownforstatus;
	
	
	@FindBy(xpath="//a[contains(text(),'Priorities')]")
	WebElement priority;
	
	@FindBy(xpath="//div[@class='lt-body-wrap can-select ember-view']/child::div/child::div[2]/div/table/tbody/tr/td[2]/span[@title='AssistancerequiredN']")
	WebElement createdPriority;
	               
	@FindBy(xpath="//header[@class='hf-entity-header']/child::a[@data-test-id='priority-delete-trigger']")
	WebElement deletelinkforpriority;
	
	@FindBy(xpath="//div[@class='hf-form-field_value hf-mod-dropdown ember-view']/div/div/div/span[@class='ember-power-select-placeholder']")
	WebElement dropdownforpriority;
	
	@FindBy(xpath="//div[@class='hf-form-field_value hf-mod-dropdown ember-view']/div/div/div/span/parent::div/parent::div/div[2]/div/ul/li[@data-option-index='0']")
	WebElement selectfromdropdownforpriority;
	
	@FindBy(xpath="//button[@class='hf-primary-action hf-mod-delete hf-js-confirmation-button ember-view']")
	WebElement deleteButton;
	
	public ManagePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void deleteStatus() throws Exception
	{
		Thread.sleep(2000);
		action.click(getDriver(), status);
		action.click(getDriver(), createdStatus);
		Thread.sleep(2000);
		action.click(getDriver(), deletelinkforstatus);
		action.implicitWait(getDriver(), 10);
		action.click(getDriver(), dropdownforstatus);
		action.implicitWait(getDriver(), 10);
		action.click(getDriver(), selectFromDropDownforstatus);
		action.click(getDriver(), deleteButton);
		Thread.sleep(2000);
	}
	
	public void deletePriority() throws Exception
	{
		Thread.sleep(2000);
		action.click(getDriver(), priority);
		action.click(getDriver(), createdPriority);
		Thread.sleep(2000);
		action.click(getDriver(), deletelinkforpriority);
		action.implicitWait(getDriver(), 10);
		action.click(getDriver(), dropdownforpriority);
		action.implicitWait(getDriver(), 10);
		action.click(getDriver(), selectfromdropdownforpriority);
		action.click(getDriver(), deleteButton);
		Thread.sleep(2000);
	}
	
	public void deleteStatusB() throws Exception
	{
		Thread.sleep(2000);
		action.click(getDriver(), status);
		action.click(getDriver(), createdStatus);
		Thread.sleep(2000);
		action.click(getDriver(), deletelinkforstatus);
		action.implicitWait(getDriver(), 10);
		action.click(getDriver(), deleteButton);
	}
	public void deletePriorityB() throws Exception
	{
		Thread.sleep(2000);
		action.click(getDriver(), priority);
		action.click(getDriver(), createdPriority);
		Thread.sleep(2000);
		action.click(getDriver(), deletelinkforpriority);
		action.implicitWait(getDriver(), 10);
		action.click(getDriver(), deleteButton);
	}
	
}
