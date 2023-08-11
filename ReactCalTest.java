package SeleniumAd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class ReactCalTest {
	
	WebDriver driver =null;
	
	@BeforeSuite
	public void setup() {
		WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);	
		driver.manage().window().maximize();
		driver.get("https://sagarmatsagar.github.io/react_cal/");
	}
	
	@Test
	public void addition() throws InterruptedException {
		driver.findElement(By.xpath("//div[@data-value='2']")).click();
		driver.findElement(By.xpath("//div[@data-value='1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@data-value='+']")).click();
		driver.findElement(By.xpath("//div[@data-value='4']")).click();
		driver.findElement(By.xpath("//div[@data-value='2']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@data-value='+']")).click();
		driver.findElement(By.xpath("//div[@data-value='8']")).click();
		driver.findElement(By.xpath("//div[@data-value='0']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@data-value='equal']")).click();
		String ActualAns = driver.findElement(By.xpath("//div[@class='Display']")).getText();
		Assert.assertEquals(ActualAns, "143");
		Thread.sleep(3000);	
		driver.findElement(By.xpath("//div[@data-value='C']")).click();
	}
	
	@Test
	public void substraction() throws InterruptedException {
		driver.findElement(By.xpath("//div[@data-value='2']")).click();
		driver.findElement(By.xpath("//div[@data-value='1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@data-value='-']")).click();
		driver.findElement(By.xpath("//div[@data-value='1']")).click();
		driver.findElement(By.xpath("//div[@data-value='2']")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//div[@data-value='equal']")).click();
		String ActualAns = driver.findElement(By.xpath("//div[@class='Display']")).getText();
		Assert.assertEquals(ActualAns, "9");
		Thread.sleep(3000);	
		driver.findElement(By.xpath("//div[@data-value='C']")).click();		
	}
	@Test
	public void findSquare() throws InterruptedException {
		driver.findElement(By.xpath("//div[@data-value='2']")).click();
		driver.findElement(By.xpath("//div[@data-value='1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@data-value='*']")).click();
		driver.findElement(By.xpath("//div[@data-value='2']")).click();
		driver.findElement(By.xpath("//div[@data-value='1']")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//div[@data-value='equal']")).click();
		String ActualAns = driver.findElement(By.xpath("//div[@class='Display']")).getText();
		Assert.assertEquals(ActualAns, "9");
		Thread.sleep(3000);	
		driver.findElement(By.xpath("//div[@data-value='C']")).click();		
	}
	@AfterSuite
	public void terminate() {
		driver.quit();
	}
}
