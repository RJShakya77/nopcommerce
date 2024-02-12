package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(id="Email")
WebElement txt_email;


@FindBy(name="Password")
WebElement txt_password;

@FindBy(xpath="//button[normalize-space()='Log in']")
WebElement btn_LogIn;


public void setEmailid(String emailid) 
   {
	txt_email.sendKeys(emailid);
   }

public void setPassword(String password) 
{
	txt_password.sendKeys(password);
}

public void clickLogin() 
{
	btn_LogIn.click();
}

}
