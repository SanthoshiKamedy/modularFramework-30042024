package commonLibs.implementation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IJavascriptOperations;

public class JavascriptControl implements IJavascriptOperations{
	
	private JavascriptExecutor jsEngine;
	
	public JavascriptControl(WebDriver driver) {
		
		jsEngine= (JavascriptExecutor) driver;
		
	}

	public void executeJavaScript(String scriptToExcute) throws Exception {

		jsEngine.executeScript(scriptToExcute);
	}

	public void scrollDown(int x, int y) throws Exception {
		String jscommand = String.format("window.scroll By(%d,%d)", x,y);
		
		jsEngine.executeScript(jscommand);
	}

	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception {
		
				return jsEngine.executeScript(scriptToExecute).toString();

	}

}
