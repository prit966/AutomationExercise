package com.ae.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	// object
	@FindBy(xpath = "//i[@class='fa fa-lock']")
	private WebElement loginOption;

	@FindBy(xpath = "//a[text()=' Contact us']")
	WebElement contactUsOption;

	// constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// actions

	public   void clickOnLoginOption()//public void  clickOnLoginOption()
	{
		loginOption.click();

		
	}
    
	
	public void clickOnContactUsOption()
	{
		contactUsOption.click();
	}
}
