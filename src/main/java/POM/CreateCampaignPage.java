package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	WebDriver driver;
	public CreateCampaignPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "campaignId")
	private WebElement campaignId;
	
	@FindBy(name = "campaignName") //lazy initialization: In order to locate webelement in Runtime we go for Lazy initialization
	private WebElement campaignName;
	
	@FindBy(name = "campaignStatus")
	private WebElement campaignStatus;
	
	@FindBy(name = "targetSize")
	private WebElement targetSize;
	
	@FindBy(name = "expectedCloseDate")
	private WebElement expectedCloseDate;
	
	@FindBy(name = "targetAudience")
	private WebElement targetAudience;
	
	@FindBy(name = "description")
	private WebElement description;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement createcampaignsubmitbtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCampaignId() {
		return campaignId;
	}

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getCampaignStatus() {
		return campaignStatus;
	}

	public WebElement getTargetSize() {
		return targetSize;
	}

	public WebElement getExpectedCloseDate() {
		return expectedCloseDate;
	}

	public WebElement getTargetAudience() {
		return targetAudience;
	}

	public WebElement getDescription() {
		return description;
	}
	
	public WebElement getCreateCamapaignSubmitButton() {
		return createcampaignsubmitbtn;
	}
	
	
	
	
}
