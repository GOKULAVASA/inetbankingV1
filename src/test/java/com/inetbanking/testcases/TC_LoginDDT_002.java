package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLutils;

public class TC_LoginDDT_002 extends BaseClass{


	@Test(dataProvider="logindata")
	public void LoginDDT(String user,String pass) throws InterruptedException, IOException {

		LoginPage lp =new LoginPage(driver);

		lp.setUserName(user);
		logger.info("username provided");
		lp.setUserPassword(pass);
		logger.info("passwored provided");
		lp.Clicksubmit();
		logger.info("submit provided");
		Thread.sleep(3000);

		if (isAlertPresent()==true)
		{captureScreenshot(driver,"LoginDDT");
		logger.info("worng creditials ");
			driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
		logger.warn("provided username or pass is wrong ");
		}else {
			Assert.assertTrue(true);
			lp.logout();
			Thread.sleep(3000);
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();	
			logger.info("valid credititals logged out to next futher data driven test ");

		}
	}
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			logger.warn("yes alret is there ");
			return true;
		}catch(NoAlertPresentException e)
		{	logger.info("exception handled ");
		return false;
		}


	}


	@DataProvider(name="logindata")
	String[][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testdata/logindata.xlsx";
		//C:\Users\badas\git\repository\inetbankingV1=project home dir-->(user.dir)
		int rownum=XLutils.getRowCount(path, "Sheet1");
		int colcount=XLutils.getCellCount(path, "Sheet1",1);
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++){
			for (int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLutils.getCellData(path, "Sheet1", i, j);
			}


		}
		return logindata;
	}
}
