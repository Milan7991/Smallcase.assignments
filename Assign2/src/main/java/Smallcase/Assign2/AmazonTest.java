package Smallcase.Assign2;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjectsAmazon.SearchResultAmazon;
import pageObjectsAmazon.SearchToCartAmazon;

public class AmazonTest extends BaseClass {
	
	
	
	public int cartIntPriceAmazon;
	public int getCartIntPriceAmazon() {
		return cartIntPriceAmazon;
	}
	
	@Test
	public void navigateTo() throws IOException {
		driver = initializeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();

	}

	@Test
	public void searchItem() throws InterruptedException {
		SearchResultAmazon sp1 = new SearchResultAmazon(driver);
		sp1.searchInput().click();
		sp1.searchInput().sendKeys("iphone 12 mini 64 white");
		sp1.searchBut().click();
		Thread.sleep(3000);
	}

	@Test
	public void selectItem() throws InterruptedException {

		SearchToCartAmazon sr1 = new SearchToCartAmazon(driver);
		List<WebElement> searchResult = sr1.searchResult();
		for(int i=0; i<searchResult.size();i++)
		{
			String item = searchResult.get(i).getText();
			//if(item.contains("iphone 12") && item.contains("64") && item.contains("white"))
			if(item.contains("iPhone 12 Mini (64GB)")&& item.endsWith("White"))
			{
		searchResult.get(i).click();
		break;
			}
			
		}
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow);
		Thread.sleep(2000);
		
		String initialPrice = sr1.price().getText();
		System.out.println("Price is = " + initialPrice);
		sr1.addtoCart().click();
		Thread.sleep(3000);
		sr1.cart().click();
		String cartPriceAmazon = sr1.newPrice().getText();
		System.out.println("Price after added in cart = ₹" + cartPriceAmazon);
		
		driver.quit();	
		cartIntPriceAmazon= Integer.parseInt(cartPriceAmazon.replaceAll("[₹, ]+",""));
	    
	    driver.quit();		
		
		 
	}
	

}
