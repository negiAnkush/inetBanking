package com.inetBanking.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.inetBanking.pageObjects.LoginPage;

import java.io.IOException;


public class TC_LoginTest_001 extends TestBase {

	public TC_LoginTest_001() {
	}

	@Test
	public void loginTest() throws IOException, InterruptedException {

		logger.info("URL is Open");
		Thread.sleep(4000);
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered username");

		lp.setPaswd(paswd);
		logger.info("Entered Password");
		lp.clickLogin();
		Thread.sleep(5000);
		//System.out.println("title : "+driver.getTitle());
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");

		}
		else
		{
			CaptureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}

}
