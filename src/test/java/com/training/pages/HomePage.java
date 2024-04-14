package com.training.pages;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.training.base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "(//a[contains(text(),'Home')])[1]")
	WebElement hometab;

	@FindBy(xpath = "//a[contains(text(),'Developer Console')]")
	WebElement developerconsolebtn;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logout;
	
	@FindBy(xpath = "//a[@class='publisherattach publisherattachTextPost withArrowAttached']")
	WebElement postLink;

	@FindBy(xpath = "//iframe[@class='cke_wysiwyg_frame cke_reset']")
	WebElement postframe;

	@FindBy(xpath = "//body[contains(text(),'Share an update, @mention someone...')]")
	WebElement posttextarea;

	@FindBy(className = "bottomBarRight")
	WebElement postshare;

	@FindBy(xpath = "//a[@title ='File']")
	WebElement filelink;

	@FindBy(xpath = "//a[@title ='Upload a file from your computer']")
	WebElement uploadfromcompbtn;

	@FindBy(xpath = "//input[@id='chatterFile']")
	WebElement choosefilebtn;

	@FindBy(xpath = "//input[@id='publishersharebutton']")
	WebElement fileshare;

	@FindBy(xpath = "//div[@id='photoSection']")
	WebElement profileimage;

	@FindBy(xpath = "//a[contains(text(),'Add Photo')]")
	WebElement addprofilephoto;

	@FindBy(id = "uploadPhotoContentId")
	WebElement addphotoframe;

	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadInputFile']")
	WebElement choosephoto;

	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
	WebElement choosephotosavebtn;

	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	WebElement photosavebtn;

	@FindBy(id = "Account_Tab")
	WebElement accountstab;
//	Testcase 36

	@FindBy(id = "AllTab_Tab")
	WebElement plusBtn;
	
	@FindBy(className="btnImportant")
	WebElement customizemytabBtn;
	
	@FindBy(xpath="//option[contains(text(),'Leads')]")
	WebElement selectTabFromSelectedTabsArea;
	
	@FindBy(id="duel_select_0_left")
	WebElement removebtn;
	
	@FindBy(xpath=" //input[@value=\" Save \"]")
	WebElement savebtn;
//	Testcase37
	@FindBy(xpath= "//a[normalize-space()='Sunday April 14, 2024']")
	WebElement currentDateLink;
	@FindBy(id= "p:f:j_id25:j_id61:28:j_id64")
	WebElement eightpmLink;
	@FindBy(className= "comboboxIcon")
	WebElement subjectComboicon;
	@FindBy(xpath="//a[contains(text(),'Other')]")
	WebElement other;
	@FindBy(xpath="//input[@id=\"EndDateTime_time\"]")
	WebElement endTimeField;
	@FindBy(id="timePickerItem_42")
	WebElement ninepmFromDropdown;
	@FindBy(xpath="(//input[@value=\" Save \"])[1]")
	WebElement savebtn1;
	
	
//	Testcase 37
	public void currentDateDisplayAndClicked() {
		getTextFromElement(currentDateLink);
		System.out.println(currentDateLink.isDisplayed());
		currentDateLink.click();
	}
	public void eightPmLink() {
		eightpmLink.click();
	}
	public void subjectComboIcon() {
		subjectComboicon.click();
	}
	public void clickOnOther() {
		String parentWindow = getParentWindow();
		switchToChildWindow();
		other.click();
		switchToParentWindow(parentWindow);
	}
	public void clickOnEndTimeField() {
		endTimeField.click();
	}
	public void clickOnNinePmFromDropDown() {
		ninepmFromDropdown.click();
	}
	public void clickOnSaveBtn1() {
		savebtn1.click();
	}
//	Testcase 36
	public void clickOnPlusBtn() {
		plusBtn.click();
	}
	public void clickOnCustomizeMyTabBtn() {
		customizemytabBtn.click();
	}
	public void selectatbFromselectedarea() {
		selectTabFromSelectedTabsArea.click();
	}
	public void clickOnRemovebtn() {
		removebtn.click();
	}
	public void clickOnsavebtn() {
		savebtn.click();
	}
// testcase 34
	@FindBy(xpath ="//a[contains(text(),'Teena Raghav')]")
	WebElement Usernamelink;
	@FindBy(xpath ="(//a[contains(text(),\"Teena Raghav\")])[1]")
	WebElement firstAndLastNamelink;
	
//testcase 34
	public void validateFirstname(String value1,String value2) {
	String actualtitle=getTextFromElement(Usernamelink);
		String expectedtitle = getExpectedTitle(value1);
		String actualurl = getActualUrl();
		String expectedUrl= getExpectedUrl(value2);
		if(actualtitle.equals(expectedtitle) && actualurl.equals(expectedUrl)) {
			System.out.println("You are on homepage");
		}
	}
	public void clickOnNameLink() {
		firstAndLastNamelink.click();
	}
	
	
	public void homeTab() {
		hometab.click();
	}

	public void accountsTab() {
		accountstab.click();
	}

	public void logout() {
		waitForElement(logout);
		logout.click();
	}

	public void post() {
		waitForElement(postLink);
		postLink.click();
	}

	public void textFrame() {
		switchFrame(postframe);
	}

	public void enterInToTextbox(String strtext) {
		waitForElement(posttextarea);
		posttextarea.sendKeys(strtext);
	}
	
	public void postFrame() {
		switchToDefault();
	}

	public void sharePost() {
		waitForElement(postshare);
		postshare.click();
	}

	public void file() {
		waitForElement(filelink);
		filelink.click();
	}

	public void uploadFromComputer() {
		waitForElement(uploadfromcompbtn);
		uploadfromcompbtn.click();
	}

	public void chooseFile(String path) {
		waitForElement(choosefilebtn);
		choosefilebtn.sendKeys(path);
	}

	public void shareFile() {
		fileshare.click();
	}

	public void addPhoto() {
		actions(profileimage);
	}

	public void clickAddPhotoLink() {
		waitForElement(addprofilephoto);
		addprofilephoto.click();
	}

	public void addFrame() {
		switchFrame(addphotoframe);
	}

	public void choosePhoto(String strphotopath) {
		waitForElement(choosephoto);
		choosephoto.sendKeys(strphotopath);
	}

	public void clickOnChoosePhotoBtn() {
		choosephotosavebtn.click();
	}

	public void savePhoto() {
		waitForElement(photosavebtn);
		photosavebtn.click();
	}

	public void developerConsole() {
		developerconsolebtn.click();
	}

	public void parentwindow() {
		driver.getWindowHandle();
	}

	public void windows(String parentwindowhandle) {
		Set<String> listofhandles = driver.getWindowHandles();
		for (String handle : listofhandles) {
			if (!handle.equals(parentwindowhandle)) {
				driver.switchTo().window(handle);
			}
		}
	}
}
