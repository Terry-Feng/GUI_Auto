package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.User;
import net.thucydides.core.annotations.Steps;
import steps.serenity.LoginSteps;
import util.WebBase;

public class LoginBDDSteps {
    User user;

    @Steps
    private LoginSteps loginSteps;

    @Given("^user is on the login page$")
    public void loadLoginPage() {
        loginSteps.openLoginPage();
        loginSteps.waitLoginPageLoaded();
    }

    @When("^login with username: \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void login(String username, String password) {
        user = new User();
        user.setUsername(username);
        user.setPassword(password);
        loginSteps.login(user);
    }

    @When("^login with fixed username and password \"([^\"]*)\"$")
    public void loginWithFixedName(String password) {
        user = new User();
        String suffix = new WebBase().nameGenerator();
        user.setFirstName("first_" + suffix);
        user.setLastName("last_" + suffix);
        user.setUsername("user_" + suffix);
        user.setPassword(password);
        loginSteps.login(user);
    }

    @When("^click register link$")
    public void clickRegisterLink() {
        loginSteps.clickRegisterLink();
    }

    @Then("^register page displayed$")
    public void registerPageOpen() {
        loginSteps.registerPageLoaded();
    }

    @When("^click cancel link$")
    public void clickCancelLink() {
        loginSteps.clickCancelLink();
    }

    @Then("^login page displayed$")
    public void loginPageLoaded() {
        loginSteps.loginPageOpened();
    }

    @Then("^error message displays as \"([^\"]*)\"$")
    public void checkLoginFailed(String msg) {
        loginSteps.checkLoginFailed(msg);
    }

    @When("^register with fixed username and password \"([^\"]*)\"$")
    public void registerUser(String password) {
        String suffix = new WebBase().nameGenerator();
        user = new User();
        user.setFirstName("first_" + suffix);
        user.setLastName("last_" + suffix);
        user.setUsername("user_" + suffix);
        user.setPassword(password);
        loginSteps.registerUser(user);
    }

    @Then("^page navigate to login page and display message \"([^\"]*)\"$")
    public void checkUserRegister(String msg) {
        loginSteps.checkRegister(msg);
    }

    @Then("^user login successfully$")
    public void checkUserLogin() {
        loginSteps.checkUserLogin(user);
    }

    @Then("^error msg displayed as username is already taken$")
    public void checkDuplicateUsername() {
        loginSteps.checkDuplicateUsername(user);
    }
}
