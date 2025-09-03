package helperattibutes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependsOnMethod {
	
	@Test
	
	public void createAcc() {
		Reporter.log("created",true);
	}
	
	@Test(dependsOnMethods = "createAcc")
	
	public void editAcc() {
		Reporter.log("edited",true);
	}
	
	@Test(dependsOnMethods = "editAcc")
	
	public void deleteAcc() {
		Reporter.log("deleted",true);
	}

}
