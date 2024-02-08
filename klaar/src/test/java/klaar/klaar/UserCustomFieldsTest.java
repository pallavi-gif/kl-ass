package klaar.klaar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserCustomFieldsTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Users/Dell/Desktop/chrome/chromedriver.exe");

        // Initialize the WebDriver instance
        driver = new ChromeDriver();
   
        }
    

    @Test(priority = 1)
    public void navigateToSettingsModuleTest() {
    	// Step 1: Log in using user credentials
    	driver.get("https://dev.klaarhq.com/");
        
        

        // Enter valid username and password
        WebElement usernameField = driver.findElement(By.id("email-field"));
        WebElement passwordField = driver.findElement(By.id("password-field"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='login-btn']/span"));

        usernameField.sendKeys("deepa.nayak@gamma.klaar.team");
        passwordField.sendKeys("Klaar2021");

        // Click on the login button
        loginButton.click();
        // 1. Navigate to the Settings module
        driver.get("login_page_url");
        // Add code to log in if required
        driver.findElement(By.linkText("Settings")).click();
        driver.findElement(By.linkText("User List")).click();
        driver.findElement(By.linkText("User Fields")).click();
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
