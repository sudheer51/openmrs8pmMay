package org.h2k.openmrs.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageServiceTypesPage {
	WebDriver driver;
	public ManageServiceTypesPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void navigateToManageServiceTypes()
	{
//		appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension
//		appointmentschedulingui-manageAppointmentTypes-app
	}
	public boolean addServiceType(String svcType)
	{ 
			//Add Service Type
			driver.findElement(By.xpath(".//*[@id='content']/div/div[1]/button")).click();
			driver.findElement(By.id("name-field")).clear();
			driver.findElement(By.id("name-field")).sendKeys(svcType);
			driver.findElement(By.id("duration-field")).sendKeys("30");
			driver.findElement(By.id("save-button")).click();
			System.out.println("After for loop");
			return true; 
	}
	public boolean verifyServiceType(String svcType)
	{
		//Verify Service Type
		List<WebElement> trList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable']/tbody/tr/td[1]"));
		List<WebElement> pagesList =   driver.findElements(By.xpath(".//*[@id='appointmentTypesTable_paginate']/span/a"));
		outer:
		for(int i=0;i<pagesList.size();i++)
		{
			for(int j=0;j<trList.size();j++)
			{
				System.out.println(trList.get(j).getText());
				if(trList.get(j).getText().trim().contains(svcType))
				{
					System.out.println("Service Name Found");
					break outer;
				}
			}
			pagesList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable_paginate']/span/a"));
			pagesList.get(i).click();
			trList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable']/tbody/tr/td[1]"));
		}
		return true;
	}
	public boolean deleteServiceType(String svcType)
	{
		List<WebElement> trList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable']/tbody/tr/td[1]"));
		List<WebElement> pagesList =   driver.findElements(By.xpath(".//*[@id='appointmentTypesTable_paginate']/span/a"));

		outer:
			for(int i=0;i<pagesList.size();i++)
			{
				for(int j=0;j<trList.size();j++)
				{
					System.out.println(trList.get(j).getText());
					if(trList.get(j).getText().trim().contains("Mental Health"))
					{
						System.out.println("Service Name Found in the Row Number::"+(j+1));
						System.out.println("Service Name Found");
						System.out.println("Xpath for Deleting an Item::"+""
								+ ".//*[@id='appointmentTypesTable']//tr["+(j+1)+"]/td[4]//i[@id='appointmentschedulingui-delete-"+trList.get(j).getText()+"']");
						driver.findElement(By.xpath(""
								+ ".//*[@id='appointmentTypesTable']//tr["+(j+1)+"]/td[4]//i[@id='appointmentschedulingui-delete-"+trList.get(j).getText()+"']")).click();

						List<WebElement> yesButtonList = driver.findElements(By.xpath(".//*[@id='delete-appointment-type-dialog']/div[2]/button[1]"));
						for(int k=0;k<yesButtonList.size();k++)
						{
							try{
								if(yesButtonList.get(k).isDisplayed())
								{
									System.out.println("Clicked on Delete Button" + (k+1));
									yesButtonList.get(k).click();
									break outer;
								}
							}
							catch(Exception e)
							{
								System.out.println("Delete Button not Displayed" + e.getMessage());
							}

						}
						break outer;
					}
				}
				pagesList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable_paginate']/span/a"));
				pagesList.get(i).click();
				trList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable']/tbody/tr/td[1]"));
			}
		System.out.println("After for loop");
		return true;
	}
}
