package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateCampaignWIthMandatoryFieldsFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {

		// Get the path
		FileInputStream fis = new FileInputStream("./TestData/CreateCampaignAndProductExcel.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		// Get the sheet
		Sheet sh = wb.getSheet("Create Campaign");
		// Get Row
		Row row = sh.getRow(1);
		// Get Cell
		String campaignName = row.getCell(0).getStringCellValue();
		String targetSize = row.getCell(1).getStringCellValue();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//navigate to ninjacrm url(common data)
		FileInputStream fis1 = new FileInputStream("./src/test/resources/commonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis1);
		String URL = pObj.getProperty("url");
		driver.get(URL);
		String USERNAME = pObj.getProperty("username1");
	//	driver.get(USERNAME);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		String PASSWORD = pObj.getProperty("password1");
	//	driver.get(PASSWORD);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);

		// click on login button
		driver.findElement(By.xpath("//button[@type='submit']")).submit();

		// click on create campaign button
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

		// enter test data to create campaign module
		driver.findElement(By.name("campaignName")).sendKeys(campaignName);

		// clear target size
		driver.findElement(By.name("targetSize")).clear();

		// enter target size
		driver.findElement(By.name("targetSize")).sendKeys(targetSize);

		// click on create campaign button
		driver.findElement(By.xpath("//button[@type='submit']")).submit();

		Thread.sleep(3000);
	}

}
