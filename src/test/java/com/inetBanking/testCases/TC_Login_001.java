package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_Login_001 extends BaseClass{
	
	
	@Test
	public void Login_Test() throws IOException {
		
		
		LoginPage lp = new LoginPage(driver);
		lp.Setusername(username);
		logger.info("Username Entered");
		lp.Setpswd(password);
		logger.info("password Entered");

		lp.ClickLogin();
		logger.info("Clicked login");

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			
			Assert.assertTrue(true);
			logger.warn("Test Passed");
		}
		
		else {
			captureScreen(driver, "Login_Test");
			Assert.assertTrue(false);
			logger.info("Test Failed");
			

		}
	}

}
