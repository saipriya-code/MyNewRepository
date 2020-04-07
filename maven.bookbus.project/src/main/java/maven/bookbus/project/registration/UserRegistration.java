package maven.bookbus.project.registration;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserRegistration {
	WebDriver driver;
	
	public UserRegistration(WebDriver driver) {
		this.driver = driver;
	}

	public HashMap<String, String> registerUser(String userName, String pwd) {
		String tempStrValue = null;
		WebElement tempEleValue =null;
		Random rnd = new Random();
		long tempLongValue;
		HashMap<String, String> hMap=new HashMap<String, String>();
		
		//driver.findElement(By.xpath("//a[@id='header-mail-button']/span[contains(text(),'Mail')]")).click();
		driver.findElement(By.xpath("//a[@id='header-signin-link']/span[contains(text(),'Sign')]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("createacc")).click();
		
		tempStrValue = "FirstNAme" + (char)(65 + rnd.nextInt(26));
		tempEleValue = driver.findElement(By.name("firstName"));
		tempEleValue.sendKeys(tempStrValue);
		hMap.put("firstname", tempEleValue.getAttribute("value"));
		System.out.println("firstName is:"+tempStrValue);
		
		tempStrValue = "LastNAme" + (char)(65 + rnd.nextInt(26));
		tempEleValue = driver.findElement(By.name("lastName"));
		tempEleValue.sendKeys(tempStrValue);
		hMap.put("lastname", tempEleValue.getAttribute("value"));
		System.out.println("lastName is:"+tempStrValue);
		
		tempStrValue = "myEmailIdCheck" + (char)(65 + rnd.nextInt(26)) + rnd.nextInt(999);
		tempEleValue = driver.findElement(By.id("usernamereg-yid"));
		tempEleValue.sendKeys(tempStrValue);
		hMap.put("emailid", tempEleValue.getAttribute("value"));
		System.out.println("emailid is:"+tempStrValue);
		
		tempStrValue = "mypwdCheck" + (char)(65 + rnd.nextInt(26)) + rnd.nextInt(999);
		tempEleValue = driver.findElement(By.name("password"));
		tempEleValue.sendKeys(tempStrValue);
		hMap.put("password", tempEleValue.getAttribute("value"));
		System.out.println("password is:"+tempStrValue);
		
		tempLongValue =  10000 + rnd.nextInt(90000);
		tempEleValue = driver.findElement(By.name("phone"));
		tempEleValue.sendKeys("98876"+tempLongValue);
		hMap.put("phone", tempEleValue.getAttribute("value"));
		System.out.println("phoneno is:"+tempLongValue);
		
		new Select(driver.findElement(By.id("usernamereg-month"))).selectByIndex(1);

		tempLongValue =  1 + rnd.nextInt(28);
		tempEleValue = driver.findElement(By.id("usernamereg-day"));
		tempEleValue.sendKeys(""+tempLongValue);
		hMap.put("DOBday", tempEleValue.getAttribute("value"));
		System.out.println("dob day is:"+tempLongValue);
		
		tempLongValue =  1930 + rnd.nextInt(60);
		tempEleValue = driver.findElement(By.id("usernamereg-year"));
		tempEleValue.sendKeys(""+tempLongValue);
		hMap.put("DOByear", tempEleValue.getAttribute("value"));
		System.out.println("dob year is:"+tempLongValue);
		
		
		driver.findElement(By.id("reg-submit-button")).click();
	//	driver.findElement(By.id("recaptcha-anchor")).click();
		
		return hMap;
	}

}
