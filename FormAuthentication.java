package SeleniumAd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormAuthentication {

	WebDriver driver = null;
	private static Logger demologger = LogManager.getLogger(FormAuthentication.class.getClass());
	@BeforeSuite
    public void setup () {									
    				
        //System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");		
    	WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
		 chromeOptions.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(chromeOptions);			
	}
	@Test
	public void test() throws InterruptedException {
			driver.get("http://the-internet.herokuapp.com/login");
			Thread.sleep(2000);
			
			driver.findElement(By.id("username")).sendKeys("tomsmith");
			driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
			driver.findElement(By.className("radius")).click();
			//demologger.info("Login Successfully.");
			Reporter.log("Login Succesfuly");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//i[text()=\' Logout\']")).click();
			//demologger.info("Logout Successfully.");
	}
	@AfterSuite
	public void terminate() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
