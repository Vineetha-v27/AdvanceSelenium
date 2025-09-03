package testcases;

import java.io.IOException;

import excelfileutility.ExcelUtility;
import javautility.JavaUtility;
import propertiesFileUtility.PropertiesUtility;
import webdriverutility.WebDriverUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import POM.CreateCampaignPage;
import POM.HomePage;
import POM.LoginPage;

public class CreateCampaignWithMandatoryFieldTest {
	public static void main(String[] args) throws IOException, InterruptedException {

		//properties file
		PropertiesUtility putil = new PropertiesUtility();
		String BROWSER = putil.getDataFromPropertiesFile("Browser");
		String URL = putil.getDataFromPropertiesFile("Url");
		String USERNAME = putil.getDataFromPropertiesFile("Username");
		String PASSWORD = putil.getDataFromPropertiesFile("Password");

		// read data from excel
		ExcelUtility eutil = new ExcelUtility();
		String campname = eutil.getDataFromExcel("Create Campaign", 1, 0);
		String size = eutil.getDataFromExcel("Create Campaign", 1, 1);

		//launch browser
		System.setProperty("webdriver.edge.driver", "C:\\msedgedriver\\msedgedriver.exe");
		WebDriverUtility wutil = new WebDriverUtility();
		WebDriver driver = new EdgeDriver();
		//WebDriver driver = new ChromeDriver();
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
		hp.getCreatecampaign().click();
		
		//enter details for create campaign
		CreateCampaignPage cp = new CreateCampaignPage(driver);
		Thread.sleep(2000);
		cp.getCampaignName().sendKeys(campname);
		Thread.sleep(2000);
		cp.getTargetSize().clear();
		cp.getTargetSize().sendKeys(size);
		Thread.sleep(2000);
		cp.getCreateCamapaignSubmitButton().click();

		// validation
		WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
		wutil.waitForVisibiltyofElement(driver, toastmsg);

		String msg = toastmsg.getText();
		System.out.println(msg);
		if (msg.contains(campname)) {
			System.out.println("Campaign created");
		} else {
			System.out.println("Campaign not created");
			Thread.sleep(3000);
		}
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();

		// logout
		hp.getUserIcon().click();
		hp.getLogoutBtn().click();
		driver.quit();

	}

}
