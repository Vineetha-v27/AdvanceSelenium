package baseclass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM.HomePage;
import POM.LoginPage;
import propertiesFileUtility.PropertiesUtility;

public class BaseClass {
	
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	
	//to get common data as username and password will be common for all testcases
	public PropertiesUtility putil = new PropertiesUtility();
	
	@BeforeSuite(groups = {"Smoke","Regression"})
	public void beforeSuite() {
		Reporter.log("Database Connectivity Open",true);
	}
	
	@BeforeTest(groups = {"Smoke","Regression"})
	public void beforeTest() {
		System.out.println("Preconditions");
	}
	
//	@Parameters("Browser")(parallel execution)
//	public void beforeClass(String Browser) throws IOException {
	@BeforeClass(groups = {"Smoke","Regression"})
	public void beforeClass() throws IOException {
		System.setProperty("webdriver.edge.driver", "C:\\msedgedriver\\msedgedriver.exe");
	//	String Browser = BROWSER;
		String Browser = putil.getDataFromPropertiesFile("Browser");
		if(Browser.equals("Edge")) {
			driver = new EdgeDriver();
		}
		if(Browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		if(Browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		sdriver=driver;
		System.out.println("Launching the Browser");
		System.out.println("Browser from testng.xml: " + Browser);
		driver.manage().window().maximize();
	}
	
	
	
	//initializing
	@BeforeMethod(groups = {"Smoke","Regression"})
	public void beforeMethod() throws IOException {
		String browser = putil.getDataFromPropertiesFile("Browser");
		String url = putil.getDataFromPropertiesFile("Url");
		String username = putil.getDataFromPropertiesFile("Username");
		String password  = putil.getDataFromPropertiesFile("Password");
		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.getUN().sendKeys(username);
		lp.getPW().sendKeys(password);
		lp.getLoginbtn().click();
		System.out.println("Login Done");
	}

	@AfterMethod(groups = {"Smoke","Regression"})
	public void afterMethod() {
		HomePage hp = new HomePage(driver);
		hp.getUserIcon().click();
		hp.getLogoutBtn().click();
		System.out.println("Logout Done");
	}
	
	@AfterClass(groups = {"Smoke","Regression"})
	public void afterClass() {
		driver.quit();
	}
	
	@AfterTest(groups = {"Smoke","Regression"})
	public void afterTest() {
		System.out.println("Post Conditions");
	}
	
	@AfterSuite(groups = {"Smoke","Regression"})
	public void afterSuite() {
		System.out.println("Close Database Connectivity");
	}
	
}
