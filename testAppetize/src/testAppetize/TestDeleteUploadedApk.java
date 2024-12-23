package testAppetize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestDeleteUploadedApk extends TestLogin {
	
	@Override
	public void test(String email, String password, String apkFilePath, String app_id, String name) throws InterruptedException {
		super.test(email, password, apkFilePath, app_id, name);
		deleteUploadedApk(app_id);
	}
	
	private void deleteUploadedApk(String app_id) {
		try {
			// Click on the "Apps" link
			WebElement apps = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Apps")));
			apps.click();
			System.out.println("Clicked Apps");

			// Click on the app link (e.g., GymPro app)
			WebElement appLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '" + app_id + "')]")));  // Use the app_id dynamically
			appLink.click();
			System.out.println("Clicked on the " + app_id + " app link.");

	        WebElement deleteOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/main/section/div/div[2]/div[2]/div[1]/div[2]/button/svg")));
	        deleteOption.click();
	        System.out.println("Clicked Delete Option");

			// Confirm the action by entering the app_id (Ensure that the input field is targeted)
			WebElement appIdConfirmInput = wait.until(ExpectedConditions.elementToBeClickable(By.name("confirm")));
			appIdConfirmInput.sendKeys(app_id);
			System.out.println("Entered App Id for confirmation");

			// Click the final delete button to confirm
			WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Delete')]")));
			deleteButton.click();
			System.out.println("Clicked Final Delete Button");

			// Optional: Verify deletion
			// You can verify whether the app has been deleted by checking if it's no longer visible or if a success message appears.
			// Example: Assert.assertFalse(isAppPresent(app_id));
		} catch (Exception e) {
			System.err.println("An error occurred during APK deletion: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
