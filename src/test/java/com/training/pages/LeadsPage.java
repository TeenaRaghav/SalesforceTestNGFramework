package com.training.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class LeadsPage extends BasePage {

	public LeadsPage(WebDriver driver) {
		super(driver);
	}
//	testcase 21

	@FindBy(xpath ="//a[contains(text(),'Leads')]")
	WebElement leadstab;

	@FindBy(xpath ="//div[@class=\"bPageTitle\"]/div/div/h1")
	WebElement leadsPagetitle;
	
//	testcase 22

	@FindBy(xpath ="//select[@name=\"fcf\"]")
	WebElement leadsview;
//	testcase 23
	@FindBy(xpath ="(//input[@class=\"btn\"])[2]")
	WebElement gobtn;
//	testcase 24
	@FindBy(xpath ="//select[@id='fcf']")
	WebElement todaysLeadPageDropdown;
// testcase 25
	@FindBy(xpath ="//input[@title='New']")
	WebElement newBtnLeadPage;
	
	@FindBy(xpath ="//input[@id=\"name_lastlea2\"]")
	WebElement lastNameOnNewView;
	
	@FindBy(xpath ="//input[@id='lea3']")
	WebElement companyNameOnNewView;

	@FindBy(xpath ="(//input[@value=' Save '])[1]")
	WebElement saveBtnOnNewView;
	
	// testCase 21
	public void clickOnLeadsTab() {
		waitForElement(leadstab);
		leadstab.click();
	}
	public void checkOnLeadsPageTitle() {
		String pagetitlr = leadsPagetitle.getText();
		Assert.assertEquals(pagetitlr, "Leads");
	}
//	testcase22 
	public void clickOnLeadsView() {
		leadsview.click();
	}
	public void selectLeadsView(String value) {
		selectText(leadsview,value);
	}
	public void ClickOnGoBtn() {
		gobtn.click();
	}
	public void checkFirstSelectedOption() {
		Select selectDrpdown = new Select(todaysLeadPageDropdown);
		WebElement selectedText = selectDrpdown.getFirstSelectedOption();
		String ActualSelectedText =selectedText.getText();
		Assert.assertEquals(ActualSelectedText, "Today's Leads");
	}
	public void newBtnOnLeadsPage() {
		newBtnLeadPage.click();
	}
	public void EnterLastNameOnLeadsPage(String value) {
		lastNameOnNewView.sendKeys(value);
	}
	public void EnterCompanyNameOnLeadsPage(String value) {
		companyNameOnNewView.sendKeys(value);
	}
	public void ClickOnSaveButton() {
		saveBtnOnNewView.click();
	}
}
