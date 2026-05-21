package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	public void verifyAccountRegistration() {

		logger.info("***Starting TC001_AccountRegistrationTest***");
		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("***Clicked on My Account Link***");
			hp.clickRegister();
			logger.info("***Clicked on Register Link***");

			AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
			logger.info("***Providing customer details***");
			regPage.setFirstName("SAI");
			regPage.setLastName("RAM");
			regPage.setEmail("sai" + Math.random() + "@gmail.com");
			regPage.settelephone("9876543210");
			regPage.setPassword("Sai@123");
			regPage.setConfPassword("Sai@123");
			regPage.setSubscribe();
			regPage.setAgree();
			regPage.clickContinue();
			String confMsg = regPage.getConfirmationMsg();
			logger.info("***Validating expected message***");
			if (confMsg.equals("Your Account Has Been Created!")) {

				logger.info("***TC001_AccountRegistrationTest passed***");
			} else {
				logger.error("***Test failed***");
				logger.debug("***Debug logs***");
				Assert.fail();
			}
			// Assert.assertEquals(confMsg, "Your Account Has Been Created!");
		} catch (Exception e) {
			logger.info(e.getMessage());

		}

		logger.info("***Finished TC001_AccountRegistrationTest***");
	}
}
