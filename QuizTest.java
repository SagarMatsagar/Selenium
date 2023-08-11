package SeleniumAd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuizTest {
	WebDriver driver = null;
	
	@BeforeSuite 
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions(); 
    	chromeOptions.addArguments("--remote-allow-origins=*");
    	driver = new ChromeDriver(chromeOptions);
    	driver.manage().window().maximize();
		
	}
	
	@Test
	public void quizStart() throws InterruptedException {
		driver.get("https://sagarmatsagar.github.io/Projects/Quiz/Quiz.html");
		
		driver.findElement(By.id("d")).click();		
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		
		driver.findElement(By.id("b")).click();		
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		
		driver.findElement(By.id("c")).click();	
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		
		driver.findElement(By.id("b")).click();	
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		
		System.out.println("Result : "+ driver.findElement(By.xpath("//div[@id=\"quiz\"]/h2")).getText()); 		
		Thread.sleep(2000);
	}
	@AfterSuite
	public void terminate() {
		driver.quit();
	}

}
