package SeleniumAd;


import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderDemo {
  @DataProvider(name = "data-provider")
  public Object[][] dataProviderMethod() {
      return new Object[][] { { "data one" }, { "data two" }, { "data three" } };
  }

  @Test(dataProvider = "data-provider")
  public void testMethod(String data) {
      System.out.println("Data is: " + data);
  }

}