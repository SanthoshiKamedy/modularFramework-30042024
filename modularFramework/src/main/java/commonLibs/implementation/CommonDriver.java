package commonLibs.implementation;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import commonLibs.contracts.IDriver;

public class CommonDriver implements IDriver {
	
	private WebDriver driver;
	private int pageloadTimeout;
	private int impicitWait;  //elementDEtectiontimeout
	
	private String currentWorkingDirectory;
	
	


	public CommonDriver(String browserType) throws Exception{
		
		pageloadTimeout =60;
     impicitWait =10;
     
     currentWorkingDirectory=System.getProperty("user.dir");
		
		// TODO Auto-generated constructor stub
		if(browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",  currentWorkingDirectory + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();

		}else if(browserType.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", currentWorkingDirectory+ "/drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			throw new Exception("invalid browser type");
		}
	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	}

	public WebDriver getDriver() {
		return driver;
	}


	public void setPageloadTimeout(int pageloadTimeout) {
		this.pageloadTimeout = pageloadTimeout;
	}


	public void setImpicitWait(int impicitWait) {
		this.impicitWait = impicitWait;
	}

	public void navigateToFirstUrl(String url) throws Exception {
		
		driver.manage().timeouts().pageLoadTimeout(pageloadTimeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(impicitWait, TimeUnit.SECONDS);
		
		url=url.trim();
		driver.get(url);
		
	}



	public String getTitle() throws Exception {
		
		String title = driver.getTitle();
		return title;
	}



	public String getCurrentUrl() throws Exception {
		
		return driver.getCurrentUrl();
	}



	public String getPageSource() throws Exception {
		
		return driver.getPageSource();
	}



	public void navigateToUrl(String url) throws Exception {
		
		url=url.trim();
		
		driver.navigate().to(url);
		
	}



	public void navigateForward() throws Exception {
		
		driver.navigate().forward();
		
		
		
	}



	public void navigateBackward() throws Exception {

		driver.navigate().back();
	}



	public void refresh() throws Exception {

		driver.navigate().refresh();
	}



	public void closeBrowser() throws Exception {
		
		if(driver!=null) {
			driver.close();
		}
	}



	public void closeAllBrowsers() throws Exception {
		if(driver!=null)
			driver.quit();
		
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		// TODO Auto-generated method stub
		
	}

	
}


