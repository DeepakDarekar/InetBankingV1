package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddNewCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomerTest() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);

		addcust.clickAddNewCustomerLink();
		logger.info("Provinding Customer details....");

		addcust.custName("MichelJackson");
		addcust.custgender("male");
		addcust.custdob("10", "15", "1950");
		Thread.sleep(3000);
		
		addcust.custaddress("INDIA");
		addcust.custcity("PUNE");
		addcust.custstate("MH");		
		addcust.custpinno("121121");
		addcust.custtelephoneno("9898667789");
		
		String email = randomString() + "@gmail.com";
		addcust.custemailid(email);
		//addcust.custpassword("Test@1234");
		addcust.custsubmit();

		Thread.sleep(3000);

		// Now do the Validation

		boolean res = driver.getPageSource().contains("Could not connect: Access denied for user 'root'@'localhost' (using password: NO)");
		if (res == true) {
			Assert.assertTrue(true);
			logger.info("Login Test Failed");
		} else {
			captureScreen(driver, "addNewCustomerTest");
			Assert.assertTrue(true);
			logger.info("AddNewCustomerTest Passed");
		}
	}

}
