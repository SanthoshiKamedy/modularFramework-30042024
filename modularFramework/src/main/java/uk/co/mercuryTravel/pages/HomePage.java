package uk.co.mercuryTravel.pages;


	
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.utils.WaitUtils;

	public class HomePage extends BasePage {
		
		@FindBy(linkText="International Holidays")
		private WebElement internationalHolidaysLink;
		
		@FindBy(linkText="Indian Holidays")
		private WebElement indianHolidayLink;
		
		@FindBy(linkText="Luxury Rails")
		private WebElement luxuryHolidayLink;
		
		
		@FindBy(linkText="customer login")
		private WebElement customerLogin;
		
		@FindBy(linkText="user login")
		private WebElement userLogin;
		
		@FindBy(linkText="Register")
		private WebElement register;
		
		@FindBy(id="sign_user_email")
		private WebElement userEmailId;

		@FindBy(id="sign_user_password")
		private WebElement userPassword;
		
		@FindBy(xpath="//button[text()='Log in']")
		private WebElement userButton;
				
		@FindBy(xpath="(//button[@class='close'])[2]")
		private WebElement closeInitialModalButton;
		
		@FindBy(partialLinkText="welcome,")
		private WebElement welcomeText;
		
		public HomePage(WebDriver driver) {
			
			super(driver);
			
			PageFactory.initElements(driver, this);
		}
		
		public void closeIntialModal() throws Exception {
			elementControl.clickElement(closeInitialModalButton);
		}
			 
			
			public void userLogin(String username,String password, WebElement signUserEmailId, WebElement signUSerEmailId) throws Exception {
				
			
			
							
				mouseControl.moveToElement(customerLogin);
				
				mouseControl.moveToElement(userLogin);
				
				elementControl.setText(signUserEmailId, username);
				
				WaitUtils.waitForSeconds(3);
				
				elementControl.setText(signUSerEmailId, password);
				
				WaitUtils.waitForSeconds(3);

				
				elementControl.clickElement(userButton);
			}
		
		public String getWelcomeMessage() throws Exception {
			
		return	elementControl.getText(welcomeText);
			
			
			
		}
		

		
		
		

	}



