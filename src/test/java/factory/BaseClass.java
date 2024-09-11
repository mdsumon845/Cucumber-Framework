
package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {

		 static WebDriver driver;
	     static Properties p;
	     static Logger logger;
	  	     
	public static WebDriver initilizeBrowser() throws IOException
	{
		if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//os
			if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
			    capabilities.setPlatform(Platform.WIN11);
			} else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
			    capabilities.setPlatform(Platform.MAC);
			} else {
			    System.out.println("No matching OS..");
			      }
			//browser
			switch (getProperties().getProperty("browser").toLowerCase()) {
			    case "chrome":
			        capabilities.setBrowserName("chrome");
			        break;
			    case "edge":
			        capabilities.setBrowserName("MicrosoftEdge");
			        break;
			    default:
			        System.out.println("No matching browser");
			     }
	       
	        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
		else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
			{
				switch(getProperties().getProperty("browser").toLowerCase()) 
				{
				case "chrome":
			        driver=new ChromeDriver();
			        break;
			    case "edge":
			    	driver=new EdgeDriver();
			        break;
			    default:
			        System.out.println("No matching browser");
			        driver=null;
				}
			}
		 driver.manage().deleteAllCookies(); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		 
		 return driver;
		 
	}
	
	public static WebDriver getDriver() {
			return driver;
		}

	public static Properties getProperties() throws IOException
	{		 
        FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
       		
        p=new Properties();
		p.load(file);
		return p;
	}
	
	public static Logger getLogger() 
	{		 
		logger=LogManager.getLogger(); //Log4j
		return logger;
	}
	
		
	public static String randomAlphaNumeric()
	{
	String str=RandomStringUtils.randomAlphabetic(5);
	 String num=RandomStringUtils.randomNumeric(10);
	return str+num;
	}
	
	
	 public  static String randomString() 
	 {
		String generatedString= RandomStringUtils.randomAlphabetic(10);
		return generatedString ;	 
	 }
	 
	 public static String randomNumber() 
	 {
		String generatedNumber= RandomStringUtils.randomNumeric(11);
		return generatedNumber ;	 
	 }
	 public static String tel() 
	 {
		String generatedNumber= RandomStringUtils.randomNumeric(11);
		return generatedNumber ;	 
	 }
	 
	 public static String pwd() 
	 {
		 String str= RandomStringUtils.randomAlphabetic(5);
		String num= RandomStringUtils.randomNumeric(3);
		return (str+"@"+num); 
	 }
	 
	 public static String email() 
	 {
		 String str= RandomStringUtils.randomAlphabetic(5);
		String num= RandomStringUtils.randomNumeric(3);
		return (str+num);	 
	 }
	 
	 public static String Address1() 
	 {
		String str= RandomStringUtils.randomAlphabetic(15);
		String num1= RandomStringUtils.randomNumeric(1);
		String num2= RandomStringUtils.randomNumeric(2);
		return (str+num1+"-"+num2);		 
	 }
	 
	 public static String Address2() 
	 {
		String str= RandomStringUtils.randomAlphabetic(15);
		String num1= RandomStringUtils.randomNumeric(1);
		String num2= RandomStringUtils.randomNumeric(3);
		return (str+num1+"-"+num2);		 
	 }
	 
	 public static String city() 
	 {
		String generatedString= RandomStringUtils.randomAlphabetic(15);
		return generatedString ;	 
	 }
	 
	 public static String postCode() 
	 {
		String num1= RandomStringUtils.randomNumeric(3);
		String num2= RandomStringUtils.randomNumeric(4);
		return (num1+"-"+num2);		 
	 }
	 
	 public static String firstname() 
	 {
		String generatedString= RandomStringUtils.randomAlphabetic(15);
		return generatedString ;	 
	 }
	 
	 public static String lastName() 
	 {
		String generatedString= RandomStringUtils.randomAlphabetic(15);
		return generatedString ;	 
	 }
	 
	 public static String fullName() 
	 {
		String generatedString= RandomStringUtils.randomAlphabetic(15);
		return generatedString ;	 
	 }
	 
	 public static String review() 
	 {
		String generatedString= RandomStringUtils.randomAlphabetic(200);
		return generatedString ;	 
	 }
	 
	 public static String comment() 
	 {
		String generatedString= RandomStringUtils.randomAlphabetic(200);
		return generatedString ;	 
	 }
	 
	 public static String CompanyName() 
	 {
		String generatedString= RandomStringUtils.randomAlphabetic(15);
		return generatedString ;	 
	 }
}
