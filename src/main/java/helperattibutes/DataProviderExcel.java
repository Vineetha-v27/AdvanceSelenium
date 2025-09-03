package helperattibutes;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExcel {
	@Test(dataProvider = "loginDetails")
	
	public void login(String username,String password) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//login to Instagram
		driver.get("https://www.instagram.com/");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		driver.quit();
	}
	
	@DataProvider
	public Object[][] loginDetails() throws EncryptedDocumentException, IOException{
		FileInputStream fis = new FileInputStream("./TestData/DataProvider.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Login");
		int rowcount = sh.getLastRowNum();
		Object[][] objarr = new Object[rowcount][2];
		for(int i = 0; i < rowcount; i++) {
			objarr[i][0] = sh.getRow(i+1).getCell(0).getStringCellValue();
			objarr[i][1] = sh.getRow(i+1).getCell(1).getStringCellValue();
		}
		return objarr;
	}

}
