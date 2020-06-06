package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SignInPage {
	@FindBy(css = "a#nav-link-accountList>span>span")
	WebElement innitialDownarrow;
	@FindBy(xpath = "//a//span[text()='Sign in'][@class='nav-action-inner'][1]")  
	WebElement signinButton;
	@FindBy(id = "ap_email") 
	WebElement signinPhonenumber;
	@FindBy(id = "continue") 
	WebElement continueButton;
	@FindBy(id = "ap_password") 
	WebElement passwordValue;
	@FindBy(id = "signInSubmit") 
	WebElement submitButton;
	WebDriver driver;
	public SignInPage(WebDriver driver) {
		this.driver =driver;
	}
	public void signin()
	{
	Actions a = new Actions(driver);
	a.moveToElement(innitialDownarrow).build().perform();
	signinButton.click();
	signinPhonenumber.sendKeys("2055709330");
	continueButton.click();
	passwordValue.sendKeys("Joshjoel@123");
	submitButton.click();
	
	}

}
