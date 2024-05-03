package uk.co.mercuryTravel.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.ScreenshotControl;
import commonLibs.utils.ConfigFileUtils;
import commonLibs.utils.DateUtils;
import uk.co.mercuryTravel.pages.HomePage;

public class BaseTest {

	CommonDriver cmnDriver;

	String browserType;
	String baseurl;

	HomePage homepage;

	private WebDriver driver;

	static String configFileName;
	static Properties configProperties;

	static String currentWorkingDirectory;
	static String executionStartDate;

	int pageloadtimeout;
	int elementDetectionTimeout;

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest extentTest;

	String reportFilename;
	
	String screenshotFilename;
	ScreenshotControl screenshotControl;

	private String pathFile;

	static {
		try {
			currentWorkingDirectory = System.getProperty("user.dir");
			executionStartDate = DateUtils.getCurrentDateAndTime();

			configFileName = System.getProperty("user.dir") + "/config/config.properties";

			configProperties = ConfigFileUtils.readProperties(configFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void preSetup() {

		reportFilename = String.format("%s/reports/MercuryTravelTestReport-%s.html", currentWorkingDirectory,
				executionStartDate);

		htmlReporter = new ExtentHtmlReporter(reportFilename);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@BeforeClass
	public void setUp() throws Exception {

		extentTest = extent.createTest("set up - set up the pre requested to rn automated test cases");

		extentTest.log(Status.INFO, "Browser invoked is " + browserType);

		browserType = configProperties.getProperty(browserType);

		extentTest.log(Status.INFO, "Browser invoked is " + browserType); // creating log events

		cmnDriver = new CommonDriver(browserType);

		cmnDriver.setPageloadTimeout(60);
		// cmnDriver.setElementDetectionTimeout(20);
		cmnDriver.navigateToFirstUrl(baseurl);

		driver = cmnDriver.getDriver();

		homepage = new HomePage(driver);

		homepage.closeIntialModal();

	}

	@BeforeClass
	public void invokeBrowser1() throws Exception {
		browserType = configProperties.getProperty("browserType");
		cmnDriver = new CommonDriver(browserType);
		pageloadtimeout = Integer.parseInt(configProperties.getProperty("pageloadTimeout"));

		extentTest.log(Status.INFO, "Page load Timeout set is- " + browserType);

		elementDetectionTimeout = Integer.parseInt(configProperties.getProperty("elementDetectionTimeout"));
		extentTest.log(Status.INFO, "Implicit wait set is- " + elementDetectionTimeout);

		cmnDriver.setPageloadTimeout(pageloadtimeout);
		cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);

		baseurl = configProperties.getProperty("baseUrl");

		extentTest.log(Status.INFO, "Base URL where the browser navigates to set is- " + baseurl);

		cmnDriver.navigateToFirstUrl(baseurl);
		driver = cmnDriver.getDriver();

		extentTest.log(Status.INFO, "Initializing all pages");
		homepage = new HomePage(driver);
		
		screenshotControl = new ScreenshotControl(driver);
		
		homepage.closeIntialModal();

	}

	@AfterClass
	public void cleanUp() throws Exception {

		extentTest = extent.createTest("Cleanup-clean process");

		extentTest.log(Status.INFO, "closing all browser instances" + baseurl);

		cmnDriver.closeAllBrowsers();

	}

	@AfterSuite
	public void postCleanUp() throws Exception {

		extent.flush();
		cmnDriver.closeAllBrowsers();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		String testcaseName = result.getName();
		
		String screenshotFilename= String.format("%s/screenshot/%s-%s.jpeg", currentWorkingDirectory,testcaseName,executionStartDate);

		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "Test case pass-" + testcaseName);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, "Test case fail-" + testcaseName);
			
screenshotControl.captureAndSaveScreenshot(screenshotFilename);

extentTest.addScreenCaptureFromPath(screenshotFilename);
		} else {
			extentTest.log(Status.SKIP, "Test case Skipped-" + testcaseName);

		}

	}

}
