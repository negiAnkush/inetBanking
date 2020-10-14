package inetBankingV1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScenarioOne {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		String path = System.getProperty("user.dir");	
		System.setProperty("webdriver.chrome.driver",path+"//drivers/chromedriver");
		//String baseUrl = "http://www.homedepot.ca";
			//System.out.println(path+"/drivers/geckodriver");
			//WebDriver driver = new FirefoxDriver();
		ChromeOptions options = new ChromeOptions(); 
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
		
		driver = new  ChromeDriver(options);
		driver.manage().deleteAllCookies();
		
		
	}
	
	@Test(priority=0)
	public void scenarioOne() throws InterruptedException
	{
		String baseUrl = "http://www.homedepot.ca";
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(driver.findElement(By.xpath("//button[@class='hdca-gheader-localization__close-button hdca-button hdca-button--icon hdca-button--icon-small hdca-popover__close']//acl-icon[@class='acl-icon hdca-button__icon']//*[local-name()='svg']")).isDisplayed())
		{
			driver.findElement(By.xpath("//button[@class='hdca-gheader-localization__close-button hdca-button hdca-button--icon hdca-button--icon-small hdca-popover__close']//acl-icon[@class='acl-icon hdca-button__icon']//*[local-name()='svg']")).click();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[@class='hdca-gheader-nav__item-button-label'][contains(text(),'Shop by Room')]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        driver.findElement(By.xpath("//span[contains(@class,'hdca-button2__non-wrap-label')][contains(text(),'Kitchen')]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //System.out.println(driver.findElement(By.xpath("//ol[@class='hdca-breadcrumbs__list']")).getText());
        //findBy("//ol[@class='hdca-breadcrumbs__list']").getText().equals("Home Shop by Room Kitchen");
        boolean isPresent = driver.findElement(By.xpath("//ol[@class='hdca-breadcrumbs__list']")).getText().equals("Home Shop by Room Kitchen");
        assertTrue(isPresent);
        System.out.println("is present : "+isPresent);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        WebElement Element = driver.findElement(By.xpath("//h2[contains(text(),'Essential Appliances')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
		
		driver.findElement(By.xpath("//span[contains(text(),'Microwaves')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if(driver.getTitle().contains("Microwaves")){System.out.println("present in title");}
		assertTrue(driver.getTitle().contains("Microwaves"));
		
		driver.findElement(By.xpath("//div[@class='acl-dropdown__toggle ng-tns-c156-0']")).click();
		driver.findElement(By.xpath("//div[@class='acl-display--hide md:acl-display--show ng-star-inserted']//li[3]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//article[3]//section[1]//div[1]//div[1]//acl-checkbox-container[1]//div[1]//div[1]//label[1]//div[1]//span[1]")).click();
		driver.findElement(By.xpath("//article[4]//section[1]//div[1]//div[1]//acl-checkbox-container[1]//div[1]//div[1]//label[1]//div[1]//span[1]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		 boolean hasItems = driver.findElement(By.xpath("//h2[@class='acl-shelf__title ng-tns-c162-32']']")).getText().equals("Selected 2 of 4 items");
	     assertTrue(hasItems);
	     
	     boolean isButnVisible = driver.findElement(By.xpath("//span[@class='acl-button__label ng-star-inserted'][contains(text(),'Compare')]")).isDisplayed(); 
	     assertTrue(isButnVisible);
		
	}
	
	
	@Test(priority=1)
	public void scenarioTwo() throws InterruptedException 
	{

		String baseUrl = "http://www.homedepot.ca";
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='hdca-gheader-nav__item-button-label'][contains(text(),'Home Services')]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='hdca-service-connect-accordion__title-text'][contains(text(),'Kitchen')]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Appliance Installation")).click();
		Thread.sleep(3000);
		
		//verifying the title of the page with the lowest leve of breadcrumb
		String pageTitle = driver.getTitle();
		assertTrue(pageTitle.equals(driver.findElement(By.className("hdca-breadcrumbs__item-label"))));
		
		//verify the verbiage of the button 
		assertEquals(driver.findElement(By.xpath("Request For Consultation")).getText(), "Request For Consultation");
		
		WebElement eleLocation = driver.findElement(By.className("hdca-cms-home-services-banner__wrapper-content--text-location"));
		if(eleLocation.isDisplayed() && !eleLocation.getText().isEmpty())
		{
			assertTrue(true);
		}
		else 
			assertTrue(false);
			
		}
		
		
	
	@AfterMethod
	public void teardown()
	{
		 System.out.println("Close the browser");
		  driver.quit();
		
	}
	

	}



