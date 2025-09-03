package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage {
	
	WebDriver driver;
	public AddProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productId")
	private WebElement productId;
	
	@FindBy(name = "productName")
	private WebElement productName;
	
	@FindBy(name = "productCategory")
	private WebElement productCategory;
	
	@FindBy(name = "quantity")
	private WebElement quantity;
	
	@FindBy(name = "price")
	private WebElement price;
	
	@FindBy(name = "vendorId")
	private WebElement vendorId;
	
	@FindBy(xpath = "//button[text()='Add']")
	private WebElement addprodButton;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProductId() {
		return productId;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductCategory() {
		return productCategory;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getVendorId() {
		return vendorId;
	}

	public WebElement getAddprodButton() {
		return addprodButton;
	}
	
	

}
