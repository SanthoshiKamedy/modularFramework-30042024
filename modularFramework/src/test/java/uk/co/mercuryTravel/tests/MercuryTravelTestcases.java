package uk.co.mercuryTravel.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class MercuryTravelTestcases extends BaseTest{
	
	

	@Test 
	public void verifyUserLoginWithCorrectCredentials()  throws Exception{
		
		extentTest = extent.createTest("TC-001-verify user login with correct credintials");
		
		
		String username = configProperties.getProperty("userEmailID");
		
		extentTest.log(Status.INFO,"user email -id-" +username);
		String password = configProperties.getProperty("userPassword");
		
		extentTest.log(Status.INFO,"user password-" +password);

		
		homepage.userLogin(username, password, null, null);
		
		String expectedWelcomeText =configProperties.getProperty("expectedWelcome");
		String actualWelcomeText  = homepage.getWelcomeMessage();
		
		Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
		
		extentTest.log(Status.INFO, "user login successful" );
	}

}
