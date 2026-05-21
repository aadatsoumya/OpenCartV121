package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtCnfPassword;

	@FindBy(xpath = "//label[text()='Yes']")
	WebElement radioBtnSubscribe;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkboxAgree;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnContinue;

	@FindBy(xpath = "//div[@id='content']//h1")
	WebElement msgConfirm;

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void settelephone(String telephone) {
		txtTelephone.sendKeys(telephone);
	}

	public void setPassword(String pswd) {
		txtPassword.sendKeys(pswd);
	}

	public void setConfPassword(String pswd) {
		txtCnfPassword.sendKeys(pswd);
	}

	public void setSubscribe() {
		radioBtnSubscribe.click();
	}

	public void setAgree() {
		chkboxAgree.click();
	}

	public void clickContinue() {
		wait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	}

	public String getConfirmationMsg() {
		try {
			return msgConfirm.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
