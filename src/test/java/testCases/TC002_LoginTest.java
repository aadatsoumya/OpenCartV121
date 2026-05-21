package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void verifyLogin() {

		logger.info("***Starting TC002_LoginTest***");
		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("***Clicked on My Account Link***");
			hp.clickLogin();
			logger.info("***Clicked on Login Link***");

			LoginPage loginPage = new LoginPage(driver);
			logger.info("***Providing Login details***");
			loginPage.setEmail(p.getProperty("userName"));
			loginPage.setPasssword(p.getProperty("password"));
			loginPage.clickLogin();

			MyAccountPage myAccount = new MyAccountPage(driver);
			logger.info("***Verifying MyAccount Page***");
			boolean targetPage = myAccount.isMyAccountPageExists();
			if (targetPage == true) {
				logger.info("***TC002_LoginTest Passed***");
			} else {
				logger.error("***Test failed***");
				logger.debug("***Debug logs***");
				Assert.fail();
			}
			
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

}
