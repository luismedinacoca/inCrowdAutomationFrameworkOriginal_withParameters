package stepdefinitions;

import io.cucumber.java.en.Given;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.TestBase;

/**
 * Created by Lama on 2021-02-18.
 */
public class LogoutSteps extends TestBase {
    TestBase testBase = new TestBase();
    LoginPage loginPage = testBase.getPageObjectManager().getLoginPage();
    HomePage homePage = testBase.getPageObjectManager().getHomePage();


    @Given("user clicks on Logout button")
    public void user_clicks_on_logout_button() {
        homePage.clickLogout();
    }
}
