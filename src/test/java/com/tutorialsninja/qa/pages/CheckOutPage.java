package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	public WebDriver driver;
	
	@FindBy (linkText = "Checkout")
	private WebElement checkOutOption;
	
	@FindBy (id ="payment-existing" )
	private WebElement paymentExistingOption;
	
	@FindBy (id ="button-payment-address" )
	private WebElement paymentAddressButton;
	
	@FindBy (id ="shipping-existing" )
	private WebElement existingShippingOption;
	
	@FindBy (id = "button-shipping-address")
	private WebElement shippingAddressOption;
	
	@FindBy (id = "button-shipping-method")
	private WebElement shippingMethodOption;
	
	@FindBy (name ="agree")
	private WebElement agreeButton;
	
	@FindBy (id ="button-payment-method" )
	private WebElement paymentMethodButton;
	
	@FindBy (id ="button-confirm" )
	private WebElement confirmButton;
	
	
	
	
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
}
	
	public void clickOnCheckOutButton() {
		checkOutOption.click();
	}
	public void clickOnPaymentExisting(){
		paymentExistingOption.click();
	}
	public void clickOnPaymentAddress(){
		paymentAddressButton.click();	
	}
	public void clickOnExistingShipping(){
		existingShippingOption.click();
	}
	public void clickOnShippingAddress(){
		shippingAddressOption.click();
	}
	public void clickOnShippingMethod(){
		shippingMethodOption.click();
	}
	public void clickOnAgree(){
		agreeButton.click();
	}
	public void clickOnPaymentMethod(){
		paymentMethodButton.click();
	}
	public void clickOnConfirm(){
		confirmButton.click();
	}

}


