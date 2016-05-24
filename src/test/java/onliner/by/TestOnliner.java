package onliner.by;

import domainentities.Page;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestOnliner {

    WebDriver driver;
    Page page;

    @Before
    public void setUp() {

        driver = new FirefoxDriver();
        page = new Page(driver);
    }

    @Test
    public void testErrorOnLogin() {
        page.open();
        page.login("wow1", "wow2");

        String error_text = page.getErrorMsg();
        assertThat(error_text,equalTo("Неверный ник или e-mail"));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
