package testAppetize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class TestLogin extends InitTest {

    @Test(dataProvider = "data")
    public void test(String email, String password, String apkFilePath, String app_id, String name) throws InterruptedException {
        goToLogin();
        testLogin(email, password);
    }

    // Navigate to the login page
    public void goToLogin() {
        // Wait for the login link to be clickable and click it
        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Login")));
        loginLink.click();
    }

    // Perform login action
    private void testLogin(String username, String password) throws InterruptedException {
        // Wait for the username input to be clickable
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
        usernameField.click();
        usernameField.sendKeys(username);

        // Wait for the password input to be clickable
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        passwordField.click();
        passwordField.sendKeys(password);

        // Wait for the login button to be clickable
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Login')]")));
        loginButton.click();
    }
}
