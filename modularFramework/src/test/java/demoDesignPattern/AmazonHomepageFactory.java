package demoDesignPattern;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonLibs.implementation.CommonDriver;

public class AmazonHomepageFactory {
	
CommonDriver cmnDriver;
	
	AmazonHomepageFactory homepage;
	String url ="https://www.amazon.co.uk";
	
	WebDriver driver;
	
	
	@BeforeClass
	
	public void invokeBrowser() throws Exception{
		
		cmnDriver = new CommonDriver("chrome");
		cmnDriver.setPageloadTimeout(60);
		cmnDriver.navigateToFirstUrl(url);
		driver = cmnDriver.getDriver();
		homepage = new AmazonHomepageFactory();
		
	}
	
	@Test
	public void searchProduct() throws Exception{
		String product ="iphone";
		String category ="Electronics";
		
		homepage.searchProduct ();
	}
	
	@AfterClass
	
	public void closeBrowser() throws Exception{
		cmnDriver.closeAllBrowsers();
	}



}
