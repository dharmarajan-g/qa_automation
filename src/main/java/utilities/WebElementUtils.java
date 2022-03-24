package utilities;

import components.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebElementUtils extends WebDriverUtil {
    private static WebElementUtils utlobj = new WebElementUtils();

    public static WebElementUtils getUtlObj() {
        return utlobj;
    }

    public static RemoteWebDriver getDriver() {
        return getDriver();
    }

    public void waitForPresenceofElementVisible(WebElement element, int wttime) {
        WebDriverWait wait = new WebDriverWait(WebElementUtils.getDriver(), wttime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isElementDisplayed(WebElement element) {
        WebElementUtils.getUtlObj().waitForPresenceofElementVisible(element, 20);
        return true;
    }

    public void click(WebElement element) {
        WebElementUtils.getUtlObj().waitForPresenceofElementVisible(element, 20);
        element.click();
    }
}
