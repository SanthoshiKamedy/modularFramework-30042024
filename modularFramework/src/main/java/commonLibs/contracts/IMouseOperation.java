package commonLibs.contracts;

import org.openqa.selenium.WebElement;

public interface IMouseOperation {
	
	public void dragAndDrop(WebElement source, WebElement target) throws Exception;
	
	public void moveToElement(WebElement element)throws Exception;
	
	public void rightClick(WebElement element) throws Exception;
	
	public void doubleClick(WebElement element) throws Exception;
	
	public void moveToElementAndClick(WebElement element)throws Exception;
	

}
