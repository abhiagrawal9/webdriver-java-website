package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ShoppingCartPage;

public class ShoppingCartPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	ShoppingCartPage shoppingCartPage;

	public ShoppingCartPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchBrowser();
		loginPage = new LoginPage();
		homepage = loginPage.loginIntoAccount(TestBase.prop.getProperty("username"),
				TestBase.prop.getProperty("password"));
		shoppingCartPage = homepage.clickOnShoppingCartOption();
	}

	@Test
	public void testShoppingCartPage() {
		shoppingCartPage.verifyShoppingCartPage(); // Sample method
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
