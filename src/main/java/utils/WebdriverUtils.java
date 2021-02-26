package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebdriverUtils {

    //SINGLETON WEBDRIVER

    private static WebDriver driver;

    private WebdriverUtils() {
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            String browserType = LocalConfigUtils.getProperty("browser");
            System.out.println("browser: " + browserType);
            switch (browserType.toLowerCase()) {
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", "/Users/tim/Desktop/TechLeadAcademy/Selenium/libs/geckodriver");
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.setProperty("webdriver.chrome.driver", "/Users/tim/Desktop/TechLeadAcademy/Selenium/libs/chromedriver");
                    driver = new ChromeDriver();
                    break;
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void closeWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
