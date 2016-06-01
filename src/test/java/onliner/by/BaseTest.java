package onliner.by;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static domainentities.WebDriverHolder.setDriver;

// class to open browser at the beginning and close it at the end of tests execution
public abstract class BaseTest {

    private static WebDriver driver;

    // Use BeforeClass/AfterClass instead of Before/After to not close the browser after each test execution. In this case, setUp and tearDown should be also static. WebDrover and Page should be also static
    @BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
        setDriver(driver);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.close();
    }

}
