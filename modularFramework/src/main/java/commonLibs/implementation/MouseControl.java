package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commonLibs.contracts.IMouseOperation;

public class MouseControl implements IMouseOperation {
	
	private Actions action;
	
	public MouseControl(WebDriver driver)
	{
		Actions action = new Actions(driver);
	}

	public void dragAndDrop(WebElement source, WebElement target) throws Exception {
		
		action.dragAndDrop(source, target).build().perform();
		
	}

	public void moveToElement(WebElement element) throws Exception {

		action.moveToElement(element).build().perform();
	}

	public void rightClick(WebElement element) throws Exception {

		action.contextClick(element).build().perform();
	}

	public void doubleClick(WebElement element) throws Exception {

		action.doubleClick(element).build().perform();
	}

	public void moveToElementAndClick(WebElement element) throws Exception {

		action.moveToElement(element).click(element).build().perform();
	}

}
