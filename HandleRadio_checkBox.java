package SeleniumAd;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleRadio_checkBox {
	WebDriver driver = null;
	private static Logger demoLogger = LogManager.getLogger(HandleRadio_checkBox.class.getClass());
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
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		
		WebElement Male = driver.findElement(By.xpath("//input[@name='male' and @type='radio'][2]"));
		Male.click();
		Thread.sleep(1000);
		
		List<WebElement> radio=driver.findElements(By.xpath("//input[@name='lang' and @type='radio']"));

			for(int i=0;i<radio.size();i++)
			{
				WebElement local_radio = radio.get(i);
				String value=local_radio.getAttribute("value");
				demoLogger.info("Values from Radio Buttons are =========>>>>>>>>>>>"+value);
				
				local_radio.click();
				Thread.sleep(1000);				
			}
			
			List<WebElement> checkbox=driver.findElements(By.xpath("//input[@type='checkbox']"));
			
			for(int i=0; i<checkbox.size(); i++)
			{
				WebElement local_checkbox = checkbox.get(i);
				String id=local_checkbox.getAttribute("id");
				demoLogger.info("Values from Checkboxes are =========>>>>>>>>>>>"+id);
				
				local_checkbox.click();		
				Thread.sleep(1000);
				if(i==0) {local_checkbox.click();}
			}
			
		}
	@AfterSuite
	public void terminate() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	}
