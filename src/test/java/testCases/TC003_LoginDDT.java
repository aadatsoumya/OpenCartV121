package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verifyLoginDDT(String email, String pswd, String exp) {
		logger.info("***Starting TC003_LoginDDT***");
		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("***Clicked on My Account Link***");
			hp.clickLogin();
			logger.info("***Clicked on Login Link***");

			LoginPage loginPage = new LoginPage(driver);
			logger.info("***Providing Login details***");
			loginPage.setEmail(email);
			loginPage.setPasssword(pswd);
			loginPage.clickLogin();

			MyAccountPage myAccount = new MyAccountPage(driver);
			logger.info("***Verifying MyAccount Page***");
			boolean targetPage = myAccount.isMyAccountPageExists();

			if (exp.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					myAccount.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					myAccount.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("***Finished  TC003_LoginDDT***");
	}
}
