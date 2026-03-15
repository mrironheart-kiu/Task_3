package pom;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Базовый класс для всех страниц сайта Stellar Burgers
 */
@AllArgsConstructor
public class BasePage {
    protected WebDriver driver;

    /**
     * Метод нажимает на кнопку на странице
     *
     * @param locator локатор типа Bу для идентификации веб-элемента
     */
    public void clickButton(By locator) {
        driver.findElement(locator).click();
    }

    /**
     * Метод проверяет активность поля и очищает его
     *
     * @param locator локатор типа Bу для идентификации веб-элемента
     */
    private void checkAndClearField(By locator) {
        driver.findElement(locator).isEnabled();
        driver.findElement(locator).clear();
    }

    /**
     * Метод вводит в поле переданное значение
     *
     * @param locator  локатор типа Bу для идентификации веб-элемента
     * @param newValue значение типа String для ввода в поле
     */
    public void setField(By locator, String newValue) {
        checkAndClearField(locator);
        sendKeys(locator, newValue);
    }

    /**
     * Метод возвращает значение атрибута по его имени
     *
     * @param locator       локатор типа Bу для идентификации веб-элемента
     * @param attributeName значение типа String для поиска
     * @return значение атрибута типа String
     */
    public String getAttributeValue(By locator, String attributeName) {
        return driver.findElement(locator).getAttribute(attributeName);
    }

    /**
     * Метод передаёт веб-элементу указанную строку - для ввода в поле или передачи команд
     *
     * @param locator локатор типа Bу для идентификации веб-элемента
     * @param keys    значение типа String для передачи веб-элементу
     */
    public void sendKeys(By locator, String keys) {
        driver.findElement(locator).sendKeys(keys);
    }
}
