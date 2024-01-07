package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using="//a[normalize-space()='New Customer']")
	WebElement lnkNewCustomer;
	
	@FindBy(how = How.NAME, using="name")
	WebElement txtcstmrName;
	
	@FindBy(how = How.NAME, using="rad1")
	WebElement rGender;
	
	@FindBy(how = How.ID_OR_NAME, using="dob")
	WebElement txtdob;
	
	@FindBy(how = How.NAME, using="addr")
	WebElement txtaddrs;
	
	@FindBy(how = How.NAME, using="city")
	WebElement txtcity;
	
	@FindBy(how = How.NAME, using="state")
	WebElement txtstate;
	
	@FindBy(how = How.NAME, using="pinno")
	WebElement txtpinno;
	
	@FindBy(how = How.NAME, using="telephoneno")
	WebElement txtphoneno;
	
	@FindBy(how = How.NAME, using="emailid")
	WebElement txtemail;
	
	@FindBy(how = How.NAME, using="password")
	WebElement txtpwd;
	
	@FindBy(how = How.NAME, using="sub")
	WebElement txtsubmit;
	
	public void clickAddnewcustomer() {
		lnkNewCustomer.click();
	}
	
	public void AddcustomerName(String uname) {
		txtcstmrName.sendKeys(uname);
	}
	
	public void selectGndr(String cgender) {
		rGender.click();
	}
	
	public void SetDob(String mm, String dd, String yyyy ) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yyyy);
	}
	
	public void Setaddrs(String addrs) {
		txtaddrs.sendKeys(addrs);
	}
	
	public void Setcity(String citynm) {
		txtcity.sendKeys(citynm);
	}
	
	public void Setstate(String statenm) {
		txtstate.sendKeys(statenm);
	}
	
	public void Setpin(String pin) {                         
		txtpinno.sendKeys(pin);                        //if num is int convert to string String.valueof
	}
	
	public void Setphone(String phonnum) {
		txtphoneno.sendKeys(phonnum);
	}
	
	public void Setemail(String emailad) {
		txtemail.sendKeys(emailad);
	}
	
	public void Setpswd(String pswd) {
		txtpwd.sendKeys(pswd);
	}
	
	public void Clicksubmitbtn() {
		txtsubmit.click();
	}
	

	
	
	
}
