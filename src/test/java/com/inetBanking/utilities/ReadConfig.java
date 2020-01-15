package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig(){
		File src = new File("./Configurations/Config.properties");
		try {
		FileInputStream fis = new FileInputStream(src);	
		pro = new Properties();
		pro.load(fis);//Load the Config.property File at run Time
		} catch (Exception e) {
			// TODO: handle exception
		System.out.println("Exception is " + e.getMessage());
		}
	}
	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserName() {
		String userName = pro.getProperty("userName");
		return userName;
	}
	
	public String getpassword() {
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromepath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
}
