package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchBrowser();
		loginPage = new LoginPage();
		homepage = loginPage.loginIntoAccount(TestBase.prop.getProperty("username"),
				TestBase.prop.getProperty("password"));
	}

	@Test(priority = 2)
	public void testAddProductToShoppingCart() throws Exception {
		homepage.addProductToShoppingCart();
		Boolean flag = homepage.verifyShoppingCartBadge();
		Assert.assertTrue(flag, "Shopping Cart Badge is not showing when a user adds product to shopping cart");
	}

	@Test(priority = 1)
	public void testHomePageTitle() {
		String actualtitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(actualtitle, "Swag Labs", "Home page title is not displaying correct");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
