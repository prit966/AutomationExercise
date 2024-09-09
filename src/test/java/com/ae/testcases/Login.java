package com.ae.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ae.base.Base;
import com.ae.pages.HomePage;
import com.ae.pages.LoginPage;
import com.ae.pages.LoginSuccessPage;
import com.ae.utilities.Utilities;


public class Login extends Base {

	
	
	
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = initializeBrowser(prop.getProperty("browserName"));
     
		
		 
		HomePage homepage = new HomePage(driver);
	    homepage.clickOnLoginOption();
		}

	@Test(priority = 1)
	public void verifyLoginWithCorrectCredentials() {
		
		
		

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(prop.getProperty("validemail"));
		loginpage.enterPassword(prop.getProperty("validpassword"));
	    loginpage.clickOnLoginButton();
		
		LoginSuccessPage loginSuccessPage=new LoginSuccessPage(driver);
		Assert.assertTrue(loginSuccessPage.displayloggedInAccount(),"Logged in as priti not displayed");
		
		
		
	}

    @Test(priority = 2)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
    	
    	LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		loginpage.enterPassword(prop.getProperty("validpassword"));
		loginpage.clickOnLoginButton();
		Assert.assertTrue(loginpage.retrieveEmailPasswordWarningMessage().contains(dataprop.getProperty("emailpasswordNotMatchWarning")),"Expected message not displayed");
		
		
	}
    
    @Test(priority = 3)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
    	
    	LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(prop.getProperty("validemail"));
		loginpage.enterPassword(dataprop.getProperty("invalidpassword"));
		loginpage.clickOnLoginButton();
		Assert.assertTrue(loginpage.retrieveEmailPasswordWarningMessage().contains(dataprop.getProperty("emailpasswordNotMatchWarning")),"Expected message not displayed");
		
        
	}
	@Test(priority = 4)
	public void verifyLoginWithInvalidCredentials() {
		
		
		
		//code3
        LoginPage loginpage = new LoginPage(driver);
        
		loginpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		loginpage.enterPassword(dataprop.getProperty("invalidpassword"));
	    loginpage.clickOnLoginButton();
		Assert.assertTrue(loginpage.retrieveEmailPasswordWarningMessage().contains(dataprop.getProperty("emailpasswordNotMatchWarning")),"Expected message not displayed");
		
		
		
		
		//codw2
		//Assert.assertTrue(loginpage.displayloginYourAccount(),"Login to your account is not visible");
		 //loginpage.login(Utilities.generateEmailWithTimeStamp(),dataprop.getProperty("invalidpassword"));
		//loginpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		//loginpage.enterPassword(dataprop.getProperty("invalidpassword"));
		//loginpage.clickOnLoginButton();
		//Assert.assertTrue(loginpage.retrieveEmailPasswordWarningMessage().contains(dataprop.getProperty("emailpasswordNotMatchWarning")),"Expected message not displayed");
		
		//code 1
		/*Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed(),
				"Login to your account is not visible");
		driver.findElement(By.name("email")).sendKeys(Utilities.generateEmailWithTimeStamp());

		driver.findElement(By.name("password")).sendKeys(dataprop.getProperty("invalidpassword"));
		driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
		String actualwarningmessage = driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']"))
				.getText();
		String expectedmessage = dataprop.getProperty("emailpasswordNotMatchWarning");
		Assert.assertTrue(actualwarningmessage.contains(expectedmessage), "Expect message not displayed");
         */
		
		
		
	}
		
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
