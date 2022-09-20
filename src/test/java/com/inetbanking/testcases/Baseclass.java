package com.inetbanking.testcases;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.Readconfig;

public class Baseclass {
	Readconfig readconfig =new Readconfig();
	public String baseUrl=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException
	{
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
			driver=new ChromeDriver();
			
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver",readconfig.getEdgepath());
			driver=new EdgeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.firefox.driver",readconfig.getFirefoxpath());
			driver=new FirefoxDriver();
		}
		Thread.sleep(3000);
		driver.get(baseUrl);
		logger.info("url is opened");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	public void getScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"/screenshots/" +screenshotName +".png";
		File finaldestination=new File(destination);
		FileUtils.copyFile(source, finaldestination);
		System.out.println("Screenshot taken");
	}
	
	

}
