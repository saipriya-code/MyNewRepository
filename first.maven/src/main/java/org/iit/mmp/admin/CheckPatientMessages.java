package org.iit.mmp.admin;


import java.util.HashMap;
import java.util.List;

import org.iit.mmp.helper.HelperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckPatientMessages {

	WebDriver driver;
	HashMap<String, String> hashMap = new HashMap<String, String>();

		
		public CheckPatientMessages(WebDriver driver) throws Exception 
		{
			this.driver = driver;
			
			
		}
		
		
	public void checkpatientmessage(HashMap<String, String>  hashMap)
	{
	
		//HelperMethod submenu = new HelperMethod(driver);
		HelperMethods.navigateToSubMenu("Messages");
		String expectedsubject = hashMap.get("subject");
		String expectedmessage = hashMap.get("messagedesc");
		/*
		WebElement mytable = driver.findElement(By.xpath("//table[@class='table']/tbody"));
		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		boolean flag1=false;
		boolean flag2=false;
		for(int row=0;row<rows_table.size();row++) {
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));				  
			
			for (int column=0; column<Columns_row.size(); column++){
					WebElement e =   Columns_row.get(column);
						if(e.getText().equals(expectedsubject))
						{
							String subject = e.getText();
							System.out.println("printing subject"+subject);
							flag1 =true;
							break;
						}	
						
						if(e.getText().equals(expectedmessage) && flag1==true)
						{
							String subjectmessage = e.getText();
							System.out.println("printing subject message"+subjectmessage);
							flag2 = true;
							break;
						}					
				}
				if(flag2==true) {
					break;
				}
			}
		*/
		List<WebElement> rowData = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td//b[contains(text(),'"+expectedsubject+"')]/ancestor::tr/following-sibling::tr[1]"));
		for (WebElement webElement : rowData) {
			if(webElement.getText().equals(expectedmessage)){
				System.out.println("got the message");
				break;
			}
		}
	}
	
}
