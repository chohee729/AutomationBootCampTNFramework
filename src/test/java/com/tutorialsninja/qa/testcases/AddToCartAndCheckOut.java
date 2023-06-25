package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorialsninja.qa.pages.AddToCartPage;
import com.tutorialsninja.qa.pages.CheckOutPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.pages.SearchPage;
import com.tutorialsninja.qa.testBase.TestBase;

public class AddToCartAndCheckOut extends TestBase {

	public AddToCartAndCheckOut() throws Exception{
		super();
		
		
	}
	public WebDriver driver;
	SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setup() {
		driver = openApplication(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.enterProductNameInSearchBox(dataProp.getProperty("validProduct"));
		homepage.searchButton();
		SearchPage searchpage = new SearchPage (driver);
		searchpage.displayStatusValidProduct(); 
		softassert.assertAll();
	}
	@Test(priority=1)
	public void addToCart() {
		AddToCartPage addtocartpage = new AddToCartPage(driver);
		AddToCartPage.searchedProduct(dataProp.getProperty("productName"));
		AddToCartPage.ClickOnaddToCartButton();
		String actualWarningMessage = AddToCartPage.retrieveSuccessMessage();
		String expectedWarningMessage = dataProp.getProperty("addToCartSuccessMessage");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		softassert.assertAll();
}
	@Test(priority=2)
	public void checkOut() {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccountLink();
		homepage.selecLoginOption();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailinEmailTextBoxField(prop.getProperty("validEmail"));
		loginpage.enterPasswordinPasswordTextBoxField(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
		CheckOutPage checkoutpage = new CheckOutPage(driver);
		checkoutpage.clickOnCheckOutButton();
		checkoutpage.clickOnPaymentExisting();
		checkoutpage.clickOnPaymentAddress();
		checkoutpage.clickOnExistingShipping();
		checkoutpage.clickOnShippingAddress();
		checkoutpage.clickOnShippingMethod();
		checkoutpage.clickOnAgree();
		checkoutpage.clickOnPaymentMethod();
		checkoutpage.clickOnConfirm();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();	
}}