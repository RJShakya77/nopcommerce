package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.AccountRegistrationPage;
import pageobject.HomePage;

public class TC_001_AccountRegistrationPage extends BaseClass {

	
	@Test(groups={"sanity", "master"})
	
	public void verify_account_registration() 
	{
		logger.info("***TC_001_AccountRegistrationPage started********");
	   try {
		HomePage hp = new HomePage(driver);
	    
	    hp.clickRegister();
	    
	    logger.info("***clicked on Register link********");
	    
	    logger.info("Entering customer details");
	    AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
	    
	    regpage.setMalebutton();
	    regpage.setFirstname(randomeString().toUpperCase());
	    regpage.setLasttname(randomeString().toUpperCase());
	    regpage.setEmailid(randomeString()+"@gmail.com");
	    
	    String password = randomAlphaNumeric();
	    regpage.setPassword(password);
	    regpage.setConfirmpasswrd(password);
	    
	    regpage.Register();
	    logger.info("clicked on Register...");
	    
	    String confmsg =regpage.ConfirmationMessage();
	    
	    logger.info("Validating expected message...");  
	    
	    if(confmsg.equals("Your registration completed")) 
	    {
	    	logger.info("test passed");
	       Assert.assertTrue(true);	
	    }
	    else 
	    {
	    	logger.error("Test failed...");
	    }
	    
	   
	}
	   catch(Exception e) 
	   {
		   logger.error("test failed");
		   Assert.fail();
	   }
	    logger.info("**** Test Case finished ******");
	    
	}
	
	
}
