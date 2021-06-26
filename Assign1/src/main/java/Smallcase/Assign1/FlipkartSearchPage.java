package Smallcase.Assign1;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageobjects.*;

public class FlipkartSearchPage extends BaseClass{
	//created obj of SearchPage which contains elements
	
	
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
	SearchPage sp1 = new SearchPage(driver);
	sp1.searchInput().click();
	sp1.searchInput().sendKeys("iphone 12 mini 64 white");
	sp1.searchBut().click();
	Thread.sleep(3000);
}
@Test
public void selectItem() throws InterruptedException
{
	SearchToCart sr1 = new SearchToCart(driver);
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
		List<WebElement> add1More = sr1.addOneMore();
		add1More.get(1).click();
		Thread.sleep(2000);
		System.out.println(sr1.success().getText());
		String updatedPrice = sr1.newPrice().getText();
		System.out.println("Updated Price = "+updatedPrice );
		driver.quit();
	
}



}
