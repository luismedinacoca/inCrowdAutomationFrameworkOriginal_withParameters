package testBase;

import managers.DriverManager;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;

/**
 * Created by Lama on 2021-02-17.
 */
public class TestBase {
    public  static WebDriver driver;
    public DriverManager driverManager;
    public static PageObjectManager pageObjectManager;


    public WebDriver createBrowser(String browserName) {

        driverManager = new DriverManager(browserName);
        driver = driverManager.getDriver();
        return driver;

    }

    public PageObjectManager getPageObjectManager()
    {
        pageObjectManager = new PageObjectManager(driver);
        return pageObjectManager;
    }

    public WebDriver getDriver()
    {
        return driver;
    }

}
