package pageObjectsAmazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultAmazon {

public WebDriver driver;
	
	
	By searchBox= By.xpath("//input[@id='twotabsearchtextbox']");
	By searchButton= By.xpath("//input[@id='nav-search-submit-button']");
	
	public SearchResultAmazon(WebDriver driver) {
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
