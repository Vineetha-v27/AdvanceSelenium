package testcasesnew;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.AddProductPage;
import POM.HomePage;

import baseclass.BaseClass;
import excelfileutility.ExcelUtility;
import javautility.JavaUtility;
import webdriverutility.WebDriverUtility;

@Listeners(listeners.ListenerImplementation.class)
public class CreateProductTest extends BaseClass {

	@Test(groups = "Smoke")

	public void CreateProductTest() throws EncryptedDocumentException, IOException, InterruptedException {

		// read data from excel
		ExcelUtility eutil = new ExcelUtility();
		String productName = eutil.getDataFromExcel("Product", 1, 0);
		String productSize = eutil.getDataFromExcel("Product", 1, 1);
		String pprize = eutil.getDataFromExcel("Product", 1, 2);

		WebDriverUtility wutil = new WebDriverUtility();

		JavaUtility jutil = new JavaUtility();

		// create campaign
		HomePage hp = new HomePage(driver);
		hp.getProducts().click();
		Thread.sleep(2000);
		hp.getGetproduct().click();

		AddProductPage ap = new AddProductPage(driver);
		ap.getProductId();
		//ap.getProductName().sendKeys(productName+jutil.getRandomNumber());
		ap.getProductName().sendKeys(productName);
		ap.getQuantity().clear();
		ap.getQuantity().sendKeys(productSize);

		ap.getPrice().clear();
		ap.getPrice().sendKeys(pprize);
		wutil.select(ap.getProductCategory(), 2);
		Thread.sleep(2000);
		wutil.select(ap.getVendorId(), 3);
		ap.getAddprodButton().click();
	}

}
