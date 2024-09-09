package com.ae.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ae.utilities.Utilities;
import java.util.Properties;

public class Base {
	WebDriver driver;
	
	public Properties prop;
	public Properties dataprop;
	
	public Base()//constructor
{
	prop=new Properties();
	File propFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ae\\config\\config.properties");
	dataprop=new Properties();
	File datapropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ae\\testdata\\testdata.properties");
	try {
		FileInputStream datafis=new FileInputStream(datapropFile);
	dataprop.load(datafis);
	}catch(Exception e) {
		e.printStackTrace();
	}
	try {
		FileInputStream fis=new FileInputStream(propFile);
		prop.load(fis);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
	
	
		
}
	
	
	
	
	
	
	
	
	
	public WebDriver initializeBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
	
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.implicit_wait_time));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.page_load_time));
        driver.get(prop.getProperty("url"));
		
	
		return driver;
	}

	
}

