package Selenium.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class FlipkartTest {

	WebDriver driver = null;
	
	@BeforeSuite
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		
	}
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void launchAZ() {
		driver.get("https://www.flipkart.in/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
	}
	@Test (priority = 0)
	public void launchAmazon() {
//		String actualTitle = driver.getTitle();
//		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
//		System.out.println(actualTitle);
//		Assert.assertEquals(expectedTitle, actualTitle);
		
	}
	@SuppressWarnings("deprecation")
	@Test (priority = 1)
	public void search() {
		driver.findElement(By.id("q")).sendKeys("OnePlus 10R 5G");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElement(By.id("nav-search-submit-button")).click();
    
	}
	@SuppressWarnings("deprecation")
	@Test (priority = 2)
	public void addToCart() {
		driver.get("https://www.amazon.in/OnePlus-Forest-Green-Storage-SuperVOOC/dp/B09WRMNJ9G/ref=sr_1_4?keywords=OnePlus%2B10R%2B5G&qid=1679906784&sr=8-4&th=1");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input#add-to-cart-button")).submit();
		driver.findElement(By.cssSelector("a#nav-cart")).click();
		
	}	
	@AfterSuite
	public void terminate() {
		driver.quit();
	}
	
}
