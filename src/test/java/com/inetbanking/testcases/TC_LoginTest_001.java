package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Loginpageobjects;

public class TC_LoginTest_001 extends Baseclass{

	@Test
	public void loginTest() throws IOException {
		
		Loginpageobjects lp=new Loginpageobjects(driver);
		lp.setUsername(username);
		logger.info("entered username");
		lp.setPassword(password);
		logger.info("entered password");
		
		lp.clickSubmit();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("test is passed");
		}
		else
		{
			getScreenshot(driver,"loginTest");
			Assert.assertFalse(false);
			logger.info("test is failed");
		}
		
	}
	
	
}
