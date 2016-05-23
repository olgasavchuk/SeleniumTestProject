package onliner.by;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

        //WebDriver wait = new WebDriverWait(driver, 500);
        //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".auth-box__input[type='text']")));

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("blabla");
        //driver.findElement(By.cssSelector(".auth-box__input[type='text']")).sendKeys("wow");
        driver.findElement(By.cssSelector(".auth-box__input[type='password']")).sendKeys("wow");
        driver.findElement(By.cssSelector(".auth-box__auth-submit.auth__btn.auth__btn--green")).click();

        //String error_text = driver.findElement(By.cssSelector("div.auth-box__line.auth-box__line--error.js-error")).getText();
        String error_text = driver.findElement(By.xpath("//div[@id='auth-container__forms']/div/div[2]/form/div[4]/div")).getText();

        assertThat(error_text,equalTo("Неверный пароль"));
    }
}
