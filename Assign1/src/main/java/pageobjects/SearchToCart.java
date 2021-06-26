package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchToCart {
public WebDriver driver;
	
	
By result =By.cssSelector("div._4rR01T");
By Price =By.cssSelector("._30jeq3._16Jk6d");
By addCart= By.cssSelector("button._2KpZ6l._2U9uOA._3v1-ww");
By add1More = By.cssSelector("button._23FHuj");
By newPrice = By.cssSelector("._2-ut7f._1WpvJ7");
By successMsg = By.cssSelector("._2sKwjB");
	
	public SearchToCart(WebDriver driver) {
		this.driver=driver;
	}
	public List<WebElement> searchResult()
	{
		return driver.findElements(result);
	}
	public WebElement price()
	{
		return driver.findElement(Price);
	}
	public WebElement addtoCart()
	{
		return driver.findElement(addCart);
	}
	public List<WebElement> addOneMore()
	{
		return driver.findElements(add1More);
	}
	public WebElement newPrice()
	{
		return driver.findElement(newPrice);
	}
	public WebElement success()
	{
		return driver.findElement(successMsg);
	}
}
