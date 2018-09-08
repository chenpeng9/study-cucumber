package driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static WebDriver driver;

    public DriverFactory() {
        initialize();
    }

    private void initialize() {
        if (driver == null) {
            createNewDriverInstance();
        }
    }

    private void createNewDriverInstance() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void destoryDriver() {
        driver.quit();
        driver = null;
    }
}
