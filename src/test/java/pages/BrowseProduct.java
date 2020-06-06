package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class BrowseProduct {
	WebDriver driver;
	@FindBy(how=How.ID,using="twotabsearchtextbox")
	WebElement searchTextbox;
	@FindBy(how=How.XPATH,using="//input[@type='submit'][@class='nav-input']")
	WebElement searchSymbol;
	@FindBy(xpath="//i[@class='a-icon a-icon-checkbox'][1]")
	WebElement xpathsofcustomselect1;
	@FindBy(xpath="(//i[@class='a-icon a-icon-checkbox'])[2]")
	WebElement xpathsofcustomselect2;
	@FindBy(xpath="(//i[@class='a-icon a-icon-checkbox'])[3]")
	WebElement xpathsofcustomselect3;
	@FindBy(xpath="(//i[@class='a-icon a-icon-checkbox'])[4]")
	WebElement xpathsofcustomselect4;
	@FindBy(how=How.CSS,using="#low-price")
	WebElement lowPricetextbox;
	@FindBy(how=How.CSS,using="#high-price")
	WebElement HighPriceTextbox;
	@FindBy(how=How.CSS,using="#a-autoid-1")
	WebElement goButton;
	@FindBy(xpath="//img[@class='s-image'][@data-image-index='11']")
	WebElement ShoeSelected;
	@FindBy(xpath="//span[@id='submit.add-to-cart']")     //select[@id='native_dropdown_selected_size_name']
	WebElement addtoCartButton;
	@FindBy(xpath="//select[@id='native_dropdown_selected_size_name']")     
	WebElement SizeSelect;

	public BrowseProduct(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
	}
	public void selectProduct() throws InterruptedException
	{
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		searchTextbox.sendKeys("nike sports shoes for men");
		searchSymbol.click();
		Thread.sleep(1000);
		xpathsofcustomselect1.click();
		Thread.sleep(1000);
		xpathsofcustomselect2.click();
		Thread.sleep(1000);
		xpathsofcustomselect3.click();
		Thread.sleep(1000);
		xpathsofcustomselect4.click();
		Thread.sleep(1000);
		lowPricetextbox.sendKeys("1000");
		Thread.sleep(1000);
		HighPriceTextbox.sendKeys("2500");
		goButton.click();
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		ShoeSelected.click();
//		Select size = new Select(SizeSelect);
//		size.selectByIndex(0);
//		addtoCartButton.click();
		
	}

}
