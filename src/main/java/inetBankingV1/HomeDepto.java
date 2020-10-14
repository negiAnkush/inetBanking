package inetBankingV1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeDepto {
	
	
	static WebDriver driver;
	@Test
	@Parameters("choice")
	public static void senario(String choice) throws InterruptedException
	{
		System.out.println(choice);
		String baseUrl = "https://www.githubstatus.com/";
		String xpath = "//span[contains(text(),'"+choice+"')]/following-sibling::div//*[local-name()='svg']//*[name()='rect']";
		////span[contains(text(),'Webhooks')]/following-sibling::div//*[local-name()='svg']//*[name()='rect']"
		driver.get(baseUrl);
		Thread.sleep(5000);
		List<WebElement> element=new ArrayList<WebElement>();
		Actions action = new Actions(driver);
		element = driver.findElements(By.xpath(xpath));
		
		for(int i=0; i<element.size(); i++)
		{
			if(!element.get(i).getAttribute("fill").equals("#28a745"))
			{
			 //System.out.println(element.get(i).getAttribute("fill"));
			 action.moveToElement(element.get(i)).click().build().perform();
			 System.out.println(driver.findElement(By.xpath("//div[@class='date']")).getText());
			 Thread.sleep(3000);
			}
		}
		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'"+choice+"')]/following-sibling::span[@class='component-status']")).getText());
		
		/*if(driver.findElement(By.xpath("//span[contains(text(),'Git Operations')]/following-sibling::span[@class='component-status']")).getText().equals("Normal"))
		{
			Assert.assertTrue(true);
			System.out.println("Status is Normal");
		}
		*/
		
		//Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Git Operations')]/following-sibling::span[@class='component-status']")).getText(), "Normal");
		
		
	}
	
	@BeforeTest
	public void setup()
	{
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"//drivers/chromedriver");
		driver = new  ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}
	
	@AfterTest
	public void teardown()
	{
		System.out.println("Close the browser");
		  driver.quit();
		
	}
	

}
