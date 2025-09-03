package testcases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import POM.CreateCampaignPage;
import POM.HomePage;
import POM.LoginPage;
import excelfileutility.ExcelUtility;
import javautility.JavaUtility;
import propertiesFileUtility.PropertiesUtility;
import webdriverutility.WebDriverUtility;

public class CreateCampaignWithExpectedDateTest {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		PropertiesUtility putil = new PropertiesUtility();
		String BROWSER = putil.getDataFromPropertiesFile("Browser");
		String URL = putil.getDataFromPropertiesFile("Url");
		String USERNAME = putil.getDataFromPropertiesFile("Username");
		String PASSWORD = putil.getDataFromPropertiesFile("Password");

		// read data from excel
		ExcelUtility eutil = new ExcelUtility();
		String campname = eutil.getDataFromExcel("Create Campaign", 1, 0);
		String size = eutil.getDataFromExcel("Create Campaign", 1, 1);
		String campStatus  = eutil.getDataFromExcel("Create Campaign", 1, 2);	
		
		//launch the browser
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

		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-mm-yyyy");
		sim.format(date);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		
		// create campaign
		HomePage hp = new HomePage(driver);
		hp.getCreatecampaign().click();

		CreateCampaignPage cp = new CreateCampaignPage(driver);
		cp.getCampaignName().sendKeys(campname);
		cp.getTargetSize().sendKeys(size);
		cp.getCampaignStatus().sendKeys(campStatus);
		wutil.passInput(driver, cp.getExpectedCloseDate(), jutil.togetRequired(30));
		cp.getCreateCamapaignSubmitButton().click();

		// validation
		Thread.sleep(2000);
		WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
		wutil.waitForVisibiltyofElement(driver, toastmsg);

		String msg = toastmsg.getText();

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
	}

}
