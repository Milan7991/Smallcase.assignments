package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

	public WebDriver driver;
	
	
	By searchBox= By.cssSelector("input._3704LK");
	By searchButton= By.cssSelector("button.L0Z3Pu");
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement searchInput()
	{
		return driver.findElement(searchBox);
	}
	public WebElement searchBut()
	{
		return driver.findElement(searchButton);
	}
}
