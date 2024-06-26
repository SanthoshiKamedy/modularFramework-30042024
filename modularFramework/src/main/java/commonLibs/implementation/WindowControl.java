package commonLibs.implementation;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IwindowHandle;

public class WindowControl  implements IwindowHandle{
	
	private WebDriver driver;
	
	
	public WindowControl(WebDriver driver) {
		
		this.driver = driver;
		
	}

	public void switchToAnyWindow(String windowhandle) throws Exception {
		
		driver.switchTo().window(windowhandle);
		
	}

	public void switchToAnyWindow(int childWindowIndex) throws Exception {
		
		String childWindowHandle = driver.getWindowHandles().toArray()[childWindowIndex].toString();
		
		driver.switchTo().window(childWindowHandle);
		
	}

	public String getWindowHandle() throws Exception {
		
		
		
		
		return driver.getWindowHandle();
	}

	public Set<String> getWindowHandles() throws Exception {
		
		
		return driver.getWindowHandles();
	}

}
