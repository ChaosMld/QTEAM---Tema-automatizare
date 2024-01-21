package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverManager {


    private static WebDriver driver;


    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments(("--start-maximized"));
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
    }



    }

