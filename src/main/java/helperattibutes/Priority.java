package helperattibutes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Priority {
	
	@Test(priority = 3)
	
	public void ola() {
		Reporter.log("ola",true);
	}
	
	@Test(priority = 0)
	
	public void amazon() {
		Reporter.log("Amazon execeuted",true);
	}
	
	@Test(priority = 2)
	public void bookMyShow() {
		Reporter.log("Book my show executed",true);
	}
	
	@Test(priority = -4)
	public void flipkart() {
		Reporter.log("Flipkart executed",true);
	}
	
	

		


}
