package org.h2k.util;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
//Shortcut for importing the packages ctrl+shit+o
public class TestBase {
 
		protected WebDriver driver;
		@AfterTest
		public void closeBrowser()
		{
			driver.close();
		}
		@Parameters({"browserType","url"})
		@BeforeTest
		public void invokeBrowser(String browserType,String url)
		{
			if(browserType.equals("FF"))
			{
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browserType.equals("CH"))
			{
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();
			}
			else
			{
				System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				/**
				 * 1. zoom should be set to 100%
				 * 2. Enable the protected mode for all the 4 security zones.
				 */
			}
			driver.get(url);
  
	}
	public  static String generateRandomNumber()
	{
		Random rnd = new Random();
		int i = 99+rnd.nextInt(100);
		System.out.println(i);
		
		//ASCII
		//random upper case
		
		char ch = (char)(65+rnd.nextInt(26));
		System.out.println(ch);
		
		return  (ch+""+i).toString();
	}
}
