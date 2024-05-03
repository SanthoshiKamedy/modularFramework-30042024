package commonLibs.implementation;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IAlert;
import commonLibs.utils.WaitUtils;

public class AlertControl implements IAlert{
	
	private WebDriver driver;
	
	public AlertControl(WebDriver driver) {
		this.driver =driver;
		
	}
	
	private Alert getAlert() {
		return driver.switchTo().alert();
	}

	public void acceptAlert() throws Exception {
		
		
		getAlert().accept();
	}

	public void rejectAlert() throws Exception {
		
		getAlert().dismiss();
		
	}

	public String getMessageFromAlert() throws Exception {
		
		
		return getAlert().getText();
	}

	public boolean checkAlertPresent(Duration timeoutInSeconds) throws Exception {
		
		
		try {
			WaitUtils.waitTillAlertIsPresent(driver, timeoutInSeconds); 
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
		
	}

	public boolean checkAlertPresent(int timeoutInseconds) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	

}
