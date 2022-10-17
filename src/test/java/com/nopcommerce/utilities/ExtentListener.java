package com.nopcommerce.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListener implements ITestListener {

	ExtentReports reports;
	ExtentSparkReporter htmlReporter;
	ExtentTest test;
	WebDriver driver;
	Capabilities capabilities;

	public void configureExtentReport() {
		capabilities = ((RemoteWebDriver) driver).getCapabilities();
		File file = new File("Reports/ExtentReport.html");
		htmlReporter = new ExtentSparkReporter(file);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		//Change theme, name title
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("Extent Report");
		htmlReporter.config().setDocumentTitle("NopCommerce Automation");

		//Add system/environment information
		reports.setSystemInfo("OS", System.getProperty("os.name"));
		reports.setSystemInfo("Java Version", System.getProperty("java.version"));
		reports.setSystemInfo("Browser", capabilities.getBrowserName());
		reports.setSystemInfo("Browser Version", System.getProperty("os.name"));
		reports.setSystemInfo("App URL", "https://demo.nopcommerce.com/");
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Name of test method started: " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of test method successfully excuted: " + result.getName());
//		test = reports.createTest(result.getName());
//		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Name of test method failed: " + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + result.getName(), ExtentColor.RED));
		
		String screenshotPath = System.getProperty("user.dir") + "./Screenshots/" + result.getName() + ".png";
		
		File screenshotFile = new File(screenshotPath);
		
		if(screenshotFile.exists()) {
			test.fail("Capture Screenshot is below: " + test.addScreenCaptureFromPath(screenshotPath));
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of test method skipped: " + result.getName());
//		test = reports.createTest(result.getName());
//		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped test case is: " + result.getName(), ExtentColor.YELLOW));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		configureExtentReport();
		System.out.println("On Start method invoked...");
	}

	public void onFinish(ITestContext context) {
		System.out.println("On Finished method invoked...");
		reports.flush();
		try {
			Desktop.getDesktop().browse(new File("Reports/ExtentReport.html").toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
