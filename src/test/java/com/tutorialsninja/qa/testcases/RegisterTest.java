package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.testBase.TestBase;
import com.tutorialsninja.qa.utilities.Utils;

public class RegisterTest extends TestBase{

	public RegisterTest() throws Exception {
		super();
		
	}

	public class LoginTest {
		
		public WebDriver driver;
		SoftAssert softassert = new SoftAssert();
		
		@BeforeMethod
		public void setup() {
			driver = openApplication(prop.getProperty("browser"));
			HomePage homepage = new HomePage(driver);
			homepage.clickOnMyAccountLink();
			homepage.selectRegisterOption();	
		 
		}

		@Test (priority = 1)
		public void registerAccountWithMandatoryFields() {
			RegisterPage registerpage = new RegisterPage(driver);
			registerpage.enterFirstNameField(dataProp.getProperty("firstname"));
			registerpage.enterLastNameField(dataProp.getProperty("lastname"));
			registerpage.enterEmailField(Utils.emailWithDateTimeStamp());
			registerpage.enterTelephoneField(dataProp.getProperty("telephone"));
			registerpage.enterPasswordField(prop.getProperty("validPassword"));
			registerpage.enterConfirmPasswordField(prop.getProperty("validPassword"));
			registerpage.checkPrivacyPolicy();
			registerpage.clickOnContinueButton();
			AccountSuccessPage accountsuccesspage = new AccountSuccessPage(driver);
			String actualMessage = accountsuccesspage.retrieveAccountSuccessMessage();
			String expectedMessage = dataProp.getProperty("accountSuccessMessage");
			softassert.assertTrue(actualMessage.equals(expectedMessage));
			softassert.assertAll();
		}
		@Test (priority = 2)
		public void registerAccountWithExistingEmail() {
			RegisterPage registerpage = new RegisterPage(driver);
			registerpage.enterFirstNameField(dataProp.getProperty("firstname"));
			registerpage.enterLastNameField(dataProp.getProperty("lastname"));
			registerpage.enterEmailField(prop.getProperty("validEmail"));
			registerpage.enterTelephoneField(dataProp.getProperty("telephone"));
			registerpage.enterPasswordField(prop.getProperty("validPassword"));
			registerpage.enterConfirmPasswordField(prop.getProperty("validPassword"));
			registerpage.clickOnNewsLetterRadioButton();
			registerpage.checkPrivacyPolicy();
			registerpage.clickOnContinueButton();
			String actualWarningMessage = registerpage.retrieveDuplicateEmailWarning();
			String expectedWarningMessage = dataProp.getProperty("duplicateEmailMessage");
			softassert.assertTrue(actualWarningMessage.equals(expectedWarningMessage));
			softassert.assertAll();
			
		}
		
		@Test (priority = 3)
		public void registerAccountWithAllFields() {
			RegisterPage registerpage = new RegisterPage(driver);
			registerpage.enterFirstNameField(dataProp.getProperty("firstname"));
			registerpage.enterLastNameField(dataProp.getProperty("lastname"));
			registerpage.enterEmailField(Utils.emailWithDateTimeStamp());
			registerpage.enterTelephoneField(dataProp.getProperty("telephone"));
			registerpage.enterPasswordField(prop.getProperty("validPassword"));
			registerpage.enterConfirmPasswordField(prop.getProperty("validPassword"));
			registerpage.clickOnNewsLetterRadioButton();
			registerpage.checkPrivacyPolicy();
			registerpage.clickOnContinueButton();
			AccountSuccessPage accountsuccesspage = new AccountSuccessPage(driver);
			String actualMessage = accountsuccesspage.retrieveAccountSuccessMessage();
			String expectedMessage = dataProp.getProperty("accountSuccessMessage");
			softassert.assertTrue(actualMessage.equals(expectedMessage));
			softassert.assertAll();
			
		}
		@Test (priority = 4)
		public void registerAccountWithNoFields() {
			RegisterPage registerpage = new RegisterPage(driver);
			registerpage.clickOnContinueButton();
			
			String actualPrivacyPolicyWarningMessage = registerpage.retrievePrivacyPolicyWarning();
			String expectedPrivacyPolicyWarningMessage = dataProp.getProperty("privacyPolicyWarningMessage");
			softassert.assertTrue(actualPrivacyPolicyWarningMessage.contains(expectedPrivacyPolicyWarningMessage));

			String actualFirstNameWarningMessage = registerpage.retrieveFirstNameWarning();
			String expectedFirstNameWarningMessage = dataProp.getProperty("firstNameWarningMessage");
			softassert.assertEquals(actualFirstNameWarningMessage, expectedFirstNameWarningMessage);

			String actualLastNameWarningMessage = registerpage.retrieveLastNameWarning();
			String expectedLastNameWarningMessage = dataProp.getProperty("lastNameWarningMessage");
			softassert.assertEquals(actualLastNameWarningMessage, expectedLastNameWarningMessage);

			String actualEmailWarningMessage = registerpage.retrieveEmailWarning();
			String expectedEmailWarningMessage = dataProp.getProperty("emailWarningMessage");
			softassert.assertEquals(actualEmailWarningMessage, expectedEmailWarningMessage);

			String actualTelephoneWarningMessage = registerpage.retireveTelephoneWarning();
			String expectedTelephoneWarningMessage = dataProp.getProperty("telephoneWarningMessage");
			softassert.assertEquals(actualTelephoneWarningMessage, expectedTelephoneWarningMessage);

			String actualPasswordWarningMessage = registerpage.retirevePasswordWarning();
			String expectedPasswordWarningMessage = dataProp.getProperty("passwordWarningMessage");
			softassert.assertEquals(actualPasswordWarningMessage, expectedPasswordWarningMessage);

			softassert.assertAll();
		}
		@AfterMethod
		public void tearDown() {
			driver.quit();
			
		}
		
		}
	}
