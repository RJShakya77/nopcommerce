package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.MyAccountPage;

public class TC_002_LoginTest extends BaseClass
{
	@Test(groups= {"regression", "master"})
	public void verify_login() 
	{
	
		logger.info("***Test Case Started***");
		logger.debug("Capturing application debug logs....");
		
	try {
		
		HomePage hp = new HomePage(driver);
		hp.clickLogin(); // login link
		logger.info("Clicked on the login link");
		
		
		
		LoginPage lp = new LoginPage(driver); 
		logger.info("Entering valid username and password");
		lp.setEmailid(p.getProperty("email"));
		lp.setPassword("Rajat@123");
		lp.clickLogin(); // login button
		logger.info("Clicked on login button");
		
		hp.clickMyAccount();
		logger.info("Clicked on the MyAccount  link");
		
		
		MyAccountPage ma = new MyAccountPage(driver);
		
		boolean targetpage = ma.isMyAccountPageExists();
		
		if(targetpage==true) 
		{
			Assert.assertTrue(true);
		}
		
		else 
		{
			logger.error("Login test failed");
			Assert.fail();
		}
		
	}
catch(Exception e) 
			
	     {
		     Assert.fail("Test failed");
	     }
		logger.info("LoginTest finished........");
	}

}
