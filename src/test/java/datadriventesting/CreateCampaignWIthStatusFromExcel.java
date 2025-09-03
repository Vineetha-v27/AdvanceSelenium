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
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateCampaignWIthStatusFromExcel {
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
		String campaignStatus = row.getCell(2).getStringCellValue();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// get the ninjacrm url
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");

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

		// enter campaign status
		driver.findElement(By.name("campaignStatus")).sendKeys(campaignStatus);

		// click on create campaign button
		driver.findElement(By.xpath("//button[@type='submit']")).submit();

		Thread.sleep(3000);
	}

}
