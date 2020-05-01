package first.maven.first.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterPatientMMP {
	WebDriver driver ;
	public void launchBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
	}
	//changed code
	@Test
	public void registerPatient() {
		launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		driver.findElement(By.name("fname")).sendKeys("FirstNameCheck");
		driver.findElement(By.name("LastName")).sendKeys("LastNameCheck");
		driver.findElement(By.name("dob")).sendKeys("06/02/1990");
		driver.findElement(By.name("license")).sendKeys("14445678");
		driver.findElement(By.name("ssn")).sendKeys("1234567893");
		driver.findElement(By.name("state")).sendKeys("GA");
		driver.findElement(By.name("city")).sendKeys("peachtree city");
		driver.findElement(By.name("address")).sendKeys("234 hollow st");
		driver.findElement(By.name("zipcode")).sendKeys("12345");
		driver.findElement(By.name("age")).sendKeys("30");
		driver.findElement(By.name("height")).sendKeys("5.3");
		driver.findElement(By.name("weight")).sendKeys("53");
		driver.findElement(By.name("pharmacy")).sendKeys("walmart");
		driver.findElement(By.name("pharma_adress")).sendKeys("234 hollow st");
		driver.findElement(By.name("email")).sendKeys("check@gmail.com");
		driver.findElement(By.name("pwd1")).sendKeys("Checkcheck1");
		driver.findElement(By.name("username")).sendKeys("checkme");
		driver.findElement(By.name("pwd2")).sendKeys("Checkcheck1");
		new Select(driver.findElement(By.name("question"))).selectByIndex(1);
		driver.findElement(By.name("answer")).sendKeys("checkMom");
		driver.findElement(By.xpath("//input[@value='Save']")).click();		
		
	}
}
