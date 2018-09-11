package util;

import net.serenitybdd.core.exceptions.SerenityManagedException;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.Date;

public class WebBase extends PageObject {
    public final int WAIT_TIME_OUT = 1000 * 10;

    public void waitAndSend(WebElement webElement, CharSequence keysToSend) {
        waitFor(webElement);
        webElement.sendKeys(keysToSend);
    }

    public void waitAndClick(WebElement webElement) {
        waitFor(webElement);
        webElement.click();
    }

    public boolean waitForDisplayed(WebElement webElement) {
        long timeStart = System.currentTimeMillis();
        long timeEnd = System.currentTimeMillis();
        try {
            while ((timeEnd - timeStart) < WAIT_TIME_OUT) {
                if (webElement.isDisplayed())
                    return true;
                else {
                    wait(200);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SerenityManagedException e1) {}

        return false;
    }

    public String getElementText(WebElement webElement) {
        waitFor(webElement);
        return webElement.getText();
    }

    public String nameGenerator() {
        return new Date().toString().substring(0, 10).replace(" ", "");
    }
}
