package klaar.klaar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class UserManagementTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Users/Dell/Desktop/chrome/chromedriver.exe");

        // Initialize the WebDriver instance
        driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void navigateToSettingsModuleTest() throws InterruptedException {
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
        Thread.sleep(3000);
     
   
        // 1. Navigate to the Settings module
        driver.findElement(By.xpath("//li[contains(.,'Settings')]")).click();
        
        
     // 2. Navigate to the User List page
        driver.findElement(By.linkText("User List")).click();
        
        // 3. Verify landing on the All Users page
        String expectedTitle = "User List";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Failed to land on All Users page.");
        System.out.println("Landed on All Users page successfully.");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[3]/img")).click();
        
        driver.findElement(By.xpath("//span[contains(.,'Add User')]")).click();
        Thread.sleep(3000);
     // 4. Add a single user with required details
        // Assume you have elements to input user details and a submit button
        driver.findElement(By.cssSelector(".ant-input-status-success")).sendKeys("mp");
        driver.findElement(By.cssSelector(".ng-tns-c282-76 > .input-gc-name")).sendKeys("mp@gmail.com");
        driver.findElement(By.xpath("//nz-select-search/input")).click();
        driver.findElement(By.xpath("//nz-option-item[4]/div")).click();
        driver.findElement(By.xpath("//nz-option-item[5]/div")).click();
        driver.findElement(By.xpath(".ng-tns-c282-83 > .input-gc")).sendKeys("mp 2");
        driver.findElement(By.cssSelector(".ng-tns-c282-84 > .input-gc")).sendKeys("New York");
        driver.findElement(By.xpath("//nz-option-item/div")).click();
        driver.findElement(By.xpath("//span/button/span")).click();
        
       
        
        Thread.sleep(3000);
        
     // 5. Verify landing on the edit user page
        // Assuming after adding a user, the application redirects to the edit user page
        String expectedTitle1 = "Edit User";
        String actualTitle1 = driver.getTitle();
        Assert.assertEquals(actualTitle1, expectedTitle1, "Failed to land on Edit User page after adding a user.");
        System.out.println("Landed on Edit User page successfully.");
        
     // 6. Return to the All Users page and confirm visibility in the user list table
        // Assuming there's a link or button to navigate back to the All Users page
        driver.findElement(By.linkText(".upload-edit path")).click();
        
        // Assuming there's a table containing user details, and you want to verify the visibility of the added user
        WebElement userTable = driver.findElement(By.id("All Users"));
        List<WebElement> userRows = userTable.findElements(By.tagName("tr"));
        boolean userFound = false;
        for (WebElement row : userRows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            for (WebElement column : columns) {
                if (column.getText().equals("mp")) {
                    userFound = true;
                    break;
                }
            }
            if (userFound) {
                break;
            }
        }
        Thread.sleep(6000);
        Assert.assertTrue(userFound, "Added user not found in the user list table.");
        System.out.println("Added user found in the user list table.");
    }

        
        
        
    




    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
