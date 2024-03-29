package com.inetBanking.utilities;

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
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Reporting extends TestListenerAdapter {
	
	 public ExtentSparkReporter htmlReporter;
     public ExtentReports extent;              //for environment 
     public ExtentTest logger;                //for test cases 
      
     public void onStart(ITestContext testContext) {
    	 
    	 String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //timestamp
    	 String repname = "Test-Report-"+timestamp+".html";  //filenme
    	 htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + repname); //location
    	 try {
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
    	 
    	 extent=new ExtentReports();
    	 
    	 extent.attachReporter(htmlReporter);
    	 extent.setSystemInfo("Host name", "localhost");
    	 extent.setSystemInfo("Environment", "QA");
    	 extent.setSystemInfo("user", "Anil");
    	 
    	 htmlReporter.config().setDocumentTitle("InetBanking Test Project");
    	 htmlReporter.config().setReportName("Functional Test Report");
    	 htmlReporter.config().setTheme(Theme.STANDARD);
    	 
     }
     
     public void onTestSuccess(ITestResult tr) {
    		 
    		 logger=extent.createTest(tr.getName());   //create new entry to report
    		 logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
    		 
    	 }
     
     public void onTestFailure(ITestResult tr) 
    	 {
    		 
    		 logger=extent.createTest(tr.getName());   //create new entry to report
    		 logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
    		 
    		 String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
    		 
    		 File f = new File(screenshotPath);
    		 
    		 if(f.exists())
    		 {
    		 logger.fail("Screenshot is below: " + logger.addScreenCaptureFromPath(screenshotPath));
    		 }
    		 
    	 }
     
     public void onTestSkipped(ITestResult tr) {
    	 
    	 logger=extent.createTest(tr.getName());   //create new entry to report
		 logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
   	 
    	 
     }
     public void onFinish(ITestContext testContext) {
    	 extent.flush();
     }
}
