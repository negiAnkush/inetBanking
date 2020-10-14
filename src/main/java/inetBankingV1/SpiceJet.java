package inetBankingV1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SpiceJet {
	
	WebDriver driver;
	public void booking() throws InterruptedException
	{
		
	
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/Drivers/chromedriver");
		driver = new ChromeDriver();
	
	driver.get("https://www.spicejet.com/");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	
	driver.findElement(By.xpath("//input[@value='OneWay' ][@id='ctl00_mainContent_rbtnl_Trip_0']")).click();
	
	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
	
	WebElement ele = driver.findElement(By.id("dropdownGroup2"));
	Select sl = new Select(ele);
	Thread.sleep(2000);
	
	sl.selectByValue("KQH");
	
	
	
	


driver.quit();

}
}
