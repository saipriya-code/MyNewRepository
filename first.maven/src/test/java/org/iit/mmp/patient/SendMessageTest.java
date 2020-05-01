package org.iit.mmp.patient;
import java.util.HashMap;

import org.iit.mmp.admin.AdminLogin;
import org.iit.mmp.admin.CheckPatientMessages;
import org.iit.mmp.helper.HelperMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SendMessageTest {
	WebDriver driver;
	HashMap<String, String> hashMap = new HashMap<String, String>();
	
	@Test (enabled = true, priority = 40)
	public void SendMessageToDoctor() throws Exception
	{
		driver = HelperMethods.launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		PatientLogin patLog = new PatientLogin(driver);
		patLog.patientLogin("HemaMKute79","HemaMKute33");
		
		SendMessageToDoctor message = new SendMessageToDoctor(driver);
		hashMap = message.sendMessageToDoctor("Got Xray", "want to inform i have got the XRay and are fine");
		System.out.println("checking hmap values:"+hashMap.get("subject")+"&"+hashMap.get("messagedesc"));

	}
	
	@Test (enabled = true, priority = 45)
	public void CheckPatientMessages() throws Exception
	{
		System.out.println("inside test 2 : hmap values:"+hashMap.get("subject")+"&"+hashMap.get("messagedesc"));

		driver.get("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		AdminLogin admin = new AdminLogin(driver);
		admin.adminLogin("Thomas_444", "Edison_444");
		
		CheckPatientMessages message = new CheckPatientMessages(driver);
		message.checkpatientmessage(hashMap);
	}
	

}
