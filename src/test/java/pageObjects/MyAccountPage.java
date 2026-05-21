package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement msgheading;

	@FindBy(xpath = "//aside[@id='column-right']//div//a[text()='Logout']")
	WebElement lnkLogout;

	public boolean isMyAccountPageExists() {
		try {
			return msgheading.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickLogout() {

		wait.until(ExpectedConditions.elementToBeClickable(lnkLogout)).click();
	}

}
