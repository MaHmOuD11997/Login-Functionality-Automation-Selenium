package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // ✅ المُحددات (Locators)
    By emailField = By.id("username");           
    By passwordField = By.id("password");      
    By loginButton = By.id("submit");        
    By errorMessage = By.id("error");          

    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    
    public void enterEmail(String username) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(username);
    }

    
    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

   
    public void login(String username, String password) {
        enterEmail(username);
        enterPassword(password);
        clickLoginButton();
    }

    
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

   
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
