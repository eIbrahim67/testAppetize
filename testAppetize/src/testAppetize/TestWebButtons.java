package testAppetize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestWebButtons extends TestLogin {
	
	@Override
	public void test(String email, String password, String apkFilePath, String app_id, String name) throws InterruptedException {
		super.test(email, password, apkFilePath, app_id, name);
		testWebButtons();
	}
	
	private void testWebButtons() {
		// List of buttons and their corresponding link texts
		String[] buttonLinks = {
			"Apps", 
			"Device Sandbox", 
			"Reports", 
			"Organization Settings", 
			"General", 
			"API Token", 
			"Security Events", 
			"Plan & Billing", 
			"Team Management", 
			"Session Defaults"
		};

		// Loop through each button and click it
		for (String buttonText : buttonLinks) {
			clickButton(buttonText);
		}
	}
	
	private void clickButton(String buttonText) {
		try {
			// Wait until the button is clickable and then click
			WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(buttonText)));
			button.click();
			System.out.println("Clicked " + buttonText);
			
			// Optional: Add assertion to verify page change or URL
			// For example, you could check if the page title contains the button name
			// Assert.assertTrue(driver.getTitle().contains(buttonText));
			
		} catch (Exception e) {
			System.err.println("Error clicking on button: " + buttonText);
			e.printStackTrace();
		}
	}
}
