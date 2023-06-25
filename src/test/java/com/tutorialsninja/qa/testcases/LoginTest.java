package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.testBase.TestBase;
import com.tutorialsninja.qa.testData.ExcelData;
import com.tutorialsninja.qa.utilities.Utils;

public class LoginTest extends TestBase{
	
	public LoginTest() throws Exception {
		super();
		
		 
	}
	public WebDriver driver;
	SoftAssert softassert = new SoftAssert();
	 
	
	
	@BeforeMethod
	public void setup() {
		
		driver = openApplication(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccountLink();
		homepage.selecLoginOption();
		
	}
	@Test(priority=1, dataProvider = "TN", dataProviderClass = ExcelData.class)
	public void verifyLoginWithValidCredentials(String email, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailinEmailTextBoxField(email);
		loginpage.enterPasswordinPasswordTextBoxField(password);
		loginpage.clickOnLoginButton();
		AccountPage accountpage = new AccountPage(driver);
		softassert.assertTrue(accountpage.verifyLoginLinkIsDisplayed());
		softassert.assertAll();
		
	
}
	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailinEmailTextBoxField(Utils.emailWithDateTimeStamp());
		loginpage.enterPasswordinPasswordTextBoxField(dataProp.getProperty("invalidPassword"));
		loginpage.clickOnLoginButton();
		String acutalWarningMessage = loginpage.retrieveNoMatchPasswordWarningMessage();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordMismatchWarningMessage");
		softassert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage));
		softassert.assertAll();
		
			
	}
	@Test(priority=3)
	public void verifyLoginWithValidEmailInvalidPassword() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailinEmailTextBoxField(prop.getProperty("validEmail"));
		loginpage.enterPasswordinPasswordTextBoxField(dataProp.getProperty("invalidPassword"));
		loginpage.clickOnLoginButton();
		String acutalWarningMessage = loginpage.retrieveNoMatchPasswordWarningMessage();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordMismatchWarningMessage");
		softassert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage));
		softassert.assertAll();
		
	}
	@Test(priority=4)
	public void verifyLoginWithInvalidEmailValidPassword() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailinEmailTextBoxField(Utils.emailWithDateTimeStamp());
		loginpage.enterPasswordinPasswordTextBoxField(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
		String acutalWarningMessage = loginpage.retrieveNoMatchPasswordWarningMessage();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordMismatchWarningMessage");
		softassert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage));
		softassert.assertAll();
		
	}
	@Test(priority=5)
	public void verifyLoginWithNoCredentials() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickOnLoginButton();
		String acutalWarningMessage = loginpage.retrieveNoMatchPasswordWarningMessage();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordMismatchWarningMessage");
		softassert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage));
		softassert.assertAll();
		
}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
}