package helperattibutes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Enabled {
	@Test(enabled = true)
	
	public void a11() {
		Reporter.log("a11 executed",true);	
	}
	
	@Test(enabled = false)
	
	public void a22() {
		Reporter.log("a22 executed",true);
	}
	
	@Test
	//default it will take as enabled
	public void a10() {
		Reporter.log("a10 executed",true);
	}

}
