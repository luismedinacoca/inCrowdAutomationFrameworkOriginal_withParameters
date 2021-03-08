package utilities;

import managers.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

/**
 * Created by Lama on 2021-02-04.
 */
public class WebDriverUtils {
    public static DriverManager driverManager;

    public static WebElement waitForWebElement(WebElement webElement, int timeToWait) {
        WebElement myDynamicElement;
        try {
            myDynamicElement = (new WebDriverWait(driverManager.getDriver(), timeToWait))
                    .until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e) {
            throw new RuntimeException("Element is not waiting", e);
        }
        return myDynamicElement;
    }

    public static WebElement waitForElementBy(By by, int timeToWait) {
        WebElement myDynamicElement;
        try {
            myDynamicElement = (new WebDriverWait(driverManager.getDriver(), timeToWait))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            throw new RuntimeException("Element is not waiting", e);
        }
        return myDynamicElement;
    }

    public static WebElement waitForButtonClickable(WebElement androidElement, int timeToWait) {
        WebElement myDynamicElement;
        try {
            myDynamicElement = (new WebDriverWait(driverManager.getDriver(), timeToWait))
                    .until(ExpectedConditions.elementToBeClickable(androidElement));
        } catch (Exception e) {
            throw new RuntimeException("Element is not waiting", e);
        }
        return myDynamicElement;
    }

}
