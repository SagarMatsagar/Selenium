package SeleniumAd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyAtosLogin {

	WebDriver driver = null;
	@BeforeSuite
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);		
		driver.manage().window().maximize();			
	}
	@Test
	 public void testWithValidData() {
		driver.get("https://wac.das.myatos.net/portal/pki.jsp?DXATargetMethod=GET&DXA-authn-method=Login+Selector&DXATargetUrl=http%3A%2F%2Fwac.das.myatos.net%2Fsso_myatos%2FSingleSignOnService%3FSigAlg%3Dhttp%253A%252F%252Fwww.w3.org%252F2000%252F09%252Fxmldsig%2523rsa-sha1%26SAMLRequest%3DfZLdasMwDIVfJXjXiZ00XRuTFErLoLD%252FjA12M7TEbQ2J3FnOsr39nLaju%252BkuJX3HOjo4n3dui4%252Fqo1PkgjmRsk4bXBikrlW2VPZTV2qFtfoqmGDB0mMaYWAKtnVuR5LzHqqoBorab3CGIlSOE5m3Q8lLjZtGlXqDd3h8jwWrZcHK8RTS%252BF1AmMEkDdMaxiEoMQoT377M4lRMp37liqjzDsgBuoIlIhmF4jJMsicxkUks00k0SbNXFjwrS3tbSeRVX22DVLDOojRAmiRCq0i6Spbzm2vpGbmzxpnKNEdYIiX%252FC%252BA3npMiPaQwhND3UT%252BKjN3wRIiYi5R7SGF1caJHZ2jBRTbQNenNBZvl3oncn21nA3jKNed%252FRvmtd7ha3ptGV9%252FBvGlMv7AKnCrYGhryKV8Z24I7f1QcxfuOrsP1HpUvGmvT09K0oPGhg0avtaqHRYzPcv73t8x%252BAA%253D%253D%26RelayState%3Douccmhkaapprr%26Signature%3Drq1xk8SbDiivksXhqzYk%252BBNCgJ9Mp8d5tIlowpS0KwIhVs%252B0jm0VJriL8pdQLYbzxvlCCraXTOxU075u8g1INhs7ikzbtOIgNHXtnswYymM74zgbAJ7Lwu34cLBGGFfdqNjU99wIK%252BQ6ArAq6sCbfXPiP51tunqXmu3%252BZm%252B%252BOQjWoc5kc3EQbdAxdeuGbVmQQ4I%252BN1jmraYX%252FXIdFQv5DLFn3PKfH8SECs9KmxXZ6fMGUDxyHa8VempU9Y7anmgyaVu%252FAI70e6z60kxpgpSzyR1DFdHewL9KZP7hTvgKZvGeQ16k1qVcQFcIQ%252F7dOAb0smB1%252F%252B4EdyrrHrwfJ0vmjg%253D%253D");
		driver.findElement(By.xpath("//*[@id=\"formDas\"]/button")).click(); 
		driver.findElement(By.xpath("//*[@id=\"dataForm\"]/fieldset/input[5]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"dataForm\"]/fieldset/input[6]")).sendKeys(""); 
		driver.findElement(By.xpath("//*[@id=\"dataForm\"]/fieldset/input[8]")).click();
	 }
	
	@Test
	 public void testWithInvalidData() {
		driver.get("https://wac.das.myatos.net/portal/pki.jsp?DXATargetMethod=GET&DXA-authn-method=Login+Selector&DXATargetUrl=http%3A%2F%2Fwac.das.myatos.net%2Fsso_myatos%2FSingleSignOnService%3FSigAlg%3Dhttp%253A%252F%252Fwww.w3.org%252F2000%252F09%252Fxmldsig%2523rsa-sha1%26SAMLRequest%3DfZLdasMwDIVfJXjXiZ00XRuTFErLoLD%252FjA12M7TEbQ2J3FnOsr39nLaju%252BkuJX3HOjo4n3dui4%252Fqo1PkgjmRsk4bXBikrlW2VPZTV2qFtfoqmGDB0mMaYWAKtnVuR5LzHqqoBorab3CGIlSOE5m3Q8lLjZtGlXqDd3h8jwWrZcHK8RTS%252BF1AmMEkDdMaxiEoMQoT377M4lRMp37liqjzDsgBuoIlIhmF4jJMsicxkUks00k0SbNXFjwrS3tbSeRVX22DVLDOojRAmiRCq0i6Spbzm2vpGbmzxpnKNEdYIiX%252FC%252BA3npMiPaQwhND3UT%252BKjN3wRIiYi5R7SGF1caJHZ2jBRTbQNenNBZvl3oncn21nA3jKNed%252FRvmtd7ha3ptGV9%252FBvGlMv7AKnCrYGhryKV8Z24I7f1QcxfuOrsP1HpUvGmvT09K0oPGhg0avtaqHRYzPcv73t8x%252BAA%253D%253D%26RelayState%3Douccmhkaapprr%26Signature%3Drq1xk8SbDiivksXhqzYk%252BBNCgJ9Mp8d5tIlowpS0KwIhVs%252B0jm0VJriL8pdQLYbzxvlCCraXTOxU075u8g1INhs7ikzbtOIgNHXtnswYymM74zgbAJ7Lwu34cLBGGFfdqNjU99wIK%252BQ6ArAq6sCbfXPiP51tunqXmu3%252BZm%252B%252BOQjWoc5kc3EQbdAxdeuGbVmQQ4I%252BN1jmraYX%252FXIdFQv5DLFn3PKfH8SECs9KmxXZ6fMGUDxyHa8VempU9Y7anmgyaVu%252FAI70e6z60kxpgpSzyR1DFdHewL9KZP7hTvgKZvGeQ16k1qVcQFcIQ%252F7dOAb0smB1%252F%252B4EdyrrHrwfJ0vmjg%253D%253D");
		driver.findElement(By.xpath("//*[@id=\"formDas\"]/button")).click(); 
		driver.findElement(By.xpath("//*[@id=\"dataForm\"]/fieldset/input[5]")).sendKeys("A998877");
		driver.findElement(By.xpath("//*[@id=\"dataForm\"]/fieldset/input[6]")).sendKeys("Password113"); 
		driver.findElement(By.xpath("//*[@id=\"dataForm\"]/fieldset/input[8]")).click();
	 }
	
	@AfterSuite
	public void terminate() {
		//driver.quit();
	}
}
