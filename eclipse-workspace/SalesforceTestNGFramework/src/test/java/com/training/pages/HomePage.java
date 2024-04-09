package com.training.pages;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	
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

	@FindBy(xpath ="//a[contains(text(),'Opportunities')]")
	WebElement opportunitiestab;

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
