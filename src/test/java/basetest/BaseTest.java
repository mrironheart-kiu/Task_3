package basetest;

import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import testdata.TestDataUser;

import static constant.ConstantBrowser.*;

/**
 * Базовый класс для тестов
 */
public class BaseTest {
    protected WebDriver driver;
    protected TestDataUser testDataUser;

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
}
