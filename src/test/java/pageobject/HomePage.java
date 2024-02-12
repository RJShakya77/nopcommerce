package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
@FindBy(xpath="//a[normalize-space()='Register']")
WebElement link_Register;

@FindBy(xpath="(//a[normalize-space()='My account'])[1]")
WebElement link_MyAccount;

@FindBy(xpath="//a[normalize-space()='Log in']")
WebElement link_Login;


         public void clickRegister() 
           {
        	 link_Register.click();
	         }
         
         public void clickMyAccount() 
         {
        	 link_MyAccount.click();
	     }
         
         public void clickLogin() 
         {
        	 link_Login.click();
	     }

}
