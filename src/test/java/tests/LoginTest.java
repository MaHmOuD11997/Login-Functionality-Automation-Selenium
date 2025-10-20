package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setupClass() {
        
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://practicetestautomation.com/practice-test-login/");  
        loginPage = new LoginPage(driver);
    }

    @Test(description = "Login with valid credentials")
    @Description("Test Description: Valid login test with correct username and password")
    public void testValidLogin() {
        loginPage.login("student", "Password123");

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean urlContainsSuccess = wait.until(ExpectedConditions.urlContains("logged-in-successfully"));
        Assert.assertTrue(urlContainsSuccess, "User should be redirected to success page");

    }

    @Test(description = "Login with invalid password")
    @Description("Test Description: Invalid login test with wrong password")
    public void testInvalidPassword() {
        loginPage.login("student", "WrongPass");
        System.out.println(loginPage.getErrorMessage());
        Assert.assertTrue(loginPage.getErrorMessage().contains("Your password is invalid!"));
    }

    @Test(description = "Login with empty fields")
    @Description("Test Description: Login attempt with empty email and password")
    public void testEmptyFields() {
        loginPage.login("", "");
        System.out.println( loginPage.getErrorMessage());
        Assert.assertTrue(loginPage.getErrorMessage().contains("Your username is invalid!"));  
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
