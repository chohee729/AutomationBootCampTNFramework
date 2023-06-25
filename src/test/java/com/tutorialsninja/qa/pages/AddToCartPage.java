package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
 
	public WebDriver driver;
	
	@FindBy (linkText = "HP LP3065")
	private static WebElement searchedProduct;
	
	@FindBy (id = "button-cart")
	private static WebElement addToCartButton;
	
	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private static WebElement addToCartSuccessMessage;
	
	
	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public static void searchedProduct(String productName) {
		searchedProduct.click();
}
	public static void ClickOnaddToCartButton() {
		addToCartButton.click();
		
	}
	public static String retrieveSuccessMessage() {
		String success = addToCartSuccessMessage.getText();
		return  success;
	}

}
