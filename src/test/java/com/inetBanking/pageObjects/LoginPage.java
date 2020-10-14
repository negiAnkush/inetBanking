package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



/*
 * base url for the testing page is http://www.demo.guru99.com/v4/
 */

public class LoginPage {
	
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPasswd;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(xpath="//a[text()='Log out']")
	@CacheLookup
	WebElement btnLogout;
	
	public void setUserName(String name)
	{
		txtUserName.sendKeys(name);
	}
	
	public void setPaswd(String pass)
	{
		txtPasswd.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}

	public void clickLogout()
	{
		btnLogout.click();
	}
}
