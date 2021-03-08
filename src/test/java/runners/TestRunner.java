package runners;


import io.cucumber.core.gherkin.Step;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import testBase.TestBase;

/**
 * Created by Lama on 2021-01-27.
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@smoke",
        monochrome = true //Don't colour terminal output.
)

public class TestRunner extends AbstractTestNGCucumberTests {

    public TestBase testBase;

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        testBase = new TestBase();
        testBase.createBrowser().get("https://opensource-demo.orangehrmlive.com/index.php/");

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        System.out.println("Execute me ");
        testBase.driverManager.closeDriver();
        Thread.sleep(3000);
    }

}

