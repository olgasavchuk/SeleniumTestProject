package onliner.by;

import domainentities.Page;
import domainentities.WebDriverHolder;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestOnliner {

    WebDriver driver;
    Page page;

    @Before
    public void setUp() {

        driver = new FirefoxDriver();
        WebDriverHolder.setDriver(driver);
        page = new Page();
    }

    @Test
    public void testErrorOnLogin() {
        page.open();
        page.login("wow1", "wow2");

        String error_text = page.getErrorMsg();
        assertThat(error_text,equalTo("The username or password do not match our records. Please try again."));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
