package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginWPF {
	WebDriver driver;
	LoginWPF(WebDriver d){
		driver = d;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="user-name")WebElement username;
	@FindBy(id="password")WebElement password;
	@FindBy(id="login-button")WebElement loginbtn;
	@FindBy(id="react-burger-menu-btn")WebElement menubtn;
	@FindBy(id="logout_sidebar_link")WebElement logoutbtn;
	
	public void enterUserName(String uname) {
		Assert.assertEquals(uname, "standard_user", "User Name Does't Match.");
		username.sendKeys(uname);
	}
	public void enterPassword(String pass) {
		Assert.assertEquals(pass, "secret_sauce", "Password Does't Match.");
		password.sendKeys(pass);
	}
	public void clickLoginBtn() {
		loginbtn.click();
		System.out.println("Login Successfully with Page Factory");
	}
	public void clickLogoutBtn() throws InterruptedException {
		menubtn.click();
		Thread.sleep(2000);
		logoutbtn.click();
		System.out.println("Logout Successfully with Page Factory");
	}
}
