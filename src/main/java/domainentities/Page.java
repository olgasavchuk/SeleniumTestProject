package domainentities;

import static domainentities.UiUtils.*;
import static org.openqa.selenium.By.cssSelector;

public class Page {

    public static final String LOGIN_BUTTON = ".floatRight.marginTop2.icon-arrow-white-down";
    public static final String LOGIN_INPUT = ".marginBottom7[type='text']";
    public static final String PASSWORD_INPUT = ".marginBottom7[type='password']";
    public static final String SUBMIT_BUTTON = ".button";
    public static final String ERROR_TEXT = ".error-notification.padding5.lineHeight14.red-text";
    public static final String USER_NAME = "#nav-profile>span";

    public void open() {
        goTo("https://ct1.qa1.complytrack.com/portal");
        maximizeWindow();
    }

    public void login(String login, String password) {
        WaitingUtils.wait(cssSelector(LOGIN_BUTTON));
        $(cssSelector(LOGIN_BUTTON)).click();
        $(cssSelector(LOGIN_INPUT)).sendKeys(login);
        $(cssSelector(PASSWORD_INPUT)).sendKeys(password);
        $(cssSelector(SUBMIT_BUTTON)).click();
    }

    public String getErrorMsg() {
        WaitingUtils.wait(cssSelector(ERROR_TEXT));
        return $(cssSelector(ERROR_TEXT)).getText();
    }

    public String getUserName() {
        WaitingUtils.wait(cssSelector(USER_NAME));
        return $(cssSelector(USER_NAME)).getText();
    }
}
