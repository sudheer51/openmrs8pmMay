package org.h2k.openmrs.tests;

import org.h2k.openmrs.pages.LoginPage;
import org.h2k.openmrs.pages.ManageServiceTypesPage;
import org.h2k.util.TestBase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ServiceTypeTests  extends TestBase{

	@Parameters({"url","username","password"})
	@Test
	public void addServiceTypeTests(String url,String username,String password)
	{
		
		LoginPage lPage = new LoginPage(driver);
		lPage.login(username, password);
		ManageServiceTypesPage svcTypePage = new ManageServiceTypesPage(driver);
		String svcName = TestBase.generateRandomNumber();
		System.out.println("Adding the Service Name::" + svcName);
		
		//add service Type
		svcTypePage.addServiceType(svcName);

		//verify Service Type
		boolean result = svcTypePage.verifyServiceType(svcName);
		Assert.assertTrue(result);
	}




}
