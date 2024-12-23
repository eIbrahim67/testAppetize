package testAppetize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestUploadApk extends TestLogin {

    @Override
    public void test(String email, String password, String apkFilePath, String app_id, String name) throws InterruptedException {
		super.test(email, password, apkFilePath, app_id, name);
        
        // Then upload APK file
        uploadApk(apkFilePath);
    }
    
    private void uploadApk(String apkFilePath) {
        try {
            // Wait for the upload button and click it
            WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Upload App')]")));
            uploadButton.click();
            System.out.println("Clicked Upload button");

            // Wait for the file input to appear and send the file path
            WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")));
            fileInput.sendKeys(apkFilePath);
            System.out.println("File input has been filled with APK path");
            
            // Wait for the 'View Details' button to be clickable and click it
            WebElement viewDetails = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"headlessui-dialog-panel-:r1:\"]/div/div/div[2]/button")));
        	viewDetails.click();
            System.out.println("Clicked View Details button");

        } catch (Exception e) {
            System.err.println("Error during APK upload: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
