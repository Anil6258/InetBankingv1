package com.inetBanking.testCases;



import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPswd();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {
		logger = LogManager.getLogger("netBanking");
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
		driver = new ChromeDriver();
		}
		if(browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver",readconfig.getedgepath());
			driver = new EdgeDriver();
		}
		if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getfirfoxpath());
			driver = new FirefoxDriver();
		}
		driver.get(baseURL);
		logger.info("URL is opened");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	  
	  
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("ScreenShot taken");
	}
	public String randomsting() {
		String randomalpha = RandomStringUtils.randomAlphabetic(6);
		return(randomalpha);
	}
}

