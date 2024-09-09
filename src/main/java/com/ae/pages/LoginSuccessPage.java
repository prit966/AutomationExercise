package com.ae.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSuccessPage {
	
	WebDriver driver;
	
	
	@FindBy(xpath="//i[@class='fa fa-user']")
	private WebElement loggedAsUsername;
	
	
	
	//constructor
	public  LoginSuccessPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//actions
	public boolean displayloggedInAccount() {
		boolean loggedUsername=loggedAsUsername.isDisplayed();
		return loggedUsername;
	}
	
	
	
	
}
