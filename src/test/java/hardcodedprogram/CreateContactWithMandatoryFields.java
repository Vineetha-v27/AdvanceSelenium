package hardcodedprogram;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateContactWithMandatoryFields {

	public static void main(String[] args) {
		
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
		
		//click on contacts module and then click on create contact button
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		
	//	Organization*:Qspiders Title*:Departmentt,
//		Contact Name*:Vineetha,Mobile*:9876543210,Campaign*:Bike Pulsor S seven
		
		//enter test data to create contact page
		WebElement organization = driver.findElement(By.name("organizationName"));
		organization.sendKeys("Qspiders");
		
		WebElement title = driver.findElement(By.name("title"));
		title.sendKeys("Department");
		
		WebElement contactName = driver.findElement(By.name("contactName"));
		contactName.sendKeys("Vineetha");
		
		WebElement mobileNum = driver.findElement(By.name("mobile"));
		mobileNum.sendKeys("9876543210");
		
		WebElement campaignAdd = driver.findElement(By.xpath("//button[contains(@style,'background-color: green')]"));
		campaignAdd.click();
		WebElement campaignSearch = driver.findElement(By.id("search-input"));
		campaignSearch.sendKeys("Campaigntest");
		driver.findElement(By.linkText("Select")).click();
		
		
		
	}

}
