package SeleniumAd;

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

import DemoForLog4j.Log4j;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Form {	
	WebDriver driver = null;
	private static Logger demoLogger = LogManager.getLogger(Form.class.getClass());
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
        driver.get("https://demo.guru99.com/test/radio.html");					
        WebElement radio1 = driver.findElement(By.id("vfb-7-1"));							
        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));							
        		
        //Radio Button1 is selected		
        radio1.click();			
        demoLogger.info("Radio Button Option 1 Selected");					
        Thread.sleep(2000);		
        //Radio Button1 is de-selected and Radio Button2 is selected		
        radio2.click();			
        demoLogger.info("Radio Button Option 2 Selected");					
        Thread.sleep(2000);				
        // Selecting CheckBox		
        WebElement option1 = driver.findElement(By.id("vfb-6-0"));							

        // This will Toggle the Check box 		
        option1.click();			

        // Check whether the Check box is toggled on 		
        if (option1.isSelected()) {					
        	demoLogger.info("Checkbox is Toggled On");					

        } else {			
        	demoLogger.info("Checkbox is Toggled Off");					
        }		
        Thread.sleep(2000);		
        		
        		
        //Selecting Checkbox and using isSelected Method		
        driver.get("https://demo.guru99.com/test/facebook.html");					
        WebElement chkFBPersist = driver.findElement(By.id("persist_box"));							
        for (int i=0; i<2; i++) {											
            chkFBPersist.click (); 			
            demoLogger.info("Facebook Persists Checkbox Status is -  "+chkFBPersist.isSelected());							
        }		        		
    }
	@AfterSuite
	public void terminate() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
