package org.iit.mmp.admin;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminLogin {
	WebDriver driver;

	public AdminLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public void adminLogin(String username, String pwd) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.name("admin")).click();
	}
	
	public String approvePatients(HashMap<String, String> hMap) throws InterruptedException {
		Select patientStatus = new Select(driver.findElement(By.id("search")));
		patientStatus.selectByVisibleText("Pending");
		findUser(hMap.get("fname"));
		driver.findElement(By.xpath("//a[contains(text(),'"+hMap.get("fname")+"')]")).click();
		new Select(driver.findElement(By.id("sapproval"))).selectByVisibleText("Accepted");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Submit']")).click();

		Alert alrt = driver.switchTo().alert();
		String actual = alrt.getText();
		alrt.accept();
		return actual;
	}
		
	
	public void findUser(String fname) throws InterruptedException {
		List<WebElement> list = null;
		List<WebElement> pageList = driver.findElements(By.xpath("//ul[@class='pager']/li"));
		list = driver.findElements(By.xpath("//div[@id='show']/table/tbody/tr/td[1]"));
		int size=pageList.size()-1;
		System.out.println("page list size is:"+size);
		for(int i =2;i<size;i++) {
			list = driver.findElements(By.xpath("//div[@id='show']/table/tbody/tr/td[1]"));
			for (WebElement webElement : list) {
				if(webElement.getText().equals(fname)){
					System.out.println(webElement.getText());
					System.out.println(fname);
					Thread.sleep(3000);
					webElement.click();
					break;
				}
			}
		driver.findElement(By.xpath("//ul[@class='pager']/li/a[contains(text(),'"+i+"')]")).click();
		}
		
	}
}
