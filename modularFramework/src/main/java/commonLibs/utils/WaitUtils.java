package commonLibs.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	public static void waitForSeconds(int timeoutInseconds) throws Exception{
		
		Thread.sleep(timeoutInseconds * 1000);
	}
	
	public static void waitTillAlertIsPresent(WebDriver driver,Duration timeoutInSeconds) {
		
		WebDriverWait wait= new WebDriverWait(driver,timeoutInSeconds);
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		}
	
	public static void waitTillElementVisible(WebDriver driver, WebElement element , Duration inOutInSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver,inOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
public static void waitTillElementVisibleClickable(WebDriver driver, WebElement element , Duration inOutInSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver,inOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}


public static void waitTillElementSelectable(WebDriver driver, WebElement element , Duration inOutInSeconds) {
	
	WebDriverWait wait = new WebDriverWait(driver,inOutInSeconds);
	wait.until(ExpectedConditions.elementToBeSelected(element));
	
}
}
