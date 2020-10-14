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
		
	
}
