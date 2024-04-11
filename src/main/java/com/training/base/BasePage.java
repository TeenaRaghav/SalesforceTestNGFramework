package com.training.base;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	WebDriverWait wait;
	Actions action;
	Select select;
	JavascriptExecutor js;
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void waitForElement(WebElement element) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void actions(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
	public void refreshpage() {
		driver.navigate().refresh();
	}
	public String getTextFromElement(WebElement ele) {
		String data = ele.getText();
		System.out.println("extracted the text");
		return data;
	}
	public void clearElement(WebElement ele) {
		if (ele.isDisplayed()) {
			ele.clear();
		} else {
			System.out.println(" element is not displayed.");
		}
	}
	public void enterText(WebElement ele, String data) {
		if (ele.isDisplayed()) {
			clearElement(ele);
			ele.sendKeys(data);
			System.out.println("data is entered in the textbox");
		} else {
			System.out.println(" element is not displayed.");
		}
	}
	
	public void selectText(WebElement ele,String text) {
		select = new Select(ele);
		select.selectByVisibleText(text);
	}
	
	public void selectValue(WebElement ele,String value) {
		select = new Select(ele);
		select.selectByValue(value);
	}
	public void selectIndex(WebElement ele,int index) {
		select = new Select(ele);
		select.selectByIndex(index);
	}
	public void switchFrame(WebElement frame) {
		driver.switchTo().frame(frame);
	}
	public void switchToDefault() {
		driver.switchTo().defaultContent();
	}
	public void radiobtn(WebElement ele) {
		if(!ele.isSelected()) {
			ele.click();
		}else {
			System.out.println("yes button is already selected.");
		}
	}
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
	
	public void scrolldown() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
	}
	public void switchToNewWindow() {
		String mainWindow = driver.getWindowHandle();
		for(String window : driver.getWindowHandles()) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
			}
		}
	}
	public List<WebElement> getDropdownContents(Select ele) {
	List<WebElement> alloptions = ele.getOptions();
	 return alloptions;
	
}
}