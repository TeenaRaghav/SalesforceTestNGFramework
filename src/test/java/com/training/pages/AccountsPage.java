package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.training.base.BasePage;

public class AccountsPage extends BasePage {

	
	@FindBy(xpath ="//input[@value=\" New \"]")
	WebElement newButtonInAccountsPage;
	
	@FindBy(xpath ="//input[@id=\"acc2\"]")
	WebElement accountnametextbox;
	
	@FindBy(id ="acc6")
	WebElement typeDropdown;

	@FindBy(xpath = "//select[@id=\"00Nak0000011psl\"]")
	WebElement priority;
	
	@FindBy(xpath = "(//input[@name=\"save\"])[1]")
	WebElement saveBtnInCreateAccountsPage;
	
	@FindBy(xpath = "//a[contains(text(),'Create New View')]")
	WebElement newviewlink;
	
	@FindBy(xpath = "//input[@id=\"fname\"]")
	WebElement viewname;
	
	@FindBy(xpath = "//input[@id=\"devname\"]")
	WebElement viewuniquename;
	
	@FindBy(xpath = "//input[@name=\"save\"]")
	WebElement savebtninnewviewlink;
	
	@FindBy(xpath = "//select[@name='fcf']")
	WebElement viewdropdown;
	
	@FindBy(xpath = "//a[contains(text(),'Edit')]")
	WebElement editlink;
	
	@FindBy(xpath ="//select[@id=\"fcol1\"]")
	WebElement fieldineditviewpage;
	
	@FindBy(xpath ="//select[@id=\"fop1\"]")
	WebElement operatorineditviewpage;
	
	@FindBy(xpath ="//input[@id=\"fval1\"]")
	WebElement valueineditviewpage;
	
	@FindBy(xpath ="//select[@id=\"colselector_select_0\"]")
	WebElement availablefields;
	
	@FindBy(xpath ="//img[@class=\"rightArrowIcon\"]")
	WebElement addbtnineditviewpage;
	
	@FindBy(xpath ="//input[@value=\" Save \"]")
	WebElement savebtnineditviewpage;

	@FindBy(xpath ="//a[contains(text(),'Merge Accounts')]")
	WebElement mergeaccntlink;

	@FindBy(xpath ="//input[@id=\"srch\"]")
	WebElement searchaccounttextbox;

	@FindBy(xpath ="//input[@value=\"Find Accounts\"]")
	WebElement findaccountbtn;
	
	@FindBy(id ="cid2")
	WebElement accountcheckbox;

	@FindBy(xpath = "//input[@title=\"Next\"]")
	WebElement mergeaccntnextbtn;

	@FindBy(xpath = "//input[@value=\" Merge \"]")
	WebElement mergebtn;
	
	@FindBy(xpath = "//a[contains(text(),'Accounts with last activity > 30 days')]")
	WebElement lastactivitylinkinaccountspage;
	
	@FindBy(xpath ="//input[@id=\"ext-gen20\"]")
	WebElement datefieldDropdown;
	
	@FindBy(xpath ="//div[contains(text(),'Created Date')]")
	WebElement createddatefield;

	@FindBy(xpath ="//img[@id=\"ext-gen152\"]")
	WebElement dateinFromfield;

	@FindBy(xpath ="//span[contains(text(),'24')]")
	WebElement todaysdateinfromfield;

	@FindBy(id ="ext-gen154")
	WebElement dateintofield;

	@FindBy(xpath ="(//button[contains(text(),'Today')])[2]")
	WebElement todaysdateintofield;

	@FindBy(xpath ="//button[@id=\"ext-gen49\"]")
	WebElement savebtnincreatereportpage;

	@FindBy(xpath ="//input[@id=\"saveReportDlg_reportNameField\"]")
	WebElement reportnameTextBox;

	@FindBy(xpath ="//input[@id=\"saveReportDlg_DeveloperName\"]")
	WebElement reportuniquenameTextBox;

	@FindBy(xpath ="//table[@id=\"dlgSaveAndRun\"]/tbody/tr[2]/td[2]")
	WebElement saveandrunbtn;
	
