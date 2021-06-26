package Smallcase.Assign2;

import org.testng.annotations.Test;

import pageObjectsAmazon.SearchToCartAmazon;
import Smallcase.Assign2.*;

public class PriceCompare extends BaseClass {

	@Test
	public void comparePrices() {
		
		FlipkartTest ft1 = new FlipkartTest();
		AmazonTest at1 = new AmazonTest();
		
		//System.out.println(ft1.getCartIntPriceFlipkart());
		 int priceFlip = ft1.getCartIntPriceFlipkart();
		 int priceAmz = at1.getCartIntPriceAmazon();
		 System.out.println("-------");
		if (priceFlip < priceAmz) {
			System.out.println("Flipkart is providing the searched item at a cheaper rate");
		} else if (priceFlip > priceAmz) {
			System.out.println("Amazon is providing the searched item at a cheaper rate");
		} else if (priceFlip == priceAmz) {
			System.out.println("Prices of the searched item are equal");
		}

	}

}
