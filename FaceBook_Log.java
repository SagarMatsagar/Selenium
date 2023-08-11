package Selenium.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook_Log {
	
	WebDriver driver = null;
	
	@BeforeSuite
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		 chromeOptions.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(chromeOptions);

		//driver= new ChromeDriver();
		//Firefox
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void login() throws InterruptedException {
		driver.get("https://www.facebook.com/login.php/");
		driver.findElement(By.xpath("//input[@placeholder='Email address or phone number']")).sendKeys("sagarmatsagar21@gamil.com");
		driver.findElement(By.id("pass")).sendKeys("password123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id=\'loginbutton\']")).submit();

	}
	@Test
	
	public void assertEqual() {
		driver.get("https://www.facebook.com/login.php/");
		String ActualTableName = driver.findElement(By.xpath("//div[@id=\"header_block\"]//child::span/div")).getText();
		Assert.assertEquals(ActualTableName, "Log in to Facebook");
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, "Log in to Facebook");

	}

	@AfterSuite
	public void close() {
		driver.quit(); 
	}
}
