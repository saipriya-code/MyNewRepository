package Sudheer;
 
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class SeleniumExample {
    WebDriver driver;
     
      
    @Test
    public void validateSearchResults()
    {
        /*
         * 1. Enter the url https://www.yahoo.com/
         * 2. Enter the text Selenium in the Textbox
         * 3. Select "Selenium Interview Questions" from the List
         * 4. Check the search results page is displayed
         * 5. Expected Result : Validate the Search results contains "Selenuim Interview Questions".
         * 6. Expected Result : Validate the Search REsults in first 5 pages contains "Selenium Inteview Questions"
         * 
         */
         
        SoftAssert sa = new SoftAssert();
         
          
        //System.setProperty("webdriver.chrome.driver", "./BrowserExe/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.yahoo.com/");
      
        Utility util = new Utility(driver);
        List<WebElement> list =  util.retrieveSearchList("selenium");
        int size = list.size();  
        sa.assertEquals(10, size);
         
        boolean result = util.selectRequiredSearchPattern("selenium interview questions");
        sa.assertTrue(result);

        result = util.validateLinkText("Questions",5,"selenium interview questions");
        sa.assertTrue(result);
        sa.assertAll();
         
         
         
    }
      
 
}