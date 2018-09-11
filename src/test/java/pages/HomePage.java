package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.WebBase;

public class HomePage extends PageObject {
    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    private WebElement logoutLink;

    @FindBy(xpath = "//a[contains(text(), 'delete')]")
    private WebElement deleteLink;

    @FindBy(xpath = "//ul")
    private WebElement users;

    WebBase wb = new WebBase();

    public boolean homePageLoaded() {
        return wb.waitForDisplayed(logoutLink);
    }

    public String getNameString() {
        return wb.getElementText(users);
    }
}
