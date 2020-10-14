package com.inetBanking.testCases;

import com.inetBanking.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Parameters;


import java.io.File;
import java.io.IOException;

public class TestBase {
	
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUserName();
	public String paswd = readconfig.getPass();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");

		if(br.equals("chrome"))
		{
			System.out.println("chrome path  "+readconfig.getChromePath());
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}

		driver.get(baseURL);

	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

	public void CaptureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File targer = new File(System.getProperty("user.dir") + "/ScreenShots/"+ tname +".png");
		FileUtils.copyFile(source, targer);
		System.out.println("ScreenShot taken");
	}

}
