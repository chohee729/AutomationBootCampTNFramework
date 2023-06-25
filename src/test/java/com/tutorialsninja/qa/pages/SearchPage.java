package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	
	public WebDriver driver;
	
	
	@FindBy (linkText = "HP LP3065")
	private WebElement validProduct;
	
	@FindBy (xpath = "//p[text() = 'There is no product that matches the search criteria.']")
	private WebElement invalidProductWarning;
	
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean displayStatusValidProduct() {
		boolean validDisplay = validProduct.isDisplayed();
		return validDisplay;
	}
	public String retrieveInvalidProductWarningMessage() {
		String invalidProductWarningText = invalidProductWarning.getText();
		return invalidProductWarningText;
}
}
