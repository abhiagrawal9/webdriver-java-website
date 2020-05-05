package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.TestAllureListener;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({TestAllureListener.class})
public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		launchBrowser();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	@Severity(SeverityLevel.MINOR)
	@Description("Verify the logo in login page")
	@Story("Login Page")
	public void testLoginPageLogo() {
		Boolean flag = loginPage.verifyLogo();
		Assert.assertTrue(flag, "Logo is not displaying in Login page");
	}

	@Test(priority = 2)
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify the login button in login page")
	@Story("Login Page")
	public void testLoginButtonInHomePage() {
		Boolean flag = loginPage.verifyLoginButton();
		Assert.assertTrue(flag, "Login button is not displaying in Login page");
	}

	@Test(priority = 3)
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify user is able to login with valid credentials")
	@Story("Login Page")
	public void testLoginIntoAccountwithVaildCredentials() throws Exception {
		homepage = loginPage.loginIntoAccount(TestBase.prop.getProperty("username"),
				TestBase.prop.getProperty("password"));
		Boolean flag = homepage.verifyProductLabel();
		Assert.assertTrue(flag, "User is not able to login with valid credentials in Login page");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
