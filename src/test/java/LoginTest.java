import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;

    @BeforeTest
    public void setup() {
        // Set the path to ChromeDriver
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Open the browser and navigate to the login page
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void loginTest() {
        // Locate username and password fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        // Locate login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        // Enter login credentials
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        // Click login button
        loginButton.click();

        // Verify successful login by checking URL or presence of an element on the dashboard
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Login failed. URL did not match.");
    }

    @AfterTest
    public void teardown() {
        // Close the browser
        driver.quit();
    }
}

