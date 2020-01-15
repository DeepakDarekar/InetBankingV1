package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {
		driver.get(baseURL);
		logger.info("URL IS Open Successfully");
	
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(userName);
		logger.info("Entered Valid UserName");
		lp.setPassword(password);
		logger.info("Entered Valid Password");
		lp.clickSubmit();
	
		//Assert.assertEquals(driver.getTitle(), "GTPL Bank Manager HomePage");
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage")){
			captureScreen(driver, "loginTest");
			Assert.assertTrue(true);
			logger.info("loginTest Passed");
		}else {
			Assert.assertTrue(false);
			logger.info("loginTest Failed");
			
		}
		
		
	}		
	
}
