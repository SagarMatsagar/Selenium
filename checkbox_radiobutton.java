package SeleniumAd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkbox_radiobutton {
	WebDriver driver = null;
	private static Logger demoLogger = LogManager.getLogger(checkbox_radiobutton.class.getClass());
		@BeforeSuite
		public void setup(){
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions(); 
			chromeOptions.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(chromeOptions);
		
			driver.manage().window().maximize();
		}
		@Test
		public void checkBox() throws InterruptedException  {
			driver.get("https://the-internet.herokuapp.com/checkboxes");
			WebElement chbk1=driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
			Thread.sleep(3000);
			chbk1.click();
			demoLogger.info("First CheckBox Clicked");
			WebElement chbk2=driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
			Thread.sleep(3000);
			chbk2.click();
			demoLogger.info("Second CheckBox Clicked");
			driver.close();			
		}

}
