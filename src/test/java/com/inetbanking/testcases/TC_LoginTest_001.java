package com.inetbanking.testcases;

import static org.testng.Assert.assertTrue;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest()
	{
		
		logger.info("url launched");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username  entered");
		lp.setUserPassword(password);
		logger.info("password entered");
		lp.Clicksubmit();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
			Assert.assertTrue(true);
			logger.info("title matched");
		}
		else {
			Assert.assertTrue(false);
			logger.info("title is not matched");
		}
	}
	
	
	
}
