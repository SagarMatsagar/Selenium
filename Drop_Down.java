package SeleniumAd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drop_Down {
	 WebDriver driver= null;
	public static Select select;

	@BeforeSuite
	public void setup () {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void fbReg() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@id = 'reg_pages_msg']/preceding::a[1]")).click();
		
		driver.findElement(By.name("firstname")).sendKeys("Sagar");
		driver.findElement(By.name("lastname")).sendKeys("Matsagar");
		driver.findElement(By.xpath("//input[@name=\"reg_email__\"]")).sendKeys("7777774444");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Sagar1223");
		
		//Select Class Dropdown
		Thread.sleep(3000);
	    select = new Select(driver.findElement(By.id("day")));
		select.selectByVisibleText("9");
		
		 select = new Select(driver.findElement(By.id("month")));
		 select.selectByVisibleText("Oct");
		 
		 select = new Select(driver.findElement(By.id("year")));
		 select.selectByVisibleText("2001");
		 
		 //Select Radio box		
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//input[@value=\"2\"and@name=\"sex\"]")).click();
		 
		 
		 }
	@AfterSuite
	public void terminate() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
