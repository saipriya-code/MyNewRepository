package maven.bookbus.project.registration;

import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import maven.bookbus.project.helper.HelperMethods;

public class UserRegistrationTest {
	WebDriver driver;
	HashMap<String, String> hMap = new HashMap<String, String>();
	
	@Test
	public void testUserRegistration() {
		driver = HelperMethods.launchBrowser("https://in.yahoo.com/");
		UserRegistration newUser = new UserRegistration(driver);
		Random rnd = new Random();
		String userName = "TestUser" + 100 + rnd.nextInt(999);
		String pwd = "TestPwd" + 100 + rnd.nextInt(999);
		newUser.registerUser(userName,pwd);
	}
}
