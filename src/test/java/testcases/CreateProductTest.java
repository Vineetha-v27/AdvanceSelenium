package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import POM.AddProductPage;
import POM.HomePage;
import POM.LoginPage;
import excelfileutility.ExcelUtility;
import javautility.JavaUtility;
import propertiesFileUtility.PropertiesUtility;
import webdriverutility.WebDriverUtility;

public class CreateProductTest {
	public static void main(String[] args) throws IOException, InterruptedException {

		// properties file
		PropertiesUtility putil = new PropertiesUtility();
		String BROWSER = putil.getDataFromPropertiesFile("Browser");
		String URL = putil.getDataFromPropertiesFile("Url");
		String USERNAME = putil.getDataFromPropertiesFile("Username");
		String PASSWORD = putil.getDataFromPropertiesFile("Password");

		// read data from excel
		ExcelUtility eutil = new ExcelUtility();
		String productName = eutil.getDataFromExcel("Product", 1, 0);
		String productSize = eutil.getDataFromExcel("Product", 1, 1);
		String pprize = eutil.getDataFromExcel("Product", 1, 2);
		
		// launch browser
		System.setProperty("webdriver.edge.driver", "C:\\msedgedriver\\msedgedriver.exe");
		WebDriverUtility wutil = new WebDriverUtility();
		WebDriver driver = new EdgeDriver();
		// WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		wutil.waitForPageToLoad(driver);

		// login to NINJA CRM
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.getUN().sendKeys(USERNAME);
		lp.getPW().sendKeys(PASSWORD);
		lp.getLoginbtn().click();

		JavaUtility jutil = new JavaUtility();

		// create campaign
		HomePage hp = new HomePage(driver);
		hp.getProducts().click();
		Thread.sleep(2000);
		hp.getGetproduct().click();
		
		AddProductPage ap = new AddProductPage(driver);
		ap.getProductId();
		ap.getProductName().sendKeys(productName);
	//	ap.getProductName().sendKeys(productName+jutil.getRandomNumber());
		ap.getQuantity().clear();
		ap.getQuantity().sendKeys(productSize);
		
		ap.getPrice().clear();
		ap.getPrice().sendKeys(pprize);
		wutil.select(ap.getProductCategory(), 1);
		Thread.sleep(2000);
		wutil.select(ap.getVendorId(), 3);
		ap.getAddprodButton().click();
	}

}
