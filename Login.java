package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	String UserName = "standard_user2";
	String Pass = "secret_sauce2";
	public void withoutPF(WebDriver d){
		LoginWOPF l1 = new LoginWOPF(d);
		l1.enterUserName(UserName);
		l1.enterPassword(Pass);
		l1.clickLoginBtn();
	}
	public void withPF(WebDriver d) throws InterruptedException{
		LoginWPF l2 = new LoginWPF(d);
		l2.enterUserName(UserName);
		l2.enterPassword(Pass);
		Thread.sleep(3000);
		l2.clickLoginBtn();
		Thread.sleep(3000);
		l2.clickLogoutBtn();
		Thread.sleep(3000);
	}
	@Test
	public void Test() throws InterruptedException {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		Login obj = new Login();
		
		driver.get("https://www.saucedemo.com/");
		//obj.withoutPF(driver);
		obj.withPF(driver);
		
		driver.quit();
		
		
	}
}
