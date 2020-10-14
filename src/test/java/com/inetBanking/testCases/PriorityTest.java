package com.inetBanking.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.utilities.ReadConfig;

public class PriorityTest {
	WebDriver driver;
	ReadConfig readconfig = new ReadConfig();
	
	@Test(priority=1)
	public void aopenBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/ankushnegi/Desktop/project/inetBankingV1/Driver/chromedriver");
		driver = new ChromeDriver();
	}
	
	@Test(priority=2)
	public void launchGoogle()
	{
		driver.get("https://www.google.com/");
	}
	
	@Test(priority=3)
	public void performSearchAndClick()
	{
		driver.findElement(By.xpath(".//*[@title='Search']")).sendKeys("Facebook");
	}
	
	@Test(priority=4)
	public void fbPageTitleVerification() throws Exception
	{
		driver.findElement(By.xpath(".//*[@title='Search'")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle().contains("facebook - Google Search"), true);
		
	}

}
