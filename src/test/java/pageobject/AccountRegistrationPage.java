package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}
	
@FindBy(xpath="//label[normalize-space()='Male']")
WebElement male_button;

@FindBy(id="FirstName")
WebElement txt_firstname;

@FindBy(id="LastName")
WebElement txt_lastname;

@FindBy(name="Email")
WebElement txt_emailid;

@FindBy(id="Password")
WebElement txt_pswrd;

@FindBy(name="ConfirmPassword")
WebElement txt_confirmpswrd;

@FindBy(id="register-button")
WebElement btn_register;

@FindBy(xpath="//div[@class='result']")
WebElement confirmation_message;

       public void setMalebutton() 
       {
    	   male_button.click();
       }
       
       public void setFirstname(String fname) 
       {
    	   txt_firstname.sendKeys(fname);
       }
       
       public void setLasttname(String lname) 
       {
    	   txt_lastname.sendKeys(lname);
       }
       
       public void setEmailid(String emailid) 
       {
    	   txt_emailid.sendKeys(emailid);
       }
       
       public void setPassword(String Paswrd) 
       {
    	   txt_pswrd.sendKeys(Paswrd);
       }
       
       public void setConfirmpasswrd(String confirmPaswrd) 
       {
    	   txt_confirmpswrd.sendKeys(confirmPaswrd);
       }
       
       public void Register() 
       {
    	   btn_register.click();
       }
       
       public String ConfirmationMessage() {
    	   try {
    	        return (confirmation_message.getText());
    	       }
    	   catch(Exception e) 
    	   {
    		   return (e.getMessage());
    	   }
       }
}
