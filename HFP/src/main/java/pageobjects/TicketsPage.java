package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import base.BaseClass;

public class TicketsPage extends BaseClass{
	
	Action action= new Action();
	
	@FindBy(xpath="//span[contains(text(),'Reply')]")
	WebElement replyBtn;
	
	@FindBy(xpath="//div[@class= 'hf-floating-editor_toolbar-item ember-view']/div/div/span[2]")
	WebElement clickonCanned;
	
	@FindBy(xpath="//div[@id='cke_546_contents']/child::div[1]")
	WebElement desc;
	
	/*@FindBy(xpath="//div[@class='ember-basic-dropdown-content-wormhole-origin']/div//ul[@class='ember-power-select-options']/li[1]")
	WebElement clickonttext;*/
	
	@FindBy(xpath="//div[@class='hf-floating-editor_toolbar ']/div[1]/child::div[1]/child::div[2]/child::div[3]/child::div[1]/div/div/div[2]/child::div/child::ul/li[@data-option-index='0']")
	WebElement clickontext;
	
	@FindBy(xpath="//div[@class='hf-bulk-selection-item ember-view']/article/div/child::div[2]/child::div[@class='hf-ticket-box_main_middle_top']/div/a[@title='HappyFox']")
	WebElement ticketlink;
	
	@FindBy(xpath="//div[@class='hf-floating-editor_toolbar ']/div[1]/child::div[1]/child::div[2]/child::footer/child::button")
	WebElement useBtn;
	
	@FindBy(xpath="//div[@class='hf-floating-editor_footer']/button[@data-test-id='add-update-reply-button']")
	WebElement replyButton;
	
	@FindBy(xpath="//div[@class= 'hf-floating-editor_min-max-button']")
	WebElement maxi;
	
	@FindBy(xpath="//div[@class='hf-details_more-actions_trigger hf-popover-trigger ember-view']/a[@data-test-id='details-more-actions']")
	WebElement moreoption;
	
	@FindBy(xpath="//div[@data-test-id='delete-ticket-trigger']/span[@class='hf-js-more-actions_delete-ticket']")
	WebElement deleteticket;
	
	@FindBy(xpath="//div[@class='hf-confirmation-dialog hf-js-confirmation-dialog hf-mod-delete']/div/child::div[2]/button[@data-test-id='confirmation-dialog-confirm-button']")
	WebElement confirmdelete;
	
	public TicketsPage()
	{
		PageFactory.initElements(getDriver(), this);
	}

	public void replyTicket() throws Exception
	{
		action.implicitWait(getDriver(), 10);
		action.click(getDriver(), ticketlink);
		action.implicitWait(getDriver(), 10);
		action.click(getDriver(), replyBtn);
		action.implicitWait(getDriver(), 10);
	//	action.click(getDriver(), maxi);
		action.implicitWait(getDriver(), 10);
		action.click(getDriver(), clickonCanned);
		Thread.sleep(2000);
		action.click(getDriver(), clickontext);
		Thread.sleep(2000);
		action.click(getDriver(), useBtn);
		Thread.sleep(2000);
		action.click(getDriver(), replyButton);
		Thread.sleep(5000);

	}
	public void deleteTicket() throws Exception
	{
		Thread.sleep(5000);
		action.click(getDriver(), moreoption);
		Thread.sleep(1000);
		action.click(getDriver(), deleteticket);
		Thread.sleep(1000);
		action.click(getDriver(), confirmdelete);
		Thread.sleep(5000);
	}

}
