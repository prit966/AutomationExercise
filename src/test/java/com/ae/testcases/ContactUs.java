package com.ae.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ae.base.Base;
import com.ae.pages.ContactUsPage;
import com.ae.pages.HomePage;

public class ContactUs extends Base {
	
	WebDriver driver;
	
	public ContactUs()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() {
		driver = initializeBrowser(prop.getProperty("browserName"));
     
		 HomePage homepage = new HomePage(driver);
		homepage.clickOnContactUsOption();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void pageVisibility()
	{
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-sm-12']/h2")).isDisplayed(), "Contact us header is not visible");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='contact-form']/h2")).isDisplayed(),"GET IN TOUCH form heading is not visible");
	}
	
	@Test(priority = 2)
	public void contactusFormWithValidDetails()
	{
		ContactUsPage cup = new ContactUsPage(driver);
		cup.contactUsFormWithValidDetails(dataprop.getProperty("nameField"), 
																   dataprop.getProperty("emailField"), 
																   dataprop.getProperty("subjectField"), 
																   dataprop.getProperty("messageField"));
		
		/*cup.enterNameField(dataProp.getProperty("nameField"));
		cup.enterEmailIdField(dataProp.getProperty("emailField"));
		cup.enterSubjectField(dataProp.getProperty("subjectField"));
		cup.enterMessageField(dataProp.getProperty("messageField"));
		cup.clickOnUploadDocumentField();
		cup.clickOnSubmitButton();*/
		driver.switchTo().alert().accept();
	}
	/*
	@Test
	public void contactusFormWithInvalidDetails()
	{
		driver.findElement(By.name("name")).sendKeys("Supriya");
		driver.findElement(By.name("email")).sendKeys("khambesupriya10gmail.com");
		driver.findElement(By.name("subject")).sendKeys("About course enquiry");
		driver.findElement(By.id("message")).sendKeys("Want to know details about automation testing course");
		WebElement upload = driver.findElement(By.xpath("//input[@name='upload_file']"));
		upload.sendKeys("C:\\Users\\hp\\Desktop\\introduction.txt");
		driver.findElement(By.name("submit")).click();
		driver.switchTo().alert().accept();
	}*/
}
