package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{
	
	WebDriver driver;
	
	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
	}
	           @FindBy(xpath="(//div[@class=\"title\"])[1]") 
                WebElement msg_heading;
	
              @FindBy(xpath="//a[normalize-space()='Log out']")
                WebElement link_Logout;
              
              public boolean isMyAccountPageExists() 
              {
            	  try 
            	  {
            		  return (msg_heading.isDisplayed());  
            	  }
            	  catch(Exception e)
            	  {
            		  return(false);
            	  }
              }
              
              public void clickLogout() 
              {
            	  link_Logout.click();
              }
}
