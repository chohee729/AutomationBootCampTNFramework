package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;
import com.tutorialsninja.qa.testBase.TestBase;

public class SearchProductTest extends TestBase {

	public SearchProductTest() throws Exception {
		super();
		
	}
	public WebDriver driver;
	SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setup() {
		driver = openApplication(prop.getProperty("browser"));
}
	@Test(priority=1)
	public void searchWithValidProduct() {
		HomePage homepage = new HomePage(driver);
		homepage.enterProductNameInSearchBox(dataProp.getProperty("validProduct"));
		homepage.searchButton();
		SearchPage searchpage = new SearchPage (driver);
		softassert.assertTrue(searchpage.displayStatusValidProduct()); 
		softassert.assertAll();
	}
	@Test(priority=2)
	public void searchWithInvalidProduct() {
		HomePage homepage = new HomePage(driver);
		homepage.enterProductNameInSearchBox(dataProp.getProperty("invalidProduct"));
		homepage.searchButton();
		SearchPage searchpage = new SearchPage (driver);
		searchpage.retrieveInvalidProductWarningMessage();
		softassert.assertAll(); 
		
	}
	@Test(priority=3)
	public void searchWithNoProduct() {
		HomePage homepage = new HomePage(driver);
		homepage.searchButton();
		SearchPage searchpage = new SearchPage (driver);
		searchpage.retrieveInvalidProductWarningMessage();
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();	
	}
}
	
