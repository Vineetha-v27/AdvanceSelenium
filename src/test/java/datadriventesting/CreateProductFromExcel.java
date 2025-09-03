package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateProductFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		// Get the path
		FileInputStream fis = new FileInputStream("./TestData/CreateCampaignAndProductExcel.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		// Get the sheet
		Sheet sh = wb.getSheet("Product");
		// Get Row
		Row row = sh.getRow(1);
		// Get Cell
		String productName = row.getCell(0).getStringCellValue();
		String quantity = row.getCell(1).getStringCellValue();
		String pricePerUnit = row.getCell(2).getStringCellValue();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// get the ninjacrm url
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");

		// click on login button
		driver.findElement(By.xpath("//button[@type='submit']")).submit();

		//Add product details
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Add Product')]")).click();
		driver.findElement(By.name("productName")).sendKeys(productName);
		
		WebElement categorydropdown = driver.findElement(By.name("productCategory"));
		//Dropdown1
		Select drop1 = new Select(categorydropdown);
		drop1.selectByValue("Electricals");
		WebElement quantity1 = driver.findElement(By.name("quantity"));
		quantity1.clear();
		quantity1.sendKeys(quantity);
		
		WebElement price = driver.findElement(By.name("price"));
		price.clear();
		price.sendKeys(pricePerUnit);
		
		//DropDown2
		WebElement vendordropdown = driver.findElement(By.name("vendorId"));
		Select drop2 = new Select(vendordropdown);
		drop2.selectByValue("VID_007");
		
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
	}

}
