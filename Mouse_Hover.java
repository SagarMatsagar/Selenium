package SeleniumAd;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouse_Hover {	
	 @SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
	        String baseUrl = "http://demo.guru99.com/test/newtours/";
	        //System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
	        WebDriverManager.chromedriver().setup();
	    	ChromeOptions chromeOptions = new ChromeOptions(); 
	    	chromeOptions.addArguments("--remote-allow-origins=*");
	    	WebDriver driver = new ChromeDriver(chromeOptions);
	    	driver.manage().window().maximize();

	                driver.get(baseUrl);           
	                WebElement link_Home = driver.findElement(By.linkText("Home"));
	                WebElement td_Home = driver
	                        .findElement(By
	                        .xpath("//html/body/div"
	                        + "/table/tbody/tr/td"
	                        + "/table/tbody/tr/td"
	                        + "/table/tbody/tr/td"
	                        + "/table/tbody/tr"));    
	                 
	                Actions builder = new Actions(driver);
	                org.openqa.selenium.interactions.Action mouseOverHome = builder.moveToElement(link_Home).build();
	                 
	                String bgColor = td_Home.getCssValue("background-color");
	                System.out.println("Before hover: " + bgColor);        
	                mouseOverHome.perform(); 
	               // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	                Thread.sleep(3000);
	                bgColor = td_Home.getCssValue("background-color");
	                System.out.println("After hover: " + bgColor);
	                Thread.sleep(3000);
	                driver.close();
	        }
}
