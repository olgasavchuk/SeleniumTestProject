package domainentities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.cssSelector;

public class Page {

    public static final String LOGIN_BUTTON = ".auth-bar__item.auth-bar__item--text";
    public static final String FORM_LOGIN = ".auth-box.auth-box--form";
    public static final String LOGIN_INPUT = ".auth-box__input[type='text']";
    public static final String PASSWORD_INPUT = ".auth-box__input[type='password']";
    public static final String SUBMIT_BUTTON = ".auth-box__auth-submit.auth__btn.auth__btn--green";
    public static final String ERROR_TEXT = ".auth-box__line.auth-box__line--error.js-error";

    WebDriver driver;
    Wait wait;

    public Page (WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.onliner.by/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,3000,10); // doubts about it
    }

    private WebElement $(By by) {
        return driver.findElement(by);
    }

    private void wait(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void login(String login, String password) {
        $(cssSelector(LOGIN_BUTTON)).click();
        wait(cssSelector(FORM_LOGIN));
        $(cssSelector(LOGIN_INPUT)).sendKeys(login);
        $(cssSelector(PASSWORD_INPUT)).sendKeys(password);
        $(cssSelector(SUBMIT_BUTTON)).click();
    }

    public String getErrorMsg() {
        wait(cssSelector(ERROR_TEXT));
        return $(cssSelector(ERROR_TEXT)).getText();
    }
}
