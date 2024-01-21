package StepDefinitions;

import driverManager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;

public class Hooks {

    @Before
    public void setup() {
        System.out.println("****** A new test run just started ******");
        //WebDriver driver = DriverManager.getDriver();
        //driver.manage().deleteAllCookies();
    }

    @After
    public void closeBrowser() {
        DriverManager.closeDriver();
    }


}
