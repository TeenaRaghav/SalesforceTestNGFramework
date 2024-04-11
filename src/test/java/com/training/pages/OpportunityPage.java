package com.training.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.training.base.BasePage;

public class OpportunityPage extends BasePage {

	public OpportunityPage(WebDriver driver) {
		super(driver);
	}
//	testcase 16
	@FindBy(xpath = "//a[contains(text(),'Opportunities')]")
	WebElement opportunityTab;
	
	@FindBy(xpath = "//select[@id=\"fcf\"]")
	WebElement opportunityTabdropdown;
	
//	testcase 17

	@FindBy(xpath = "//input[@name=\"new\"]")
	WebElement opportunityNewBtn;

	@FindBy(xpath ="//input[@id=\"opp3\"]")
	WebElement opportunityNametextbox;
	
	@FindBy(xpath ="//input[@id=\"opp4\"]")
	WebElement opportunityAccountName;

	@FindBy(xpath ="//input[@id=\"opp9\"]")
	WebElement opportunityCloseDate;
	
	@FindBy(xpath ="//table[@class='calDays']/tbody/tr[4]/td[3]")
	WebElement opportunityCloseDateselectbtn;
	
	@FindBy(xpath ="//select[@id=\"opp11\"]")
	WebElement opportunityStage;

	@FindBy(xpath ="//input[@id=\"opp12\"]")
	WebElement opportunityProbability;

	@FindBy(xpath ="//select[@id=\"opp6\"]")
	WebElement opportunityLeadSource;

	@FindBy(id = "opp17_lkwgt")
	WebElement opportunityPrimaryCampaignSource;

	@FindBy(xpath ="//frame[@id=\"resultsFrame\"]")
	WebElement opportunityPrimaryCampaignFrame;

	@FindBy(xpath ="//a[contains(text(),'DM Campaign to Top Customers - Nov 12-23, 2001')]")
	WebElement opportunityPrimaryCampaignlink;

	@FindBy(xpath ="//input[@name=\"save\"]")
	WebElement opportunitySaveBtn;

//	testcase 18
	@FindBy(xpath ="//a[contains(text(),'Opportunity Pipeline')]")
	WebElement opportunitypipelinelink;
	@FindBy(xpath ="//div[@class=\"content\"]/h1")
	WebElement opportunitypageheading;
	
//	testcase19
	@FindBy(xpath = "//a[contains(text(),'Stuck Opportunities')]")
	WebElement stuckopportunitylink;
	@FindBy(xpath = "//div[@class=\"content\"]/h1")
	WebElement stuckopportunitypageheading;

//	testcase 20
	@FindBy(xpath = "//table[@class=\"opportunitySummary\"]/tbody/tr[1]/td[1]/select")
	WebElement intervaldropdown;
	
	@FindBy(xpath = "//select[@id=\"open\"]")
	WebElement includedropdown;
	
	@FindBy(xpath ="//input[@value=\"Run Report\"]")
	WebElement runandreportbtn;
	
//	opportunity tab
	public void opportunityTab() {
		waitForElement(opportunityTab);
		opportunityTab.click();
	}
	public void opportunityTabDropdwn() {
		opportunityTabdropdown.click();
	}
// testcase 17
	
	public void newOpportunity() {
		opportunityNewBtn.click();
	}
	
	public void opportunityName(String value) {
		opportunityNametextbox.sendKeys(value);
	}
	
	public void opportunityAccountName(String value) {
		opportunityAccountName.sendKeys(value);
	}
	public void oppCloseDate() {
		opportunityCloseDate.click();
		waitForElement(opportunityCloseDateselectbtn);
		opportunityCloseDateselectbtn.click();
	}
	public void oppSelectStage(String value) {
		selectValue(opportunityStage,value);
	}
	public void oppProbability() {
		opportunityProbability.click();
	}
	public void oppSelectLeadSource(String value) {
		selectValue(opportunityLeadSource,value);
	}
	public void primaryCampaignSourcebtn() {
		opportunityPrimaryCampaignSource.click();
	}
	public void switchTowindowAndSelectCampaignSource() {
		String parentwindow = driver.getWindowHandle();
		Set<String> listOfHandles =driver.getWindowHandles();
		
		for(String handle: listOfHandles) {
			if(!handle.equals(parentwindow)) {
				driver.switchTo().window(handle);
				switchFrame(opportunityPrimaryCampaignFrame);				
				opportunityPrimaryCampaignlink.click();
			}
		}
		driver.switchTo().window(parentwindow);	
		}
	
	public void opportunitySaveButton() {
		opportunitySaveBtn.click();
	}
//	testcase 18
	public void opportunityPipeLine() {
		opportunitypipelinelink.click();
	}
	public void validatingopportunitypipelinePageIsDisplyed() {
		Assert.assertEquals(getTextFromElement(opportunitypageheading),"Opportunity Pipeline");
	}
//	testcase 19
	public void stuckOpportunityLink() {
		stuckopportunitylink.click();
	}
	public void validatingstuckOpportunityPageIsDisplyed() {
		Assert.assertEquals(getTextFromElement(stuckopportunitypageheading),"Stuck Opportunities");
	}
//	 testcase 20
	public void selectInterval(String value) {
		selectText(intervaldropdown,value);
	}
	public void selectInclude(String value) {
		selectText(includedropdown,value);
	}
	public void clickOnRunAndReport() {
		runandreportbtn.click();
	}
}
