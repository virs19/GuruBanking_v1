package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerpageobjects {

	WebDriver ldriver;
	
	public AddNewCustomerpageobjects(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how=How.XPATH, using = "//ul[@class='menusubnav']//a[text()='New Customer']")
	WebElement lnkAddNewCustomer;
	
	
	@FindBy(how=How.XPATH, using = "//tbody/tr[4]/td[2]/input[1]")
	WebElement txtCustomerName;
	
	
	@FindBy(how=How.NAME, using = "rad1")
	WebElement rdgender;
	
	
	@FindBy(how=How.NAME, using = "dob")
	WebElement txtdob;
	
	
	@FindBy(how=How.NAME, using="addr")
	WebElement txtaddress;
	
	
	@FindBy(how=How.NAME, using="city")
	WebElement txtcity;
	
	
	@FindBy(how=How.NAME,using="state")
	WebElement txtstate;
	
	
	@FindBy(how=How.NAME,using="pinno")
	WebElement txtpinno;
	
	
	@FindBy(how=How.NAME,using="telephoneno")
	WebElement txtphnno;
	
	
	@FindBy(how=How.NAME,using="emailid")
	WebElement txtemailid;
	
	
	@FindBy(how=How.NAME,using="password")
	WebElement txtpassword;
	
	@FindBy(how=How.NAME,using="sub")
	
	WebElement btnsubmit;
	
	public void linkAddNewCustomer()
	{
		lnkAddNewCustomer.click();
	
	}
	public void customerName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	
	}
	public void custgender(String gender)
	{
		rdgender.click();
	}
	public void custdob(String mm, String dd, String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	public void cusAdd(String caddress)
	{
		txtaddress.sendKeys(caddress);
	}
	public void cusCity(String ccity)
	{
		txtcity.sendKeys(ccity);
	}
	public void cusState(String state)
	{
		txtstate.sendKeys(state);
	}
	
	public void cusPinno(int cpinno)
	{
		txtpinno.sendKeys(String.valueOf(cpinno));
	}
	public void cusTelephoneno(String ctelephonno)
	{
		txtphnno.sendKeys(ctelephonno);
	}
	public void cusEmailid(String cemailid)
	{
		txtemailid.sendKeys(cemailid);
	}
	public void cusPassword(String cpassword)
	{
		txtpassword.sendKeys(cpassword);
	}
	public void cusSubmit()
	{
		btnsubmit.click();
	}
	
	
	
	
	
	
}
