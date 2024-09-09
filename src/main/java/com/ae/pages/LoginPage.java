package com.ae.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath="//h2[text()='Login to your account']")
	private WebElement  loginYouraccount;

	@FindBy(name="email")
	private WebElement emailAddressField;
	
	@FindBy(name="password")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@data-qa='login-button']")
	private WebElement loginButton;
	
	@FindBy(xpath="//p[text()='Your email or password is incorrect!']")
	private WebElement emailPasswordNotMatching;
	
	
	
	//constructor

	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//actions
	
	public boolean displayloginYourAccount () {
		boolean loginAccountText=loginYouraccount.isDisplayed();
		return loginAccountText;
	}
	
	
	public void enterEmailAddress(String emailText) {
		emailAddressField.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText)
	{
		passwordField.sendKeys(passwordText);
	}
	
	
	public void clickOnLoginButton() //public void clickOnLoginButton()
	{
		
		loginButton.click();
		
	}

	

	
	public String retrieveEmailPasswordWarningMessage() {
		String warningText=emailPasswordNotMatching.getText();
		return warningText;
	}
	
}
