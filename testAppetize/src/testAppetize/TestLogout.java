package testAppetize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestLogout extends TestLogin {
	
	@Override
	public void test(String email, String password, String apkFilePath, String app_id, String name) throws InterruptedException {
		super.test(email, password, apkFilePath, app_id, name);
		logout();
	}
	
	// Method to log out
	private void logout() {
		try {
			WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
			logoutButton.click();
			System.out.println("Clicked Logout");
		} catch (Exception e) {
			System.err.println("Logout failed: " + e.getMessage());
		}
	}
	
}
