package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import base.BaseClass;

public class NewTicketPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//h6[@class='hf-new-ticket-header']")
	WebElement pageHeader;

	@FindBy(xpath = "//input[@id='id_subject']")
	WebElement subjectText;

	@FindBy(xpath = "//div[@id='cke_1_contents']/div[1]")
	WebElement descriptionText;

	@FindBy(xpath = "//div[@id='attach-file-drop-area']/input")
	WebElement uploadimage;

	@FindBy(xpath = "//input[@id='id_name']")
	WebElement nameField;

	@FindBy(xpath = "//input[@id='id_email']")
	WebElement emailField;

	@FindBy(xpath = "//input[@id='id_phone']")
	WebElement phoneField;

	@FindBy(xpath = "//button[@id='submit']")
	WebElement sumitForm;

	@FindBy(xpath = "//div[@class='hf-custom-message-container']/div")
	WebElement verifyticket;

	public NewTicketPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void createTicket() throws Exception {
		action.implicitWait(getDriver(), 15);
		action.type(subjectText, "HappyFox");
		action.implicitWait(getDriver(), 10);
		action.moveToElement(getDriver(), descriptionText);
		action.type(descriptionText, "Description for the new ticket");
		action.implicitWait(getDriver(), 5);
		action.selectBySendkeys("C:\\Automation\\HFP\\imagefolder\\image1.png", uploadimage);
		action.type(nameField, "Nagaraj");
		action.type(emailField, "happy@gmail.com");
		action.type(phoneField, "9876543210");
		action.click(getDriver(), sumitForm);

	}

	public String validateTicket() throws Exception {
		Thread.sleep(6000);
		return verifyticket.getText();
	}
}
