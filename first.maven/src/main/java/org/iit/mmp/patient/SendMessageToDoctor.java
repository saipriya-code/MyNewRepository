package org.iit.mmp.patient;

import java.util.HashMap;

import org.iit.mmp.helper.HelperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

	public class SendMessageToDoctor {
		WebDriver driver;
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		
		public SendMessageToDoctor(WebDriver driver) 
		{
			this.driver = driver;

		}

		
		public HashMap<String,String> sendMessageToDoctor(String messagesubject, String message) throws InterruptedException
		{
		
		
		//HelperMethods submenu = new HelperMethods(driver);
		HelperMethods.navigateToSubMenu("Messages");
		
		WebElement subject = driver.findElement(By.id("subject"));
		subject.sendKeys(messagesubject);
		String subjectofMessage = subject.getAttribute("value");
		hashMap.put("subject", subjectofMessage);

		
		WebElement messagedesc = driver.findElement(By.id("message"));
		messagedesc.sendKeys(message);
		String messagedescdetail = messagedesc.getAttribute("value");
		hashMap.put("messagedesc", messagedescdetail);

		System.out.println("hmap values:"+hashMap.get("subject")+"&"+hashMap.get("messagedesc"));

		/*driver.findElement(By.xpath("//input[@value='Send']")).click();
		
		Thread.sleep(2000);
		
		Alert alrt = driver.switchTo().alert();

		String successpopup = alrt.getText();
		hashMap.put("successPopup", successpopup);
		alrt.accept();
	    Thread.sleep(3000);
	    
	     */
	    return hashMap;
		
		}
}
