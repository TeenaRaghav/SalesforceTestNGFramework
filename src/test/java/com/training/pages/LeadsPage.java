package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.training.base.BasePage;

public class LeadsPage extends BasePage {

	public LeadsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="//a[contains(text(),'Leads')]")
	WebElement leadstab;

	@FindBy(xpath ="//div[@class=\"bPageTitle\"]/div/div/h1")
	WebElement leadsPagetitle;
// testCase 21
	public void clickOnLeadsTab() {
		leadstab.click();
	}
	public void checkOnLeadsPageTitle() {
		String pagetitlr = leadsPagetitle.getText();
		Assert.assertEquals(pagetitlr, "Leads");
	}
}
