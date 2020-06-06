package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddUserAddress {
	WebDriver driver;
	@FindBy(css = "a#nav-link-accountList>span>span")
	WebElement innitialDownarrow;
	@FindBy(xpath = "//span[text()='Your Account']")
	WebElement youraccountLink;
	@FindBy(xpath = "(//h2[@class='a-spacing-none ya-card__heading--rich a-text-normal'])[4]")
	WebElement yourAdresslink;
	@FindBy(css = ".a-section.a-spacing-none.address-plus-icon.aok-inline-block")
	WebElement addAdressLogo;
	public Object adressCredentials;

	public AddUserAddress(WebDriver driver) {
		this.driver = driver;
	}

	public void adressCredentials() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions a = new Actions(driver);
		a.moveToElement(innitialDownarrow).build().perform();
		youraccountLink.click();
		yourAdresslink.click();
		addAdressLogo.click();

	}

}
