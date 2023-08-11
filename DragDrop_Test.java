package SeleniumAd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.firefox.FirefoxDriver;  
import org.openqa.selenium.interactions.Actions;  

public class DragDrop_Test {
	 public static void main(String[] args) {  
         
//	        	WebDriverManager.firefoxdriver().setup();
//	            WebDriver driver= new FirefoxDriver();  
		 	WebDriverManager.chromedriver().setup();
	        ChromeOptions chromeOptions = new ChromeOptions();
			 chromeOptions.addArguments("--remote-allow-origins=*");
			 WebDriver driver = new ChromeDriver(chromeOptions);			
			 driver.manage().window().maximize();
	        // Launch Website  
	            //driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");   
			 driver.navigate().to("https://sagarmatsagar.github.io/Projects/DragDrop/");
			 
	        //WebElement on which drag and drop operation needs to be performed  
	            WebElement from = driver.findElement(By.xpath("//div[@class='list']/div[2]"));  
	  
	        //WebElement to which the above object is dropped  
	            WebElement to = driver.findElement(By.xpath("//div[@class='lists']/div[2]"));  
	               
	        //Creating object of Actions class to build composite actions  
	            Actions act = new Actions(driver);  
	               
	        //Performing the drag and drop action  
	            act.dragAndDrop(from,to).build().perform();   
	    }  
}
