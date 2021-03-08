package managers;

import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;


/**
 * Created by Lama on 2021-01-21.
 */


public class DriverManager {
    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String MICROSOFT_EDGE_DRIVER_PROPERTY = "webdriver.edge.driver";
    private static final String OPERA_DRIVER_PROPERTY = "webdriver.opera.driver";

    public DriverManager() {
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
    }

    public WebDriver getDriver() {
        if(driver == null) driver = createDriver();
        return driver;
    }


    private WebDriver createDriver() {
        switch (driverType) {
            case CHROME :
                System.setProperty(CHROME_DRIVER_PROPERTY,  "src/test/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case MICROSOFT_EDGE:
                System.setProperty(MICROSOFT_EDGE_DRIVER_PROPERTY,  "src/test/resources/drivers/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            case OPERA:
                System.setProperty(OPERA_DRIVER_PROPERTY,  "src/test/resources/drivers/operadriver.exe");
                driver = new OperaDriver();
                break;
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitWait(), TimeUnit.SECONDS);
        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }

}