package com.mainProject.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mainProject.pageObjects.loginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() {
		
		driver.get(baseUrl);
		logger.info("url is opened");
		
		loginPage lp=new loginPage(driver);
		
		lp.setUserName(userName);
		logger.info("User name entered");
		lp.setPassword(password);
		logger.info("Password entered");
		lp.clickSubmit();
		logger.info("Submit button clicked");
		
		System.out.println(driver.getTitle());
		
		Assert.assertEquals(driver.getTitle(), "GTPL Bank Manager HomePage");
	}
	
	

}
