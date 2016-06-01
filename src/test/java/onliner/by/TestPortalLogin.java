package onliner.by;

import domainentities.Page;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestPortalLogin extends BaseTest {

    Page page;

// Use BeforeClass/AfterClass instead of Before/After to not close the browser after each test execution. In this case, setUp and tearDown should be also static. WebDrover and Page should be also static
    @Before
    public void setUpMethod() {
        page = new Page();
        page.open();
    }

    @Test
    public void testErrorOnLogin() {
        page.login("wow1", "wow2");
        String error_text = page.getErrorMsg();
        assertThat(error_text,equalTo("The username or password do not match our records. Please try again."));
    }

    @Test
    public void testSuccessLogin() {
        page.login("Olga.Savchuk","Qaolga1!");
        String user_name = page.getUserName();
        assertThat(user_name, equalTo("Olga Savchuk"));}


}
