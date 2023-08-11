package SeleniumAd;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {
	
	public static void main(String[] ar) {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);
		
		driver.manage().window().maximize();	
		//driver.get("https://www.redbus.in/ ");
		driver.get("https://www.redbus.in/online-booking/msrtc");

		driver.findElement(By.id("srcid")).sendKeys("Pune");
		driver.findElement(By.id("txtDestination")).sendKeys("Chhatrapati Sambhajinagar");
		driver.findElement(By.id("txtOnwardCalendar")).click();
		//driver.findElement(By.xpath("//*[@id=\"DC120_sw_main\"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"rb-calmiddle\"]/ul[2]/li[33]/span")).click();
	}

}
