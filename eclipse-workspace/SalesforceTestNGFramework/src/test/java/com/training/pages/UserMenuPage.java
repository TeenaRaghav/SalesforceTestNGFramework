package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class UserMenuPage extends BasePage{

	public UserMenuPage(WebDriver driver) {
		super(driver);
	}
//	usermenu
	@FindBy(xpath = "//div[@id ='userNavButton']")
	WebElement usermenu;
// myprofile
	@FindBy(xpath = "//a[contains(text(),'My Profile')]")
	WebElement myprofilebtn;

	@FindBy(xpath ="//a[@class=\"contactInfoLaunch editLink\"]")
	WebElement editbtn;
	
	@FindBy(id = "contactInfoContentId")
	WebElement abtframe;
	
	@FindBy(id = "aboutTab")
	WebElement abouttab;
	
	@FindBy(xpath ="//input[@class = 'lastName zen-inputFull zen-input']")
	WebElement lastname;
	
	@FindBy(xpath ="//input[@class ='zen-btn zen-primaryBtn zen-pas']")
	WebElement saveallbtn;
	
// mysettings elements
	@FindBy(xpath = "//a[contains(text(),'My Settings')]")
	WebElement mysettings;

	@FindBy(id = "PersonalInfo_font")
	WebElement personalinfolink;
	
	@FindBy(xpath ="//a[@id='LoginHistory_font']")
	WebElement loginhistorybtn;

	@FindBy(xpath = "//a[contains(text(),'Download login history for last six months, "
			+ "including logins from outside the website, such as API logins (Excel .csv file) »')]")
	WebElement loginhistorylink;

	@FindBy(id = "DisplayAndLayout_font")
	WebElement displayandlayoutlink;

	@FindBy(xpath = "//span[contains(text(),'Customize My Tabs')]")
	WebElement customizemytab;

	@FindBy(xpath = "//select[@id=\"p4\"]")
	WebElement customappdropdown;

	@FindBy(xpath = "//select[@id=\"duel_select_0\"]")
	WebElement availabletabsdropdown;

	@FindBy(className = "rightArrowIcon")
	WebElement addbtnincustomizeapp;

	@FindBy(xpath = "//input[@class=\"btn primary\"]")
	WebElement savebtnincustomizeapp;
	
	@FindBy(id = "EmailSetup_font")
	WebElement emaillink;
	
	@FindBy(id = "EmailSettings_font")
	WebElement myemailsettings;
	
	@FindBy(xpath="//select[@id=\"duel_select_0\"]")
	WebElement availabletabs;
	
	@FindBy(className = "rightArrowIcon")
	WebElement reporttab;
	
	@FindBy(xpath ="//input[@class=\"btn primary\"]")
	WebElement savechanges;
	
	@FindBy(id ="EmailSetup_font")
	WebElement emailtab;
	

	@FindBy(id="EmailSettings_font")
	WebElement myemailsetting;
	

	@FindBy(xpath ="//input[@id=\"sender_name\"]")
	WebElement emailnametextbox;

	@FindBy(xpath ="//input[@id=\"sender_email\"]")
	WebElement emailaddresstextbox;

	@FindBy(xpath ="//input[@id=\"auto_bcc1\"]")
	WebElement yesradiobtn;
	
	@FindBy(xpath ="//input[@class=\"btn primary\"]")
	WebElement savebtn;
	
	@FindBy(id ="CalendarAndReminders_font")
	WebElement calendarsandReminders;
	
	@FindBy(xpath ="//a[@id=\"Reminders_font\"]")
	WebElement activityReminders;
	
	@FindBy(id ="testbtn")
	WebElement testReminderbtn;
	
// usermenu
	public void usermenu() {
//		waitForElement(usermenu);
		usermenu.click();
	}
	
//	myprofile
	public void myProfile() {
		waitForElement(myprofilebtn);
		myprofilebtn.click();
	}

	public void editBtn() {
		waitForElement(editbtn);
		editbtn.click();
	}
	
	public void abtFrame() {
		waitForElement(abtframe);
		driver.switchTo().frame(abtframe);	
	}
	
	public void enterIntoLastname(String strlastname) {
		lastname.clear();
		lastname.sendKeys(strlastname);
	}
	
	public void clickSaveall() {
		saveallbtn.click();
	}
	
	public void aboutTab() {
		abouttab.click();
	}
	
	public void switchToDefaultFrame() {
		switchToDefault();
	}
//	mysettings

	public void mySettings() {
		mysettings.click();
	}

	public void personalInfo() {
		personalinfolink.click();
	}
	
	public void loginhistorylink() {
		waitForElement(loginhistorylink);
		loginhistorylink.click();
	}

	public void displayAndLayout() {
		displayandlayoutlink.click();
	}

	public void customizeMyTab() {
		customizemytab.click();
	}
	
	public void customappdropdown(String value) {
		selectText(customappdropdown,value);
	}
	public void loginhistorybtn() {
//		waitForElement(loginhistorybtn);
		loginhistorybtn.click();
	}
	public void availabletabs(String value) {
		selectValue(availabletabs,value);
	}
	public void reportTab() {
		reporttab.click();
	}

	public void saveTheChange() {
		savechanges.click();
	}
	public void emailTab() {
		emailtab.click();
	}

	public void myEmailSettings() {
		myemailsetting.click();
	}
	public void enterEmailName(String value) {
		emailnametextbox.clear();
		emailnametextbox.sendKeys(value);
	}
	public void enterEmailAddress(String value) {
		emailaddresstextbox.clear();
		emailaddresstextbox.sendKeys(value);;
	}
	public void yesbtn() {
		radiobtn(yesradiobtn);
	}
	public void saveBtnInEmailSettings() {
		savebtn.click();
	}
	public void acceptTheAlert() {
		acceptAlert();
	}
	public void clickOncalendarsAndReminders() {
		calendarsandReminders.click();
	}
	public void clickOnActivityReminder() {
		activityReminders.click();
	}
	public void clickOnTestReminder() {
		testReminderbtn.click();
	}
	public void performActionInWindowInDC() {

		String title = driver.getTitle();
		System.out.println("Tile of the new window is :" + title);
		driver.close();

	}

}
