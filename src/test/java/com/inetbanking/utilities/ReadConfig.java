package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;

	// create one constructor
	public ReadConfig()  {
		File src =new File("./Configurations/config.properties");
		try {
			FileInputStream file =new FileInputStream(src);
			pro=new Properties();
			pro.load(file);
		}catch(Exception e) {
			System.out.println("EXECEPTION IS "+e.getMessage());
		}
	}
	
	// it will return the url to the base class will retrn a string
	public String getApplicationURL() {
		String url=pro.getProperty("baseURL");
		return url;	
	}
	
	public String getUserName()
	{
		String username=pro.getProperty("username");
		return username;
	}
	
	
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	
	public String getChromePath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	
	public String getEdgePath()
	{
		String edgepath=pro.getProperty("msedgepath");
		return edgepath;
	}
	
	
}