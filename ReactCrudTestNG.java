package SeleniumAd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReactCrudTestNG {
	WebDriver driver = null;
	@BeforeSuite
	public void setup() throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions(); 
    	chromeOptions.addArguments("--remote-allow-origins=*");
    	driver = new ChromeDriver(chromeOptions);
    	driver.manage().window().maximize();
	}
	@Test
	public void test1() throws InterruptedException {
		
		driver.get("https://amitm368.github.io/react_crud/");
		Reporter.log("Website Successfully launched.");
		
		driver.findElement(By.xpath("//div[@class='header-right']/a/p")).click();
		Reporter.log("Click on 'Home' Button.");
		sleep();
//		String currentUrl = driver.getCurrentUrl();
//		if(Assert.assertEquals(Url, currentUrl))
		driver.findElement(By.xpath("//div[@class='header-right']/a[2]/p")).click();
		Reporter.log("Click on 'Add Contact' Button.");
		sleep();	
		driver.findElement(By.id("emp")).sendKeys("75757575");
		driver.findElement(By.name("name")).sendKeys("Sagar Matsagar");	
		driver.findElement(By.id("email")).sendKeys("shiv18@gmail.com");	
		driver.findElement(By.id("contact")).sendKeys("9999881177");	
		driver.findElement(By.xpath("//input[contains(@id,'maritalstatus')][2]")).click();
		driver.findElement(By.xpath("//select/option[2]")).click();		
		driver.findElement(By.name("office1")).click();		
		driver.findElement(By.id("dateofjoining")).sendKeys("11-04-2022");		
		sleep();	
		// Slidder
		Actions actions = new Actions(driver); 
		WebElement salary = driver.findElement(By.xpath("//input[@id='salary']"));
		actions.moveToElement(salary);
		sleep();
		actions.clickAndHold().perform(); 
		
		driver.findElement(By.cssSelector("#root > div > div:nth-child(3) > form > div:nth-child(30) > label")).click();	
		sleep();
		driver.findElement(By.xpath("//input[@type='submit']")).submit();	
		Reporter.log("Successfully add the Detail.");
	}
		@AfterSuite
		public void closeDriver() throws InterruptedException {
		
		sleep();
		driver.quit();
	}
	
	static void sleep() throws InterruptedException {
		Thread.sleep(2000);	
	}

}
