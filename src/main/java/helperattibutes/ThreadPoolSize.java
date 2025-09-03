package helperattibutes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ThreadPoolSize {
	
	@Test(invocationCount = 6,threadPoolSize = 3)
	
	public void login() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Reporter.log("executed",true);
		Thread.sleep(2000);
		driver.quit();
	}

}
