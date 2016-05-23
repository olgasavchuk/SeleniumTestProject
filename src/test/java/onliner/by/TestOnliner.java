package onliner.by;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestOnliner {

    WebDriver driver;

    @Before
    public void setUp() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testErrorOnLogin() {
        driver.get("https://www.onliner.by/");
        driver.findElement(By.cssSelector(".auth-bar__item.auth-bar__item--text")).click();

        WebElement wait1 = (new WebDriverWait(driver, 3000))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("auth-container__forms")));

        driver.findElement(By.cssSelector(".auth-box__input[type='text']")).sendKeys("wow");
        driver.findElement(By.cssSelector(".auth-box__input[type='password']")).sendKeys("wow");
        driver.findElement(By.cssSelector(".auth-box__auth-submit.auth__btn.auth__btn--green")).click();

        WebElement wait2 = (new WebDriverWait(driver, 3000))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.auth-box__line.auth-box__line--error.js-error")));


        String error_text = driver.findElement(By.cssSelector("div.auth-box__line.auth-box__line--error.js-error")).getText();

        assertThat(error_text,equalTo("Неверный пароль"));
    }




}
