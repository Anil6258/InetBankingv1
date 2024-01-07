package com.inetBanking.testCases;


import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomertest_003 extends BaseClass{
	
	
	@Test
	public void addNewcustomertest() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.Setusername(username);
		logger.info("Username provided");
		lp.Setpswd(password);
		logger.info("password provided");
		lp.ClickLogin();
		logger.info("Clicked login button");
		Thread.sleep(3000);
		
		AddCustomerPage addcst = new AddCustomerPage(driver);
		
		addcst.clickAddnewcustomer();
		logger.info("Clicked on Addnewcustomer");
		addcst.AddcustomerName("Thnoodel");
		logger.info("Entered the newcustomername");
		addcst.selectGndr("male");
		logger.info("Gender male is selected");
		addcst.SetDob("10", "12", "2000");
		logger.info("dob is selected");
		Thread.sleep(3000);
		addcst.Setaddrs("INDIA");
		logger.info("country entered");
		addcst.Setcity("BEN");
		logger.info("city entered");
		addcst.Setstate("KAR");
		logger.info("state entered");
		addcst.Setpin("500700");
		logger.info("pin entered");
		addcst.Setphone("90991997760");
		logger.info("phone entered");
		String email = randomsting()+"@gmail.com";
		addcst.Setemail(email);
		logger.info("email entered");
		addcst.Setpswd("poiu");
		logger.info("password entered");
		addcst.Clicksubmitbtn();
		logger.info("clicked submit");
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
	
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("Test is Passed");
		}
		else {
			captureScreen(driver,"addNewcustomertest");
			Assert.assertTrue(false);
			logger.warn("Test is Failed");
			
		}
	}


}
