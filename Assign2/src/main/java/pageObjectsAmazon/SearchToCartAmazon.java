package pageObjectsAmazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchToCartAmazon {
	public WebDriver driver;
	
	
	By result =By.cssSelector(".a-size-medium.a-color-base.a-text-normal");
	By Price =By.cssSelector(".a-size-medium.a-size-medium.a-color-price.priceBlockBuyingPriceString");
	By addCart= By.xpath("//input[@id='add-to-cart-button']");
	By goToCart = By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']");
	By newPrice = By.cssSelector(".a-size-medium.a-color-base.sc-price.sc-white-space-nowrap.sc-product-price.a-text-bold");
	
		
		public SearchToCartAmazon(WebDriver driver) {
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
		
		public WebElement newPrice()
		{
			return driver.findElement(newPrice);
		}
		public WebElement cart()
		{
			return driver.findElement(goToCart);
		}
		
}
