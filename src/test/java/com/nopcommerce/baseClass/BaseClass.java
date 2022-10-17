package com.nopcommerce.baseClass;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.nopcommerce.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	public static ExtentTest test;
	public static ExtentReports reports;
	public static 	ExtentSparkReporter htmlReporter;

	ReadConfig rc = new ReadConfig();

	public String baseUrl = rc.getBaseUrl();
	public String browser = rc.getBrowser();

	@BeforeTest
	public static void setup() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.setHeadless(false);
		opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));

		String browser = "Chrome";

		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver(opt);
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		// For logging
		logger = LogManager.getLogger("NopCommerce");
		
		// For Extent Reporting System
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
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

	@AfterTest
	public void tearDown() throws IOException {
		driver.quit();
		reports.flush();
		Desktop.getDesktop().browse(new File("Reports/ExtentReport.html").toURI());
	}
	
	public void captureScreenshot(WebDriver driver, String testName) throws IOException {
		
		TakesScreenshot screenshot = ((TakesScreenshot) driver);

		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "./Screenshots/" + testName + ".png");

		FileUtils.copyFile(src, dest);
	}

}
