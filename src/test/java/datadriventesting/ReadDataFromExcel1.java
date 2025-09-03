package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReadDataFromExcel1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Get the path
		FileInputStream fis = new FileInputStream("./TestData/DataDrivenTestingExcel1.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		//Get the sheet
		Sheet sh = wb.getSheet("Sheet1");
		//Get Row
		Row row = sh.getRow(1);
		//Get Cell
		String username = row.getCell(0).getStringCellValue();
		String password = row.getCell(1).getStringCellValue();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.instagram.com/");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);

	}

}
