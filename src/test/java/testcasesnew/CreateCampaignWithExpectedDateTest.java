package testcasesnew;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.CreateCampaignPage;
import POM.HomePage;
import POM.LoginPage;
import baseclass.BaseClass;
import excelfileutility.ExcelUtility;
import javautility.JavaUtility;
import propertiesFileUtility.PropertiesUtility;
import webdriverutility.WebDriverUtility;

@Listeners(listeners.ListenerImplementation.class)
public class CreateCampaignWithExpectedDateTest extends BaseClass{
	
	@Test(groups = "Smoke")
	public void CreateCampaignTest() throws InterruptedException, EncryptedDocumentException, IOException {
	
	// read data from excel
	ExcelUtility eutil = new ExcelUtility();
	String campname = eutil.getDataFromExcel("Create Campaign", 1, 0);
	String size = eutil.getDataFromExcel("Create Campaign", 1, 1);
	String campStatus  = eutil.getDataFromExcel("Create Campaign", 1, 2);	
	
	WebDriverUtility wutil = new WebDriverUtility();

	JavaUtility jutil = new JavaUtility();

	Date date = new Date();
	SimpleDateFormat sim = new SimpleDateFormat("dd-mm-yyyy");
	sim.format(date);
	Calendar cal = sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, 30);
	String daterequired = sim.format(cal.getTime());
	
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
	Thread.sleep(3000);
	WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
	wutil.waitForVisibiltyofElement(driver, toastmsg);

	String msg = toastmsg.getText();

//	if (msg.contains(campname)) {
//		System.out.println("Campaign created");
//	} else {
//		System.out.println("Campaign not created");
//		Thread.sleep(3000);
//	}
	Assert.assertTrue(msg.contains(campname));
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@aria-label='close']")).click();

	}

}
