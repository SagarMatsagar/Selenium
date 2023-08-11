package Selenium.Selenium;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertEqual {
	WebDriver driver = null;
	@BeforeSuite
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		 chromeOptions.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(chromeOptions);

		//driver = new ChromeDriver();
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Reporter.log("Screen maximize");
		driver.get("https://www.javatpoint.com/");
	}
	@Test (priority = 1)
	public void checkTitle() {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Tutorials List - Javatpoint");
	}
	@SuppressWarnings("deprecation")
	@Test(priority = 2)
	public void seleniumTest() {
		driver.findElement(By.xpath("//a[text()=' Selenium']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actualHeading = driver.findElement(By.xpath("//h1[text()='Selenium Tutorial']")).getText();
		Assert.assertEquals(actualHeading, "Selenium Tutorial");
		driver.findElement(By.xpath("//a[text()=' Appium']")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.javatpoint.com/appium");
	}
	
	@AfterSuite
	void terminate() {
		driver.close();
	}
}
