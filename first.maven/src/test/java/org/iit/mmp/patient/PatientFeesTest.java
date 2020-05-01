package org.iit.mmp.patient;

import java.util.HashMap;

import org.iit.mmp.admin.AdminLogin;
import org.iit.mmp.helper.HelperMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PatientFeesTest {
	WebDriver driver;
	HashMap<String, String> hMap = new HashMap<String, String>();

	@Test
	public void testFees() throws Exception {
		driver = HelperMethods.launchBrowser("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		AdminLogin admLgn = new AdminLogin(driver);
		admLgn.adminLogin("Thomas_444","Edison_444");
		
		CreatePatientFees patFee = new CreatePatientFees(driver);
		patFee.createPatientFees("Thomas");
		
	}
}
