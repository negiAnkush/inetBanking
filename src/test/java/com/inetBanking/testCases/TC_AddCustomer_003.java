package com.inetBanking.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends TestBase {
	
	@Test
	public void addcustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("enter user name");
		lp.setPaswd(paswd);
		logger.info("enter user pass");
		lp.clickLogin();
		logger.info("click login");
		
		Thread.sleep(3000);
		
		AddCustomerPage cst = new AddCustomerPage(driver);
		cst.clickAddNewUser();
		cst.setName("ankush");
		logger.info("enter user name");
		cst.sleectRadioSex();
		logger.info("select Gender");
		Thread.sleep(3000);
		cst.setDob("1020","12","20");
		Thread.sleep(3000);
		logger.info("enter user DOB");
		cst.setAddrs("1172 high kensas road");
		logger.info("enter address");
		cst.setCity("Toronto");
		logger.info("enter city");
		cst.setState("Ontario");
		logger.info("enter State");
		cst.setPin(1122332);
		logger.info("enter pincode");
		cst.setPhone("9923947392");
		logger.info("enter phone");
		cst.setEmail(genrateRandomString()+"@abc.com");
		logger.info("enter emails");
		cst.setPass("123123");
		logger.info("set pass");
		cst.clickSubmit();
		Thread.sleep(3000);
		
		////p[contains(text(),'Customer Registered Successfully!!!')]
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(result==true)
			{
				Assert.assertTrue(true);
			}
		else
			{
				CaptureScreen(driver, "addcustomer");
				Assert.assertTrue(false);
			}
			
	}
	

}
