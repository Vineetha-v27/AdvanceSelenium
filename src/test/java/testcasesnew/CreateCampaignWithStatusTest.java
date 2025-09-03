package testcasesnew;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
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
public class CreateCampaignWithStatusTest extends BaseClass{
	
	@Test(groups = "Smoke")
	
	public void CreateCampaignTest() throws EncryptedDocumentException, IOException, InterruptedException {

	// read data from excel
	ExcelUtility eutil = new ExcelUtility();
	String campname = eutil.getDataFromExcel("Create Campaign", 1, 0);
	String size = eutil.getDataFromExcel("Create Campaign", 1, 1);
	String campStatus  = eutil.getDataFromExcel("Create Campaign", 1, 2);	
	
	WebDriverUtility wutil = new WebDriverUtility();

	JavaUtility jutil = new JavaUtility();

	// create campaign
	HomePage hp = new HomePage(driver);
	hp.getCreatecampaign().click();
	
	//enter details for create campaign
	CreateCampaignPage cp = new CreateCampaignPage(driver);
	cp.getCampaignName().sendKeys(campname);
	cp.getTargetSize().clear();
	cp.getTargetSize().sendKeys(size);
	cp.getCampaignStatus().sendKeys(campStatus);
	cp.getCreateCamapaignSubmitButton().click();

	// validation
	Thread.sleep(3000);
	WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
	wutil.waitForVisibiltyofElement(driver, toastmsg);

	String msg = toastmsg.getText();
	System.out.println(msg);
//	if (msg.contains(campname)) {
//		System.out.println("Campaign created");
//	} else {
//		System.out.println("Campaign not created");
//		Thread.sleep(3000);
//	}
	Assert.assertTrue(msg.contains(campname));
	Thread.sleep(3000);
//	driver.findElement(By.xpath("//button[@aria-label='close']")).click();
	
	}
	
	
	
}