	public AccountsPage(WebDriver driver) {
		super(driver);
	}

	public void newBtn() {
		newButtonInAccountsPage.click();
	}
	
	public void accountName(String straccountname) {
		accountnametextbox.sendKeys(straccountname);
	}
	 public void selectType(String value) {
		 selectValue(typeDropdown,value);
	 }
	
	 public void selectPriority(String value) {
		 waitForElement(priority);
		 selectValue(priority,value);
	 }
	 public void save() {
		 saveBtnInCreateAccountsPage.click();
		 }
	
	 public void newViewLink() {
		 newviewlink.click();
		 }
	 public void enterViewName(String strviewname) {
		 viewname.sendKeys(strviewname);
		 }
	 public void enterViewUniqueName(String strviewuniquename) {
		 viewuniquename.click();
		 waitForElement(viewuniquename);
		 viewuniquename.clear();
		 viewuniquename.sendKeys(strviewuniquename);
		 }
	 public void saveNewViewDetails() {
		 savebtninnewviewlink.click();
	 }
	 public void selectView(String value) {
		 selectValue(viewdropdown,value);
	 }
	 public void editLink() {
		 editlink.click();
	 } 
	 public void changeViewName(String strnewviewname) {
		 if(viewname.isDisplayed()) {
			 viewname.clear();
			 viewname.sendKeys(strnewviewname);
		 }else {
			 System.out.println("Element not found");
		 }
	 } 
	 public void selectField(String value) {
		 selectText(fieldineditviewpage,value);
	 }
	 
	 public void selectOperator(String value) {
		 waitForElement(operatorineditviewpage);
		 selectText(operatorineditviewpage,value);
	 }
	 
	 public void enterValue(String strvalue) {
		 if(valueineditviewpage.isDisplayed()) {
			 valueineditviewpage.clear();
			 valueineditviewpage.sendKeys(strvalue);
		 }else {
			 System.out.println("Element not found");
		 }
		 }
	 public void selectAvailableField(String value) {	
		 waitForElement(availablefields);
		 selectValue(availablefields,value);
	 }
	 public void addField() {
		 addbtnineditviewpage.click();
	 }

	 public void saveEditPage() {
		 savebtnineditviewpage.click();
	 }
	 
	 public void clickOnMergeAccountLink() {
		 mergeaccntlink.click();
	 }
	 
	 public void enterIntoSearchAccountTextbox(String value) {
		 searchaccounttextbox.sendKeys(value);
	 }
	 
	 public void clickOnFindAcccountButton() {
		 findaccountbtn.click();
	 }
	 
	 public void uncheckOtherCheckBoxes() {
		 if(accountcheckbox.isDisplayed()) {
			 if(accountcheckbox.isSelected()) {
				 accountcheckbox.click();
			 }
		 }
	 }
	 
	 public void clickOnNextBtn() {
		 mergeaccntnextbtn.click();
	 }
	 public void clickOnMergeAccountBtn() {
		 mergebtn.click();
	 }
	 public void acceptTheAlert() {
	     acceptAlert();
	 }
	 
	public void clickOnLastActivityLink() {
		lastactivitylinkinaccountspage.click();
	}
	public void clickOnDateFieldDropDown() {
		datefieldDropdown.click();
	}
	public void clickOnCreatedDate() {
		createddatefield.click();
	}
	public void selectDateInFromField() {
		dateinFromfield.click();
	}
	public void selectTodayDateInFromField() {
		todaysdateinfromfield.click();
	}
	public void selectDateInToField() {
		dateintofield.click();
	}
	public void selectTodaysDateInToField() {
		todaysdateintofield.click();
	}
	public void clickOnSaveBtnInCreateReportPage() {
		savebtnincreatereportpage.click();
	}
	public void enterReportNameIntextBox(String value) {
		reportnameTextBox.sendKeys(value);
	}
	public void enterReportUniqueNameIntextBox() {
		reportuniquenameTextBox.click();
	}
	public void ClickOnSaveAndRunBtn() {
		 saveandrunbtn.click();
	}
	
	
}

