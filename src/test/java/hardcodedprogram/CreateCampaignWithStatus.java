package hardcodedprogram;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateCampaignWithStatus {
	public static void main(String[] args) throws InterruptedException {
		//launch the browser
				WebDriver driver = new EdgeDriver();
				
				//maximize window
				driver.manage().window().maximize();
				
				//implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
				
				//navigate to url
				driver.get("http://49.249.28.218:8098/");
				
				//Enter credentials for login
				driver.findElement(By.id("username")).sendKeys("rmgyantra");
				driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
				
				//click on login button
				driver.findElement(By.xpath("//button[@type='submit']")).submit();
				
				//click on create campaign button
				driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
				
				//enter test data to create campaign module
				WebElement campaignName = driver.findElement(By.name("campaignName"));
				campaignName.sendKeys("Bike super six VV1");
				
				//enter campaign status as pass into campaign status text field
				WebElement campaignStatus = driver.findElement(By.name("campaignStatus"));
				campaignStatus.sendKeys("PASS");
				
				//clear target size
				driver.findElement(By.name("targetSize")).clear();

				//enter target size
				WebElement targetSize = driver.findElement(By.name("targetSize"));
				targetSize.sendKeys("600");
				
				//click on create campaign button
				driver.findElement(By.xpath("//button[@type='submit']")).submit();
				
				Thread.sleep(3000);
				//verify success message
				String successMessage = driver.findElement(By.xpath("//div[@role='alert']")).getText();
				System.out.println(successMessage);
				if(successMessage.contains("Successfully Added")) {
					System.out.println("*****TEST CASE PASS******");
				}
				else {
					System.out.println("*****TEST CASE FAIL******");
				}
				Thread.sleep(8000);
				//close the success message
				driver.findElement(By.xpath("//button[text()='X']")).click();
				
//				//Logout from application
//				Actions actions = new Actions(driver);
//				WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
//				actions.moveToElement(logout).perform();
//				
	}

}
