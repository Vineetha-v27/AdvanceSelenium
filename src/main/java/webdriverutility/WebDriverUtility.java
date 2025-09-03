package webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForVisibiltyofElement(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchToFrame(WebDriver driver, WebElement frameelement) {
		driver.switchTo().frame(frameelement);
	}
	
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public String SwitchToAlertAndgetText(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	}
	
	public void switchToAlertAndSendKeys(WebDriver driver,String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	
	public void select(WebElement element,int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void select(WebElement element,String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	public void select(String text, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void mouseHoverOnWebElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void clickOnWebElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	
	public void doubleClickOnWebElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void rightClickOnWebElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void passInput(WebDriver driver, WebElement element, String text) {
		Actions act = new Actions(driver);
		act.click(element).sendKeys(text).perform();
	}
	
	public void switchToWindow(WebDriver driver) {
		Set<String> allWinId = driver.getWindowHandles();
		for(String id : allWinId) {
			driver.switchTo().window(id);
		}
	}
	
	public void takeScreenShot(WebDriver driver, String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File("./errorShots"+filename+".png");
		org.openqa.selenium.io.FileHandler.copy(temp, perm);
	}
	
	public void toScrollBy(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	
	
	
	
	
}
