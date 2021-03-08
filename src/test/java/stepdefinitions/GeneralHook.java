package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import testBase.TestBase;

/**
 * Created by Lama on 2021-02-23.
 */
public class GeneralHook extends TestBase{
    TestBase testBase = new TestBase();
    WebDriver driver = testBase.getDriver();


    @Before
    public void SetupScenario(Scenario name) {

        System.out.println("========Before Scenario===========");
        System.out.println("Name : " + name.getName());
    }

    @After
    public void tearDownScenario(Scenario name){
        System.out.println("========After Scenario===========");
        System.out.println("Name : " + name.getName());
        try {
            if (name.isFailed()) {
                //------------------------- Attaching Screen shot in the Report -------------------------
                byte[] screenshot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
                name.attach(screenshot, "image/png", name.getName());

            }
        }
        catch(Exception e){
            name.log("WARNING. Failed to take screenshot with following exception : "+e.getMessage());
        }
    }
}
