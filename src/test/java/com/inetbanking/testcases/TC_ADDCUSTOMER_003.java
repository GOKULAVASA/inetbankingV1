package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_ADDCUSTOMER_003 extends BaseClass {
	@Test
	public void addnewcustomer() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username entered");
		lp.setUserPassword(password);
		logger.info("password entered");
		lp.Clicksubmit();
		logger.info(" entered submit");
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		Thread.sleep(3000);
		logger.info(" dashborad entered");
		addcust.ClickNewCustomer();
		addcust.EnterCusName("gokul");
		addcust.ClickGenderBtn();
		addcust.dateOfBirth("10","4","1997");
		Thread.sleep(3000);
		addcust.EnterAddress("no address");
		addcust.EnterCity("CHENNAI");
		addcust.EnterState("TN");
		addcust.EnterPincode(600042);
		addcust.EnterPHnum(999999999);
		String email=randomstring()+"@gmail.com";
		addcust.Enteremail(email);
		addcust.Enterpassword("abcdef@123");
		addcust.clicksubmit();
		logger.info("form  entered clicked submit");
		
		Thread.sleep(3000);
	boolean validation=	driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (validation==true){
			Assert.assertTrue(true)
			;
			logger.info("test passed");
		}else {captureScreenshot(driver,"addnewcustomer");
			Assert.assertTrue(false);
			logger.info("failed screenshot taken entered");
		}
	}

}

