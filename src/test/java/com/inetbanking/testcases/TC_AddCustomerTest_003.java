package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.AddNewCustomerpageobjects;
import com.inetbanking.pageobjects.Loginpageobjects;

public class TC_AddCustomerTest_003 extends Baseclass {

@Test
public void addNewCustomer() throws InterruptedException, Exception
{
	Loginpageobjects lp=new Loginpageobjects(driver);
	lp.setUsername(username);
	logger.info("entered username");
	lp.setPassword(password);
	logger.info("entered password");
	lp.clickSubmit();
	Thread.sleep(3000);
	
	AddNewCustomerpageobjects addcust= new AddNewCustomerpageobjects(driver);
	
	addcust.linkAddNewCustomer();

	
	Thread.sleep(5000);
	
	logger.info("Providing Customer details....");
	Thread.sleep(3000);
	addcust.customerName("xyz");
	Thread.sleep(3000);
	addcust.custgender("male");
	Thread.sleep(3000);
	addcust.custdob("12", "19", "1991");
	Thread.sleep(3000);
	addcust.cusAdd("india");
	Thread.sleep(3000);
	addcust.cusCity("brd");
	Thread.sleep(3000);
	addcust.cusState("guj");
	Thread.sleep(3000);
	addcust.cusPinno(390007);
	Thread.sleep(3000);
	addcust.cusTelephoneno("1234567890");
	Thread.sleep(3000);
	String email=randomString()+"@gmail.com";
	Thread.sleep(3000);
	addcust.cusEmailid(email);
	Thread.sleep(3000);
	addcust.cusPassword("12345");
	Thread.sleep(3000);
	addcust.cusSubmit();
	
	Thread.sleep(3000);
	logger.info("Validation started...");
	boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
	if(res==true)
	{
		
		logger.info("Test is passed");
		Assert.assertTrue(true);
	}
	else
	{
		logger.info("Test is failed");
		getScreenshot(driver,"addNewCustomer");
		Assert.assertFalse(false);
	}
}


}
