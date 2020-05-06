package com.qa.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.qa.utils.Helper;
import com.qa.base.TestBase;

public class HomePage extends TestBase {

//	@FindBy(className = "product_label")
	// @FindBy(className = "product_label")
	// One more way of doing the above.
	@FindBy(how = How.CLASS_NAME, using = "product_label")
	private WebElement productsLabel;

	@FindBy(xpath = "//*[text()='ADD TO CART']")
	private List<WebElement> addToCartOptions;

	@FindBy(id = "shopping_cart_container")
	private WebElement shoppingCartOption;

	@FindBy(xpath = "//*[contains(@class,'shopping_cart_badge')]")
	private WebElement shoppingCartBadge;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyProductLabel() {
		return productsLabel.isDisplayed();
	}

	public void addProductToShoppingCart() {
		List<WebElement> addToCartList = addToCartOptions;
		int rn = Helper.getRandomIntWithinRange(0, addToCartList.size() - 1);
		addToCartList.get(rn).click();
	}

	public boolean verifyShoppingCartBadge() {
		return shoppingCartBadge.isDisplayed();
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public ShoppingCartPage clickOnShoppingCartOption() {
		shoppingCartOption.click();
		return new ShoppingCartPage();
	}

}
