package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;

import pageObjects.LoginPage;
import testBase.TestBase;

import java.io.IOException;

/**
 * Created by Lama on 2021-01-27.
 */
public class LoginSteps extends TestBase {
    TestBase testBase = new TestBase();
    LoginPage loginPage = testBase.getPageObjectManager().getLoginPage();


    @Given("user is on the {string} screen")
    public void user_is_on_the_screen(String string) {
        System.out.println(string);
    }
    @Given("user enter username {string} and password {string} to login")
    public void user_enter_username_and_password_to_login(String string, String string2) throws IOException {
            loginPage.enterUserName(string);
            loginPage.enterPassword(string2);
            loginPage.clickLogin();
    }


}
