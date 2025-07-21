package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // ✅ المُحددات (Locators)
    By emailField = By.id("username");            // عدل حسب الـ ID الفعلي
    By passwordField = By.id("password");      // عدل حسب الـ ID الفعلي
    By loginButton = By.id("submit");        // عدل حسب الـ ID الفعلي
    By errorMessage = By.id("error");          // رسالة الخطأ (إن وجدت)

    // ✅ المُنشئ Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ إدخال البريد
    public void enterEmail(String username) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(username);
    }

    // ✅ إدخال كلمة المرور
    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    // ✅ النقر على زر الدخول
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // ✅ تنفيذ تسجيل الدخول بالكامل
    public void login(String username, String password) {
        enterEmail(username);
        enterPassword(password);
        clickLoginButton();
    }

    // ✅ جلب رسالة الخطأ
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    // ✅ التحقق من العنوان بعد تسجيل الدخول
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
