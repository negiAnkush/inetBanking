package inetBankingV1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EdurekaMouseHover {
	
	WebDriver driver;
	
	
	@Test
	public void mousehover() throws InterruptedException
	{
		driver.get("https://edureka.co");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement catg,cyberSecurity,certification;
		catg = driver.findElement(By.xpath("*//a[@class='dropdown-toggle hidden-xs hidden-sm ga_browse_top_cat']//span[contains(text(),'Categories')]"));
		cyberSecurity = driver.findElement(By.xpath("//a[@class='dropdown-toggle ga_top_category'][contains(text(),'Cyber Security')]"));
		certification= driver.findElement(By.xpath("//a[@class='ga_top_categories_course'][contains(text(),'Cybersecurity Certification Course')]"));
		
		action.moveToElement(catg).perform();
		Thread.sleep(2000);
		action.moveToElement(cyberSecurity).perform();
		Thread.sleep(2000);
		action.moveToElement(certification).click().perform();
		Thread.sleep(5000);
		
		//Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Cybersecurity Certification Course')]")).getText(), "Cybersecurity Certification Course");
		if(driver.findElement(By.xpath("//h1[contains(text(),'Cybersecurity Certification Course')]")).isDisplayed())
		{
			Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Cybersecurity Certification Course')]")).getText(), "Cybersecurity Certification Course");
		}
		
	}
	
	@BeforeTest
	public void setup() 
	{
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/Drivers/chromedriver");
		driver = new ChromeDriver();	
		
	}
	
	@AfterTest
	public void teardown()
	{ 
		driver.quit();
	}

}
