package steps.serenity;

import models.User;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import util.WebBase;

public class LoginSteps extends ScenarioSteps{
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private HomePage homePage;

    @Step
    public void openLoginPage() {
        loginPage.open();
    }

    @Step
    public void waitLoginPageLoaded() {
        loginPage.loginPageLoaded();
    }

    @Step
    public void login(User user) {
        loginPage.fillUsername(user.getUsername());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLogin();
    }

    @Step
    public void checkLoginFailed(String msg) {
        String err = loginPage.getMsg();
        Assert.assertEquals("Error message didn't display",msg, err);
    }

    @Step
    public void clickRegisterLink() {
        loginPage.clickRegister();
    }

    @Step
    public void registerPageLoaded() {
        Assert.assertTrue(registerPage.waitRegisterPageLoad());
    }

    @Step
    public void clickCancelLink() {
        registerPage.clickCancel();
    }

    @Step
    public void loginPageOpened() {
        Assert.assertTrue(loginPage.loginPageLoaded());
    }

    @Step
    public void registerUser(User user) {
        registerPage.fillFirstName(user.getFirstName());
        registerPage.fillLastName(user.getLastName());
        registerPage.fillUsername(user.getUsername());
        registerPage.fillPassword(user.getPassword());
        registerPage.clickRegister();
    }

    @Step
    public void checkRegister(String msg) {
        Assert.assertTrue(loginPage.loginPageLoaded());
        Assert.assertEquals("message didn't displayed", msg, loginPage.getMsg());
    }

    @Step
    public void checkUserLogin(User user) {
        Assert.assertTrue(homePage.homePageLoaded());
        Assert.assertTrue(homePage.getNameString().contains(user.getFirstName() + " " + user.getLastName()));
    }

    @Step
    public void checkDuplicateUsername(User user) {
        String errorMsg = "\"" + user.getUsername() + "\" is already taken";
        Assert.assertTrue(registerPage.getMsg().contains(errorMsg));
    }
}
