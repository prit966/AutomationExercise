package com.ae.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.ae.base.Base;

public class Register extends Base {
	WebDriver driver;
	@BeforeMethod
	public void setup() {

		driver = initializeBrowser(prop.getProperty("browserName"));
		//HomePage homepage=new HomePage(driver);
		//homepage.clickonsignupbtn();
}
}