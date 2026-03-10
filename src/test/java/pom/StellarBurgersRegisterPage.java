package pom;

import io.qameta.allure.Step;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Класс страницы регистрации сайта Stellar Burgers
 */
@RequiredArgsConstructor
public class StellarBurgersRegisterPage {
    private final WebDriver driver;

    // Поле "Имя" на странице регистрации [text()='Имя']
    private final By FIELD_NAME = By.xpath("//label[text()='Имя']//../input[@name='name']");
    // Поле "Email" на странице регистрации
    private final By FIELD_EMAIL = By.xpath("//label[text()='Email']//../input[@name='name']");
    // Поле "Пароль" на странице регистрации
    private final By FIELD_PASSWORD = By.xpath("//input[@type='password']");
    // Кнопка "Зарегистрироваться" на странице регистрации
    private final By BUTTON_REGISTRATION = By.xpath("//button[text()='Зарегистрироваться']");

    /**
     * Вспомогательный метод для заполнения значений полей
     *
     * @param fieldName селектор для веб-элемента
     */
    private void checkAndClearField(By fieldName) {
        driver.findElement(fieldName).isEnabled();
        driver.findElement(fieldName).clear();
    }

    /**
     * Метод записывает в поле "Имя" переданный параметр
     *
     * @param newName новое значение для заполнения поля
     */
    @Step("Заполняем поле \"Имя\"")
    public void setName(String newName) {
        checkAndClearField(FIELD_NAME);
        driver.findElement(FIELD_NAME).sendKeys(newName);
    }

    /**
     * Метод записывает в поле "Email" переданный параметр
     *
     * @param newEmail новое значение для заполнения поля
     */
    @Step("Заполняем поле \"Email\"")
    public void setEmail(String newEmail) {
        checkAndClearField(FIELD_EMAIL);
        driver.findElement(FIELD_EMAIL).sendKeys(newEmail);
    }

    /**
     * Метод записывает в поле "Пароль" переданный параметр
     *
     * @param newPassword новое значение для заполнения поля
     */
    @Step("Заполняем поле \"Пароль\"")
    public void setPassword(String newPassword) {
        checkAndClearField(FIELD_PASSWORD);
        driver.findElement(FIELD_PASSWORD).sendKeys(newPassword);
    }

    /**
     * Метод нажимает кнопку "Зарегистрироваться"
     */
    @Step("Нажимаем кнопку \"Зарегистрироваться\"")
    public void clickRegistrationButton() {
        driver.findElement(BUTTON_REGISTRATION).click();
    }

    /**
     * Метод выполняет регистрацию нового пользователя
     *
     * @param newName     новое значение для заполнения поля "Имя"
     * @param newEmail    новое значение для заполнения поля "Email"
     * @param newPassword новое значение для заполнения поля "Пароль"
     */
    @Step("Выполняем регистрацию нового пользователя")
    public void registerUser(String newName, String newEmail, String newPassword) {
        setName(newName);
        setEmail(newEmail);
        setPassword(newPassword);
        clickRegistrationButton();
    }
}
