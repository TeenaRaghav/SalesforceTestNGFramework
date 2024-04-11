package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.training.base.BasePage;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "username")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "Login")
	WebElement login;
	
	@FindBy(id= "error")
	WebElement errormessage;

	@FindBy(xpath="//input[@class ='r4 fl mr8']")
	WebElement rememberme;
	
	@FindBy(id ="idcard-identity")
	WebElement usernamefieldafterlogin;
	
	@FindBy(id = "forgot_password_link")
	WebElement forgotPassword;
	
	@FindBy(xpath = "//input[@id = 'un']")
	WebElement forgotpasswordusername;
	
	@FindBy(xpath = "//input[@id = 'continue']")
	WebElement continueButton;
	
	
	public void enterIntoUsername(String strusername) {
		waitForElement(username);
		username.sendKeys(strusername);
	}
	public void enterIntoPassword(String strpass) {
		password.sendKeys(strpass);
	}
	public void clickLogin() {
//		waitForElement(login);
		login.click();
	}
	public void getErrorMessage() {
		String actualerrormessage =errormessage.getText();
		String expectederrormessage ="Please enter your password.";
	Assert.assertEquals(actualerrormessage, expectederrormessage);
	}
	
	public void checkRememberme() {
		rememberme.click();
	}
	
	public void checkUsernameFieldIsPopulated() {
//		waitForElement(usernamefieldafterlogin);
		Assert.assertNotNull(usernamefieldafterlogin);
	}
	public void clickOnForgotPasswordLink(String strusername) {
		forgotPassword.click();
		forgotpasswordusername.sendKeys(strusername);
		continueButton.click();
	}
	 public void errorMessageAfterWrongusernameAndPassword() {
		 String actualerror = errormessage.getText();
		String ExpectedErrorForWrongCredentials = "Please check your username and password."
				+ " If you still can't log in, contact your Salesforce administrator.";
	 Assert.assertEquals(actualerror, ExpectedErrorForWrongCredentials);
	 }
	
	
}
