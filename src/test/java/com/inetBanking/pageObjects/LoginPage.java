package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	 public LoginPage(WebDriver rdriver) {
		 
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);          //Initializes current driver
	}

	 @FindBy(name = "uid")
	 WebElement txtuname;
	 
	 @FindBy(name = "password")
	 WebElement txtpwd;
	 
	 @FindBy(name = "btnLogin")
	 WebElement btnLogin;
	 
	 @FindBy(xpath = "//a[normalize-space()='Log out']")
	 WebElement logout;
	 
	public void Setusername(String uname) {
		txtuname.sendKeys(uname);
	}
	
	public void Setpswd(String upwd) {
		txtpwd.sendKeys(upwd);

	}
	public void ClickLogin() {
		btnLogin.click();
	}
	
	public void logoutbtn() {
		logout.click();
	}
}
