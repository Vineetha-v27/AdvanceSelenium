package hardcodedprogram;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateProductWithMandatoryFields {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

		// get the ninjacrm url
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");

		// click on login button
		driver.findElement(By.xpath("//button[@type='submit']")).submit();

		//Add product details
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Add Product')]")).click();
		driver.findElement(By.name("productName")).sendKeys("Samsung");
		
		WebElement categorydropdown = driver.findElement(By.name("productCategory"));
		//Dropdown1
		Select drop1 = new Select(categorydropdown);
		drop1.selectByValue("Electricals");
		WebElement quantity = driver.findElement(By.name("quantity"));
		quantity.clear();
		quantity.sendKeys("7");
		
		WebElement price = driver.findElement(By.name("price"));
		price.clear();
		price.sendKeys("89000");
		
		//DropDown2
		WebElement vendordropdown = driver.findElement(By.name("vendorId"));
		Select drop2 = new Select(vendordropdown);
		drop2.selectByValue("VID_007");
		
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
	}

}
