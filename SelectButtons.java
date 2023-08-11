package Selenium.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;  
import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectButtons {
	
	public static void main(String[] ar) {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);
		
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
		
		driver.findElement(By.id("checkbox1")).click();
		driver.findElement(By.id("checkbox2")).click();
		driver.findElement(By.id("checkbox3")).click();
		driver.findElement(By.id("msdd")).click();
		driver.findElement(By.linkText("Hindi")).click();
		
		driver.findElement(By.id("imagesrc")).sendKeys("C:\\Users\\a865093\\eclipse-workspace\\ExcelFiles\\img.jpg");
		
		Select skilldropdown = new Select(driver.findElement(By.id("Skills")));  
		skilldropdown.selectByVisibleText("Adobe Photoshop");
		
		Select countriesdropdown = new Select(driver.findElement(By.id("countries")));  
		countriesdropdown.selectByVisibleText("");  
		
//		driver.findElement(By.className("select2-selection select2-selection--single")).click();
//		driver.findElement(By.className("select2-search__field")).sendKeys("india");
//		driver.findElement(By.className("select2-results__option select2-results__option--highlighted")).click();
		
//		Select country = new Select(driver.findElement(By.id("country")));
//		country.selectByVisibleText("India");
		
		WebElement iframe = driver.findElement(By.cssSelector("body > iframe"));

		//Switch to the frame
		driver.switchTo().frame(iframe);

		//Now we can click the button
		driver.findElement(By.tagName("button")).click();
	}

}
