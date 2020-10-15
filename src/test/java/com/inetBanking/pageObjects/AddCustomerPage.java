package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.FindBy;

public class AddCustomerPage {
	
	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
/*
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'New Customer')]");
	@CacheLookup
	WebElement newCustomerLink;
	
	*/
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement addNewUser;
	
	@FindBy(name="name")
	@CacheLookup
	WebElement txtCustName;
	
	@FindBy(name="rad1")
	@CacheLookup
	WebElement rGender;
	
	@FindBy(id="dob")
	@CacheLookup
	WebElement txtDob;
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement txtAddr;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement txtPin;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement txtTel;
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtpass;
	
	@FindBy(name="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	
	public void clickAddNewUser()
	{
		addNewUser.click();
	}
	
	public void setName(String cname)
	{
		txtCustName.sendKeys(cname);
	}
	public void sleectRadioSex()
	{
		rGender.click();
	}
	public void setDob(String mm, String dd, String yy)
	{
		txtDob.sendKeys(mm);
		txtDob.sendKeys(dd);
		txtDob.sendKeys(yy);
	}
	public void setAddrs(String add)
	{
		txtAddr.sendKeys(add);
	}
	public void setCity(String city)
	{
		txtCity.sendKeys(city);
	}
	public void setState(String state)
	{
		txtState.sendKeys(state);
	}
	public void setPin(int pinCode)
	{
		txtPin.sendKeys(String.valueOf(pinCode));
	}
	public void setPhone(String tel)
	{
		txtTel.sendKeys(tel);
	}
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setPass(String pass)
	{
		txtpass.sendKeys(pass);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}
		
	
}
