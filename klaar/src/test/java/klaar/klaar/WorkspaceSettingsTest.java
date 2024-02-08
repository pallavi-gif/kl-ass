package klaar.klaar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WorkspaceSettingsTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Users/Dell/Desktop/chrome/chromedriver.exe");

        // Initialize the WebDriver instance
        driver = new ChromeDriver();
    }
   

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
    	
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
        // Verify successful login by checking for a welcome message or any element available after successful login
//        WebElement welcomeMessage = driver.findElement(By.xpath("//h1[contains(text(), 'Welcome')]"));
//        Assert.assertTrue(welcomeMessage.isDisplayed(), "Login failed");
   
        // Step 2: Navigate to the Settings module
        driver.findElement(By.xpath("//li[contains(.,'Settings')]")).click();
     
        // Step 3: Confirm landing on the Workspace settings page
        String expectedTitle = "Workspace Settings";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Failed to land on Workspace settings page.");
        System.out.println("Landed on Workspace settings page successfully.");
     
        // Step 4: Add a new workspace logo and confirm the successful addition
        WebElement uploadButton = driver.findElement(By.xpath("//span[contains(.,'Choose File')]"));
        Thread.sleep(5000);
        uploadButton.sendKeys("C:/Users/Dell/Desktop/file.png");
         driver.findElement(By.xpath("//p[contains(.,'Save')]")).click();
         Thread.sleep(3000);
        // Step 5: Edit the workspace logo, replace it with a new logo, and verify the change
        WebElement editButton = driver.findElement(By.cssSelector(".upload-edit path"));
        editButton.click();
        Thread.sleep(5000);
        editButton.sendKeys("C:/Users/Dell/Desktop/file1.png");
         driver.findElement(By.cssSelector(".ant-btn:nth-child(1) > svg > path"));
       
         Thread.sleep(3000);
        // Step 6: Delete the workspace logo and verify successful removal
         driver.findElement(By.cssSelector(".upload-delete circle")).click();
       
        WebElement deleteButton = driver.findElement(By.cssSelector(".upload-delete circle"));
        deleteButton.click();
        
        // Add code to enter user credentials and click on the login button
    }
//
//    @Test(priority = 2)
//    public void navigateToSettingsTest() {
//        // Step 2: Navigate to the Settings module
//        driver.findElement(By.linkText("Settings")).click();
//    }
//
//    @Test(priority = 3)
//    public void verifyWorkspaceSettingsPageTest() {
//        // Step 3: Confirm landing on the Workspace settings page
//        String expectedTitle = "Workspace Settings";
//        String actualTitle = driver.getTitle();
//        Assert.assertEquals(actualTitle, expectedTitle, "Failed to land on Workspace settings page.");
//        System.out.println("Landed on Workspace settings page successfully.");
//    }
//
//    @Test(priority = 4)
//    public void addNewLogoTest() {
//        // Step 5: Add a new workspace logo and confirm the successful addition
//        WebElement uploadButton = driver.findElement(By.id("uploadButton"));
//        uploadButton.sendKeys("/path/to/new_logo_file.png"); // Assuming you have an input type="file" to upload the logo
//        // Add code to confirm successful addition, for example, you can check if the new logo is displayed on the page
//    }
//
//    @Test(priority = 5)
//    public void editWorkspaceLogoTest() {
//        // Step 6: Edit the workspace logo, replace it with a new logo, and verify the change
//        WebElement editButton = driver.findElement(By.id("editButton"));
//        editButton.click();
//        WebElement newLogoUploadButton = driver.findElement(By.id("newLogoUploadButton"));
//        newLogoUploadButton.sendKeys("/path/to/different_logo_file.png"); // Assuming you have an input type="file" to upload the new logo
//        // Add code to verify the change, for example, you can check if the new logo is displayed on the page
//    }
//
//    @Test(priority = 6)
//    public void deleteWorkspaceLogoTest() {
//        // Step 7: Delete the workspace logo and verify successful removal
//        WebElement deleteButton = driver.findElement(By.id("deleteButton"));
//        deleteButton.click();
//        // Add code to verify successful removal, for example, you can check if the logo element is not present on the page anymore
//    }
//
    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}








