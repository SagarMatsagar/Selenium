package Selenium.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class ReactCrud {
	 
	public static void main(String[] ar) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions(); 
    	chromeOptions.addArguments("--remote-allow-origins=*");
    	WebDriver driver = new ChromeDriver(chromeOptions);
    	driver.manage().window().maximize();
		
	
		driver.get("https://amitm368.github.io/react_crud/");
		
		driver.findElement(By.xpath("//div[@class='header-right']/a/p")).click();		
		Thread.sleep(2000);
//		String currentUrl = driver.getCurrentUrl();
//		if(Assert.assertEquals(Url, currentUrl))
		driver.findElement(By.xpath("//div[@class='header-right']/a[2]/p")).click();		
		sleep();	
		driver.findElement(By.id("emp")).sendKeys("11223344");
		driver.findElement(By.name("name")).sendKeys("Shiv Matsagar");	
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
		
		
		
		
		sleep();
		driver.quit();
	}
	
	static void sleep() throws InterruptedException {
		Thread.sleep(2000);	
	}

}

