package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.WebBase;

public class RegisterPage extends PageObject {
    @FindBy(xpath = "//h2[contains(text(), 'Register')]")
    private WebElement header;

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[contains(text(), 'Register')]")
    private WebElement registerButton;

    @FindBy(xpath = "//a[contains(text(), 'Cancel')]")
    private WebElement cancelLink;

    @FindBy(xpath = "//div[contains(@class, 'alert')]")
    private WebElement msg;

    WebBase wb = new WebBase();

    public boolean waitRegisterPageLoad() {
        return wb.waitForDisplayed(header);
    }

    public void fillFirstName(String fn) {
        wb.waitAndSend(firstName, fn);
    }

    public void fillLastName(String ln) {
        wb.waitAndSend(lastName, ln);
    }

    public void fillUsername(String un) {
        wb.waitAndSend(username, un);
    }

    public void fillPassword(String pwd) {
        wb.waitAndSend(password, pwd);
    }

    public void clickRegister() {
        wb.waitAndClick(registerButton);
    }

    public void clickCancel() {
        wb.waitAndClick(cancelLink);
    }

    public String getMsg() {
        return wb.getElementText(msg);
    }
}
