package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager; // log4j
import org.apache.logging.log4j.Logger;  // for log4j

public class BaseClass {

public WebDriver driver;
public Logger logger;
public Properties p;
	
	@BeforeClass(groups= {"sanity","regresssion", "master"})
	@Parameters({"OS","browser"})
	public void setup(String OS, String br) throws IOException
	{
		// loading properties file
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		
		//loading log4j file
		
		logger = LogManager.getLogger(this.getClass()); 
		
		// launching browser based on condition
		switch(br.toLowerCase()) 
		{
		 case "chrome": driver = new ChromeDriver();break;
		 case "edge": driver = new EdgeDriver();break;
		 default: System.out.println("No matching browser...");
		 return;
		
		}
		
		//driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups= {"sanity","regresssion", "master"})
	public void teardown()
	{
		driver.close();
	}
	
	public String randomeString() 
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	

	public String randomeNumber() 
	{
		String generatedString = RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public String randomAlphaNumeric() 
	{
		String str = RandomStringUtils.randomNumeric(3);
		String num = RandomStringUtils.randomAlphabetic(3);
		
		return(str+"@"+num);
	}
}
