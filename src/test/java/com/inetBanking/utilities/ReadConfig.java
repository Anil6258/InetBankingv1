package com.inetBanking.utilities;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		
		File src = new File("./Configuration/config.properties");
		
		try {
			
			FileInputStream fis = new FileInputStream(src);          //reads the file
			pro = new Properties();
		    pro.load(fis);           //loads the complete file
		    
			
		}
		
		catch(Exception e){
			System.out.println("Execption is " + e.getMessage());
		}
		
	}
	
	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	public String getUsername() {
		String uname = pro.getProperty("username");
		return uname;
	}
	public String getPswd() {
		String pswod = pro.getProperty("password");
		return pswod;
	}
	public String getChromepath() {
		String chrompath = pro.getProperty("chromepath");
		return chrompath;
	}
	public String getedgepath() {
		String epath = pro.getProperty("edgepath");
		return epath;
	}
	public String getfirfoxpath() {
		String firepath = pro.getProperty("firfoxpath");
		return firepath;
	}
}
