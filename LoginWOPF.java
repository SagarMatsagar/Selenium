package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginWOPF {
	WebDriver driver;
	LoginWOPF(WebDriver d){
		driver = d;
	}
	
	By username = By.id("user-name");
	By password = By.id("password");
	By loginbtn = By.id("login-button");
	
	public void enterUserName(String uname) {
		driver.findElement(username).sendKeys(uname);
	}
	
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	public void clickLoginBtn() {
		driver.findElement(loginbtn).click();
		System.out.println("Login Successfully");
	}
}
