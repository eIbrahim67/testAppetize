package testAppetize;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUploadedApk extends TestLogin {

    @Override
    public void test(String email, String password, String apkFilePath, String app_id, String name) throws InterruptedException {
		super.test(email, password, apkFilePath, app_id, name);

        testUploadedApp(name);
    }
    
    private void testUploadedApp(String name) {
        try {

            // Click on the app link (e.g., Winkel app)
            WebElement appLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//span[text()='" + name + "']")
                ));
        	appLink.click();
            System.out.println("Clicked on the Winkel app link.");
            
            // Start the app
            WebElement play = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Play")));
            play.click();
            System.out.println("Clicked Play");

            WebElement enable = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Enable')]")));  // More readable XPath
            enable.click();
            System.out.println("Clicked Enable");

            WebElement start = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Start')]")));
            start.click();  
            System.out.println("Clicked Start");

            // Click on the 'Inspect' button
            WebElement inspect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Inspect']")));
            inspect.click();
            System.out.println("Clicked Inspect");
            
            try {
                // Wait for btn1 to become clickable within 10 seconds
                new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.elementToBeClickable(By.id("headlessui-menu-button-:rs:")));
            } catch (Exception e) {
            	
                // Click the Landscape button
            	WebElement landscape = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Landscape']")));
                landscape.click();
                System.out.println("Clicked Landscape");
                
                // Click the Export button
                WebElement exportButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("headlessui-menu-button-:rs:")));
                exportButton.click();
                System.out.println("Clicked Export");

                // Choose export to JSON
                WebElement exportToJson = wait.until(ExpectedConditions.elementToBeClickable(By.id("headlessui-menu-item-:ru:")));
                exportToJson.click();
                System.out.println("Clicked Download JSON");

                // Confirm download button is present and clicked
                WebElement downloadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Download')]")));
                downloadButton.click();
                System.out.println("Clicked Download");
                
            }
        } catch (Exception e) {
            System.err.println("Error during APK testing: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
