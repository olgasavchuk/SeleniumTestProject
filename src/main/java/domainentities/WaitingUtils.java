//class for waiting manipulation

package domainentities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class WaitingUtils {

    public static WebDriverWait waitFor(ExpectedCondition<WebElement> conditions){
        return new WebDriverWait(WebDriverHolder.getDriver(),3000,10);
    }

    public static void wait(By by) {
        waitFor(presenceOfElementLocated(by));
    }

}
