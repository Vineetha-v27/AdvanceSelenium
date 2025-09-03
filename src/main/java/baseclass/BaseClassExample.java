package baseclass;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClassExample {
	
	@Test
	
	public void TC001() {
		Reporter.log("Testcases",true);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("login",true);
	}
	
	@AfterMethod
	public void afterMethod() {
		Reporter.log("logout",true);
	}
	
	@BeforeClass
	public void beforeClass() {
		Reporter.log("Launching browser",true);
	}
	
	@AfterClass
	public void afterClass() {
		Reporter.log("Closing browser",true);
	}
	
	@BeforeTest
	public void beforeTest() {
		Reporter.log("Pre condition",true);
	}
	
	@AfterTest
	public void afterTest() {
		Reporter.log("Post Condition",true);
	}
	
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("Database open",true);
	}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.log("Database close",true);
	}
	
	
	
	
	
	
	

}
