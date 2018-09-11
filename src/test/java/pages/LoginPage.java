package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.WebBase;

public class LoginPage extends PageObject {
    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(), 'Register')]")
    private WebElement registerLink;

    @FindBy(xpath = "//div[contains(@class, 'alert')]")
    private WebElement msg;

    @FindBy(xpath = "//h2[contains(text(), 'Login')]")
    private WebElement header;

    WebBase wb = new WebBase();

    public void go(String url) {
        getDriver().get(url);
    }

    public boolean loginPageLoaded() {
        return wb.waitForDisplayed(header);
    }

    public void fillUsername(String un) {
        wb.waitAndSend(username, un);
    }

    public void fillPassword(String pwd) {
        wb.waitAndSend(password, pwd);
    }

    public void clickLogin() {
        wb.waitAndClick(loginButton);
    }

    public void clickRegister() {
        wb.waitAndClick(registerLink);
    }

    public String getMsg() {
        return wb.getElementText(msg);
    }
}
