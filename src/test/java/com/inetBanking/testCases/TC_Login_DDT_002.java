package com.inetBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_Login_DDT_002 extends BaseClass {

	
	@Test(dataProvider="login")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.Setusername(user);
		logger.info("Username provided");
		lp.Setpswd(pwd);
		logger.info("password provided");
		lp.ClickLogin();
		logger.info("Clicked login button");
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
	
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
		logger.warn("login failed");
		
		}
		else
		{
		 lp.logoutbtn();
		 driver.switchTo().alert().accept();
		 driver.switchTo().defaultContent();
		 Assert.assertTrue(true);
		 logger.info("login passed");
		 captureScreen(driver, "loginDDT");
		
		}
		
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name = "login")
	
    String[][] getdata() throws IOException{
		
		String path=System.getProperty("user.dir") + "/src/test/java/com/inetBanking/testData/Logdata.xlsx";
		int runm = XLUtils.getRowCount(path, "Sheet1");
		int clnm = XLUtils.getCellCount(path,"Sheet1",1);
		
		String loginData[][] = new String[runm][clnm];
		
		for(int i=1;i<=runm;i++)
		{
			for(int j=0;j<clnm;j++) {
				
				loginData[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
			}
		}
		
		
	return loginData;
	}
	
	
	
}
