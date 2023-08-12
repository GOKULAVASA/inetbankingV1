package com.inetbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
    public WebDriver driver;
    public ExtentSparkReporter sparkreporter;
    public ExtentReports extent;
    public ExtentTest logger;

    @BeforeTest
    public void onStart(ITestContext testcontext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String repname = "Test-Report-" + timeStamp + ".html";

        sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + repname);
        sparkreporter.config().setDocumentTitle("report");
        sparkreporter.config().setReportName("Functional report");
        sparkreporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkreporter);

        extent.setSystemInfo("HostName", "localhost");
        extent.setSystemInfo("TesterName", "gk");
        extent.setSystemInfo("Browser", "Chrome");
    }

    public void onTestSuccess(ITestResult tr) {
        logger = extent.createTest(tr.getName());
        logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
    }

    public void onTestFailure(ITestResult tr) {
        logger = extent.createTest(tr.getName());
        logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
        String screenshotPath = System.getProperty("user.dir") + "\\Screenshot\\" + tr.getName() + ".png";
        File f = new File(screenshotPath);
        if (f.exists()) {
            logger.fail("Screenshot below: " + logger.addScreenCaptureFromPath(screenshotPath));
        }
    }

    public void onTestSkipped(ITestResult tr) {
        logger = extent.createTest(tr.getName());
        logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
    }

    public void onFinish(ITestContext testcontext) {
        extent.flush();
    }
}
