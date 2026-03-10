import factory.WebDriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static constant.ConstantBrowser.*;
import static constant.ConstantUrl.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRegistrationTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new WebDriverFactory().getWebDriver(CHROME);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void faqSpoilerDescriptionTest() {
        driver.get(URL_MAIN_PAGE);
    }
}
