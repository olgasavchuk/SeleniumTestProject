//class for browser manipulation

package domainentities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static domainentities.WebDriverHolder.*;

public class UiUtils {

    //find some element on the page
    public static WebElement $(By by) {
        return getDriver().findElement(by);
    }

    //find ALL elements from the page
    public static List<WebElement> $$(By by) {
        return getDriver().findElements(by);
    }

    public static void maximizeWindow(){
        getDriver().manage().window().maximize();
    }

    public static void goTo(String url){
        getDriver().get("https://ct1.qa1.complytrack.com/portal");
    }

}
