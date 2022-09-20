package com.inetbanking.utilities;
//This Listener class is used to generate reports.
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testcontext)
	{
		String dateName=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+dateName+".html";
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		
		extent=new ExtentReports();// create  all information about test cases
		
		extent.attachReporter(htmlreporter); //attach report for test cases
		extent.setSystemInfo("hostname", "localhost"); // host name is key and localhost is value
		extent.setSystemInfo("OS","Windows");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("tester", "Viraj");
		
		htmlreporter.config().setDocumentTitle("InetBanking Test Project");//title of the report
		htmlreporter.config().setReportName("Functional Automation Report");//name of the report
		htmlreporter.config().setTheme(Theme.DARK);//theme

		
	}
	public void onTestSuccess(ITestResult tr)
	{
		test=extent.createTest(tr.getName());//create new entry in the report
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));//send the pass information
	}
	public void onTestFailure(ITestResult tr)
	{
		test=extent.createTest(tr.getName());//create a new entry in the report
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));// send failed information
		String screenshotpath=System.getProperty("user.dir")+"\\screenshots\\" +tr.getName()+".png";
		File f=new File(screenshotpath);
	
		if(f.exists())
		{
			try {
				test.fail("Screenshot is below:"+test.addScreenCaptureFromPath(screenshotpath));
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
				
			}
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		test=extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		
	}
	public void onFinish(ITestContext testcontext)
	{
		extent.flush();
	}
}
