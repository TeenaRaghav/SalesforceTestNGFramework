package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class ContactsPage extends BasePage{

	public ContactsPage(WebDriver driver) {
		super(driver);
		}
//	testcase 26
	
	@FindBy(xpath ="//a[contains(text(),'Contacts')]")
	WebElement contactsTab;

	@FindBy(xpath="//input[@value=' New ']")
	WebElement newBtn;

	@FindBy(xpath="//input[@id='name_lastcon2']")
	WebElement lastnameTextbox;
	
	@FindBy(id="con4_lkwgt")
	WebElement lookUpIcon;
	
	@FindBy(xpath="//frame[@id=\"resultsFrame\"]")
	WebElement lookUpIconFrame;

	@FindBy(xpath="//a[contains(text(),'Global Media')]")
	WebElement accountname;
	
	@FindBy(xpath="(//input[@value=\" Save \"])[1]")
	WebElement savebtn;
	
//	testcase26
	public void contactsTab() {
		contactsTab.click();
	}
	
	public void clickOnNewBtn() {
		newBtn.click();
	}

	public void enterLastName(String value) {
		waitForElement(lastnameTextbox);
		lastnameTextbox.sendKeys(value);
	}
	
	public void clickOnLookUpIcon() {
		lookUpIcon.click();
	}
	public void switchToWindowAndSelectAccountName() {
		String parentWindow =getParentWindow();
		switchToChildWindow();
		switchFrame(lookUpIconFrame);
		accountname.click();
		switchToParentWindow(parentWindow);
	}
	public void clickOnSaveBtn() {
		savebtn.click();
	}



}
