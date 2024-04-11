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
	
// testCase 21
	public void clickOnLeadsTab() {
		leadstab.click();
	}
	public void checkOnLeadsPageTitle() {
		String pagetitlr = leadsPagetitle.getText();
		Assert.assertEquals(pagetitlr, "Leads");
	}
//	testcase22 
	public void selectLeadsView() {
		leadsview.click();
		
	}
}
