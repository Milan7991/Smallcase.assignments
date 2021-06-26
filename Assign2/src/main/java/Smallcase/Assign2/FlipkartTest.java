package Smallcase.Assign2;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import pageObjectsFlipKart.SearchResultFlipkart;
import pageObjectsFlipKart.SearchToCartFlipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlipkartTest extends BaseClass{
	
	
	public int cartIntPriceFlipkart;
	
	public int getCartIntPriceFlipkart() {
		return cartIntPriceFlipkart;
	}
	

	
@Test	
public void navigateTo() throws IOException
{
	driver=initializeDriver();
	driver.get("https://www.flipkart.com");
	driver.manage().window().maximize();
	driver.findElement(By.cssSelector("button._2doB4z")).click();	
		
}
@Test
public void searchItem() throws InterruptedException
{
	SearchResultFlipkart sp1 = new SearchResultFlipkart(driver);
	sp1.searchInput().click();
	sp1.searchInput().sendKeys("iphone 12 mini 64 white");
	sp1.searchBut().click();
	Thread.sleep(3000);
}
@Test
public void selectItem() throws InterruptedException
{
	SearchToCartFlipkart sr1 = new SearchToCartFlipkart(driver);
	List<WebElement> searchResult = sr1.searchResult();
	searchResult.get(0).click();
	
	
	 Set<String> windows= driver.getWindowHandles(); 
	 Iterator<String> it = windows.iterator(); 
	 String parentWindow= it.next(); 
			 String childwindow=  it.next(); 
			 driver.switchTo().window(childwindow); 
			 Thread.sleep(2000);
			 
			 String initialPrice = sr1.price().getText();
		System.out.println("Price is = "+initialPrice );	
		sr1.addtoCart().click();
		Thread.sleep(2000);
		
		String cartPriceFlipkart = sr1.newPrice().getText();
		System.out.println("Price after added in cart = "+cartPriceFlipkart);
		
		cartIntPriceFlipkart= Integer.parseInt(cartPriceFlipkart.replaceAll("[₹, ]+",""));
		
		driver.quit();
		
		
	
}






}
