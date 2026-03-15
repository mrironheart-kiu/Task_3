package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Класс с методми ожидания веб-элементов
 */
public class WaitUtils {
    // Задержка в секундах по умолчанию
    private static final int DEFAULT_TIMEOUT_SECONDS = 5;

    /**
     * Метод ожидает когда веб-элемент станет кликабелен в течении времени по умолчанию
     *
     * @param driver  веб-драйвер по умолчанию
     * @param locator локатор веб-элемента страницы
     */
    public static void waitToBeClickable(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Метод ожидает когда веб-элемент станет виден в течении времени по умолчанию
     *
     * @param driver  веб-драйвер по умолчанию
     * @param locator локатор веб-элемента страницы
     */
    public static void waitToBeVisible(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Метод ожидает указанный URL в течении времени по умолчанию
     *
     * @param driver веб-драйвер по умолчанию
     * @param url    ожидаемый URL
     */
    public static void waitUrlToBe(WebDriver driver, String url) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.urlToBe(url));
    }

    /**
     * Метод ожидает указанное изменение в выбранном атрибует веб-элемента
     *
     * @param driver        веб-драйвер по умолчанию
     * @param locator       локатор веб-элемента страницы
     * @param attribute     имя атрибута, в котором ожидается изменение. Пример: "class", "type"
     * @param expectedValue значение, которое ожидается в атрибуте
     */
    public static void waitAttributeChange(WebDriver driver, By locator, String attribute, String expectedValue) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.attributeContains(locator, attribute, expectedValue));
    }
}
