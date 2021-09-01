package com.mainProject.testCases;

import org.testng.annotations.Test;

import com.mainProject.pageObjects.NewCustomerPage;
import com.mainProject.pageObjects.loginPage;

public class NewCustomerTest extends BaseClass{

	@Test
	public void NewcustomerTest() {

		driver.get(baseUrl);
		logger.info("url is opened");
		loginPage lp=new loginPage(driver);
		lp.setUserName(userName);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		NewCustomerPage np=new NewCustomerPage(driver);
		
		np.clickAddNewCustomer();
		np.custName("sam");
		np.custgender();
		np.custdob("10","15","1985");
		np.custaddress("INDIA");
		np.custcity("HYD");
		np.custstate("AP");
		np.custpinno("5000074");
		np.custtelephoneno("987890091");
		np.custemailid("abc@gmail.com");
		np.custsubmit();

		

	}
}
