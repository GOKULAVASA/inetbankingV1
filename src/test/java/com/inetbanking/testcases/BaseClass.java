package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public  String username=readconfig.getUserName();
	public  String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		logger =Logger.getLogger("ebanking");

		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
		}else if (br.equals("msedge")) {
			System.setProperty("webdriver.edge.driver",readconfig.getEdgePath());
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@AfterClass
	public void teardown() {

		driver.quit();	
	}
	
	
	
	
	public void captureScreenshot(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File target =new File(System.getProperty("user.dir")+"/Screenshot/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
	}
	
	public String randomstring() {
		String generatedmail =RandomStringUtils.randomAlphabetic(10);
		return generatedmail;
	}
	public static String randomNum() {
		String generatedNum=RandomStringUtils.randomNumeric(4);
		return generatedNum;
}

}
