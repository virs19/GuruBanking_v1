package com.inetbanking.testcases;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Loginpageobjects;



public class TC_Logintdd_002 extends Baseclass
{
	@Test(dataProvider="guru99logindata")
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
		
		Loginpageobjects lp=new Loginpageobjects(driver);
		lp.setUsername(user);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}

	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	

	  @DataProvider(name="guru99logindata")
	  public Object[][] readExcel() throws Exception 
	 {
		 
		  String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testdata/Logindata.xlsx";
		  int rownum=XUtils.getRowCount(path,"Sheet1");
		  int colcount=XUtils.getCellCount(path, "Sheet1", 1);
		  String logindata[][]=new String[rownum][colcount];
			
			for(int i=1;i<=rownum;i++)
			{
				for(int j=0;j<colcount;j++)
				{
					logindata[i-1][j]=XUtils.getCellData(path,"Sheet1", i,j);//1 0
				}
					
			}
		return logindata;
	}
		
		  
		  
		  
}
	  
	
	
	
	
	

