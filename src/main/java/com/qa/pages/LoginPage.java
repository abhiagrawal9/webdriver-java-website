package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(className = "login_logo")
	private WebElement logo;

	@FindBy(id = "user-name")
	@CacheLookup // save this recurring element into cache
	private WebElement usernameField;

	@FindBy(id = "password")
	@CacheLookup // save this recurring element into cache
	private WebElement passwordField;

	@FindBy(xpath = "//*[@value='LOGIN']")
	private WebElement loginButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyLoginButton() {
		return loginButton.isDisplayed();
	}

	public boolean verifyLogo() {
		return logo.isDisplayed();
	}

	public HomePage loginIntoAccount(String email, String pwd) throws InterruptedException {
		usernameField.sendKeys(email);
		passwordField.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
	}
}
