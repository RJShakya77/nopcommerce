package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.MyAccountPage;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{

	
	@Test(dataProvider ="LoginData", dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String password, String exp) 
	{
		logger.info("***Starting TC_003_LoginDDT***");
try {	
	//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickLogin(); // login link
		
		LoginPage lp = new LoginPage(driver); 
		lp.setEmailid(email);
		lp.setPassword(password);
		lp.clickLogin(); // login button
		
		hp.clickMyAccount();
		logger.info("Clicked on the MyAccount  link");
	
	//My AccountPage
		MyAccountPage ma = new MyAccountPage(driver);
		
		boolean targetpage = ma.isMyAccountPageExists();
		
		if(exp.equals("Valid")) 
		 {
			if(targetpage==true) 
			  {
				ma.clickLogout();
				Assert.assertTrue(true);
			  }
			else 
			  {
				Assert.assertTrue(false);
			  }
		 }
		if(exp.equals("Invalid")) 
		 {
			if(targetpage==true) 
			  {
				ma.clickLogout();
				Assert.assertTrue(false);
			  }
			else 
			  {
				Assert.assertTrue(true);
			  }
		 }
     }
   catch(Exception e)
       {
    	 Assert.fail("An exception occurred: " + e.getMessage());
       }
            logger.info("***TC_003_LoginDDT finished***");
	}
	
}
