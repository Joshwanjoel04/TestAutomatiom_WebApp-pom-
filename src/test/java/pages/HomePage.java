package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class HomePage {
	WebDriver driver;
	@FindBy(css = "a#nav-link-accountList>span>span")
	WebElement innitialDownarrow;
	@FindBy(linkText = "Start here.")
	WebElement StarthereLink;

	public HomePage(WebDriver driver ) {
		this.driver =driver;
		// TODO Auto-generated constructor stub
	}
	@Test
	public void clickSignup()
	{
	Actions a = new Actions(driver);
	a.moveToElement(innitialDownarrow).build().perform();
	StarthereLink.click();
	
	}

}
