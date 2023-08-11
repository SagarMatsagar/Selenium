package SeleniumAd;

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

public class AmazonTest {

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
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
	}
	@Test (priority = 1)
	public void launchAmazon() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		System.out.println(actualTitle);
		Assert.assertEquals(expectedTitle, actualTitle);
		
	}
	@Test (priority = 2)
	public void search() throws InterruptedException {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("OnePlus 10R 5G");
		Thread.sleep(3000);
    	driver.findElement(By.id("nav-search-submit-button")).click();
    
	}
	
	@Test (priority = 3)
	public void addToCart() throws InterruptedException {
		driver.get("https://www.amazon.in/OnePlus-Forest-Green-Storage-SuperVOOC/dp/B09WRMNJ9G/ref=sr_1_4?keywords=OnePlus%2B10R%2B5G&qid=1679906784&sr=8-4&th=1");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#add-to-cart-button")).submit();
		driver.findElement(By.cssSelector("a#nav-cart")).click();
		
	}	
	@AfterSuite
	public void terminate() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
}
