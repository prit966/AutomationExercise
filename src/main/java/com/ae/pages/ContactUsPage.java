package com.ae.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	
	WebDriver driver;
	
	//objects
	
	@FindBy(name = "name")
	WebElement NameField;
	
	@FindBy(name = "email")
	WebElement EmailIDField;
	
	@FindBy(name = "subject")
	WebElement SubjectField;
	
	@FindBy(name = "message")
	WebElement MessageField;
	
	@FindBy(xpath = "//input[@name='upload_file']")
	WebElement uploadDocumentField;
	
	@FindBy(name = "submit")
	WebElement submitBtnField;
	
	public ContactUsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions

	 public void enterNameField(String nameText)
	 {
		 NameField.sendKeys(nameText);
	 }
	 
	 public void enterEmailIdField(String emailText)
	 {
		 EmailIDField.sendKeys(emailText);
	 }
	 
	 public void enterSubjectField(String subjectText)
	 {
		 SubjectField.sendKeys(subjectText);
	 }
	 
	 public void enterMessageField(String messageText)
	 {
		 MessageField.sendKeys(messageText);
	 }
	 
	 public void clickOnUploadDocumentField()
	 {
		 uploadDocumentField.sendKeys("C:\\Users\\Priti Pawar\\Desktop\\Automationgroup1.txt");
	 }
	 
	 public void clickOnSubmitButton()
	 {
		 submitBtnField.click();
	 }
	 
	 public void contactUsFormWithValidDetails(String nameText, String emailText, String subjectText, String messageText)
	 {
		 NameField.sendKeys(nameText);
		 EmailIDField.sendKeys(emailText);
		 SubjectField.sendKeys(subjectText);
		 MessageField.sendKeys(messageText);
		 uploadDocumentField.sendKeys("C:\\\\Users\\\\Priti Pawar\\\\Desktop\\\\Automationgroup1.txt");
		 submitBtnField.click();
	 }
}
