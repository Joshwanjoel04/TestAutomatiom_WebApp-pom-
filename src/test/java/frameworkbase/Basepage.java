package frameworkbase;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import pages.AddUserAddress;
import pages.BrowseProduct;
//import pages.HomePage;
//import pages.LoginPage;
import pages.SignInPage;

public class Basepage {
	WebDriver driver;
	@Test
	public void BrowserInitialization() throws Exception {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium Softwares\\selenium_Work_Space\\WebAppTest\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
//		HomePage credentialinfo = PageFactory.initElements(driver, HomePage.class);
//		credentialinfo.clickSignup();
//		LoginPage pageCredentials = PageFactory.initElements(driver, LoginPage.class);
//		pageCredentials.SigninNewUser();
//		BrowseProduct productSelectction = PageFactory.initElements(driver, BrowseProduct.class);
//		productSelectction.selectProduct();
		SignInPage signinCredentials=PageFactory.initElements(driver, SignInPage.class);
		signinCredentials.signin();
		BrowseProduct productSelectction = PageFactory.initElements(driver, BrowseProduct.class);
		productSelectction.selectProduct();
		AddUserAddress addressEntered  = PageFactory.initElements(driver, AddUserAddress.class);
		addressEntered.adressCredentials();
	
		
	}
	



}
