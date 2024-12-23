package testAppetize;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class InitTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    @BeforeMethod
    public void setup() {
        // Ensure the correct path to the msedgedriver.exe
        System.setProperty("webdriver.edge.driver", "C:\\Users\\ibrah\\Documents\\Console\\Java\\web_driver_edge\\msedgedriver.exe");

        // Initialize WebDriver
        driver = new EdgeDriver();

        // Maximize window
        driver.manage().window().maximize();

        // Open the website
        driver.get("https://appetize.io/");
        
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @DataProvider(name = "data")
    public Object[][] dataProvider() throws IOException {
        // Ensure ExcelUtility handles data from multiple sheets properly
        ExcelUtility excel1 = new ExcelUtility("Sheet1");
        ExcelUtility excel2 = new ExcelUtility("Sheet2");
        ExcelUtility excel3 = new ExcelUtility("Sheet3");

        // Ensure that rowCount is consistent across sheets
        int rowCount = excel1.count();
        Object[][] data = new Object[rowCount][5];

        for (int i = 0; i < rowCount; i++) {
            data[i][0] = excel1.getData(i, 0);
            data[i][1] = excel1.getData(i, 1);
            data[i][2] = excel2.getData(i, 0);
            data[i][3] = excel3.getData(i, 0);
            data[i][4] = excel3.getData(i, 1);
        }

        return data;
    }

    @AfterMethod
    public void teardown() throws IOException, InterruptedException {
        if (driver != null) {
            // Close the browser and quit the WebDriver
            //driver.quit();
        }
    }
}
