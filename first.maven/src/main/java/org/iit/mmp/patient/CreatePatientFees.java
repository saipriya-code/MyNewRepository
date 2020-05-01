package org.iit.mmp.patient;

import java.util.HashMap;
import java.util.List;

import org.iit.mmp.helper.HelperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatePatientFees {

	WebDriver driver;
	HashMap<String, String> hMap = new HashMap<String, String>();

	
	public CreatePatientFees(WebDriver driver) throws Exception {
		this.driver = driver;	
	}

	
	public void createPatientFees(String fname) throws Exception {
		HelperMethods.navigateToSubMenu("Patients");
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement search = driver.findElement(By.xpath("//input[@value='search']"));
		search = wait.until(ExpectedConditions.elementToBeClickable(search));
		search.click();
		
		System.out.println("click search button");
		Thread.sleep(3000);
		List<WebElement> FNList = driver.findElements(By.xpath("//div[@id='show']//tbody/tr/td[1]"));
        
		//FNList = wait.until(ExpectedConditions.visibilityOfAllElements(FNList));
	
		for(int i=0;i<FNList.size();i++)
		{
		   WebElement e = FNList.get(i);
			if(e.getText().equalsIgnoreCase(fname))
		   {
			   //e.click();
				System.out.println("printing e after if" +e.getText());
				driver.findElement(By.linkText(fname)).click();
			   break;
		   }
		
		}
	}
}
