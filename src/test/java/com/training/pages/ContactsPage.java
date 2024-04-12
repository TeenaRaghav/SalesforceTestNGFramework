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
	
	@FindBy(xpath="(//input[@name='save'])[1]")
	WebElement savebtn;
	
//	TestCase 27
	@FindBy(xpath="//a[contains(text(),'Create New View')]")
	WebElement newViewlink;
	
	@FindBy(xpath="//input[@id='fname']")
	WebElement newViewNameTextbox;
	
	@FindBy(xpath="//input[@id='devname']")
	WebElement newViewUniqueNameTextbox;
	
	@FindBy(xpath="(//input[@class='btn primary'])[1]")
	WebElement saveBtnInNewView;
	
//	TestCase 28
	
	@FindBy(xpath ="//select[@id=\"hotlist_mode\"]")
	WebElement filterView;

//	testcase 29
	
	@FindBy(xpath ="//select[@id=\"fcf\"]")
	WebElement viewDropdownincontacts;

	
//	TestCAse 28
	public void selectFilter(String value) {
		selectValue(filterView,value);
	}
//Testcase 29	
	 public void selectViewFromContactsTab(String value) {
		 selectText(viewDropdownincontacts,value);
	 }
	
//TestCase 27
	public void clickOnNewViewLink() {
		newViewlink.click();
	}
	public void enterNewViewName(String value) {
		newViewNameTextbox.sendKeys(value);
	}
	public void enterNewViewUniqueName(String value) {
		newViewUniqueNameTextbox.click();
		newViewUniqueNameTextbox.clear();
		newViewUniqueNameTextbox.sendKeys(value);
	}
	public void clickOnSaveBtninContacts() {
		waitForElement(saveBtnInNewView);
		saveBtnInNewView.click();
	}
	
//	testcase26
	public void contactsTab() {
		contactsTab.click();
	}
	
	public void clickOnNewBtn() {
		waitForElement(newBtn);
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
