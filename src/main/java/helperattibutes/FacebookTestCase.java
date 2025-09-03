package helperattibutes;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FacebookTestCase {
	
	@Test(invocationCount = 3)
	
	public void Facebook() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Date d = new Date();
		String newdate = d.toString().replace(" ", " _").replace(":", "_");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File("./Screenshots/takeScreenshot"+newdate+".png");
		org.openqa.selenium.io.FileHandler.copy(temp, perm);
		Reporter.log("execution done",true);
		Thread.sleep(3000);
	}
	

}
