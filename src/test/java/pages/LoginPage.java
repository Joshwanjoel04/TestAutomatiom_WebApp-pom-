package pages;




import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import org.testng.annotations.Test;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;




public class LoginPage {
	
	@FindBy(how = How.ID, using = "ap_customer_name")
	WebElement customerNametextBox;
	@FindBy(how = How.ID, using = "ap_phone_number")
	WebElement phoneNumbertextBox;
	@FindBy(how=How.CSS,using=".a-button-text.a-declarative")
	WebElement contryCodeButton;
	@FindBy(how=How.XPATH,using="//ul[@role='application']//li//a[text()='United States +1']")
	WebElement contryCode;
	@FindBy(how = How.ID, using = "ap_email")
	WebElement emailIDTextBox;
	@FindBy(how=How.ID,using="ap_password")
	WebElement passwordtextBox;
	@FindBy(how=How.ID,using="continue")
	WebElement continueButton;
	@FindBy(how=How.ID,using="auth-pv-enter-code")
	WebElement OtpTextBox;
	@FindBy(how=How.ID,using="auth-verify-button")
	WebElement OtpverificationButton;
	
	
	WebDriver driver;
	String a,b;
	int c,i=0;
	static String ACCOUNT_SID;
	static String AUTH_TOKEN;

	@Test
	public void readData() throws Exception
	{
		File readdata=new File ("C:\\Users\\JOSH\\Desktop\\Auth and SID.txt");
		BufferedReader br = new BufferedReader(new FileReader(readdata));
		String ReceivedValaue ;
		while ((ReceivedValaue= br.readLine())!= null)
		{
			System.out.println(ReceivedValaue);
			//c = ReceivedValaue.length();
			String[] a =ReceivedValaue.split("=", 2);
			// a = ReceivedValaue.substring(0,73);
				//b= ReceivedValaue.substring(118,153);
			for(String value :a)
			{
				
				if(i==1)
				{
					ACCOUNT_SID=value;
					System.out.println("value"+(i)+ACCOUNT_SID);
				}
				if(i==3)
				{
					AUTH_TOKEN=value;
					System.out.println("value"+(i)+AUTH_TOKEN);
				}
				
				i++;
				
				
			}
			
			
			
		
		}
		
	
		
	

	}


	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	@Test
	public void SigninNewUser()
	{
		customerNametextBox.sendKeys("joelfern");
		contryCodeButton.click();
		contryCode.click();
		 phoneNumbertextBox.sendKeys("2055709330");
		// emailIDTextBox.sendKeys("joelfern2@gmail.com");
		 passwordtextBox.sendKeys("Joshjoel@123");
		 continueButton.click();
		 OtpTextBox.sendKeys(otpRecived());
		 OtpverificationButton.click();
		
		

	}
	public static String otpRecived()
	{
		 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
			String OtpRecived= getMessage();
			System.out.println(OtpRecived);
			String splitOtp= OtpRecived.replaceAll("[^-?0-9]+", " ");
			return splitOtp;
		
	}
	
	public static String getMessage() {
		return getMessages().filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
				.filter(m -> m.getTo().equals("+12055709330")).map(Message::getBody).findFirst()
				.orElseThrow(IllegalStateException::new);
	}

	private static Stream<Message> getMessages() {
		// TODO Auto-generated method stub
		ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
		return StreamSupport.stream(messages.spliterator(), false);
	}
	

}
