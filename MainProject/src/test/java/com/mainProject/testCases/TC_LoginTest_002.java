package com.mainProject.testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mainProject.pageObjects.loginPage;
import com.mainProject.utilities.ExcelUtilities;

public class TC_LoginTest_002 extends BaseClass {

	
	@Test(dataProvider = "loginData")
	public void loginTest2(String userName,String password) {
		
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
	
	@DataProvider(name="loginData")
	public Object[][] testDataExample(){
	ExcelUtilities config = new ExcelUtilities(System.getProperty("user.dir")+"\\src\\test\\java\\com\\mainProject\\testData\\loginData.xlsx");
	int rows = config.getRowCount(0);
	Object[][]signin_credentials = new Object[rows][2];

	for(int i=0;i<rows;i++)
	{
	signin_credentials[i][0] = config.getData(0, i, 0);
	signin_credentials[i][1] = config.getData(0, i, 1);
	}
	return signin_credentials;
	}
}
