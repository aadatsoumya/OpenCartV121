package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement lnkMyaccount;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement lnkRegister;

	@FindBy(xpath = "//a[text()='Login']")
	WebElement lnkLogin;

	public void clickMyAccount() {

		wait.until(ExpectedConditions.elementToBeClickable(lnkMyaccount)).click();

	}

	public void clickRegister() {

		wait.until(ExpectedConditions.elementToBeClickable(lnkRegister)).click();
	}

	public void clickLogin() {

		wait.until(ExpectedConditions.elementToBeClickable(lnkLogin)).click();
	}

}
