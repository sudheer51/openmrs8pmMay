package org.h2k.openmrs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	//parameterized constructor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public boolean login(String username,String password)
	{
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click(); 
		return true;
	}
}
