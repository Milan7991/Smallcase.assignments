package Smallcase.Assign1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public WebDriver driver;
	public WebDriver initializeDriver() throws IOException 
	{
	Properties propfile= new Properties();
	FileInputStream file= new FileInputStream("//home//milan//eclipse-workspace//Assign1//src//main//java//Smallcase//Assign1//data.properties");
	propfile.load(file);
	String browserName = propfile.getProperty("browser");
	
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "//home//milan//Downloads//chromedriver");
	    driver = new ChromeDriver();
	}
	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	return driver;
	}
	}
