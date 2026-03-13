package pom;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constant.ConstantButtonTitle.*;
import static constant.ConstantErrorMessage.ERROR_MESSAGE_SHORT_PASSWORD;
import static constant.ConstantFieldTitle.*;

/**
 * Класс страницы регистрации сайта Stellar Burgers
 */
@Getter
public class StellarBurgersRegisterPage extends BasePage {

    public StellarBurgersRegisterPage(WebDriver driver) {
        super(driver);
    }

    // Поле "Имя"
    private final By FIELD_NAME = By.xpath(String.format("//label[text()='%s']//../input[@name='name']", FIELD_TITLE_NAME));
    // Поле "Email"
    private final By FIELD_EMAIL = By.xpath(String.format("//label[text()='%s']//../input[@name='name']", FIELD_TITLE_EMAIL));
    // Поле "Пароль"
    private final By FIELD_PASSWORD = By.xpath("//input[@type='password']");
    // Кнопка "Зарегистрироваться"
    private final By BUTTON_REGISTRATION = By.xpath(String.format("//button[text()='%s']", BUTTON_TITLE_REGISTER));
    // Кнопка "Войти"
    private final By BUTTON_LOGIN = By.xpath("//a[@href='/login']");
    // Ошибка "Некорректный пароль"
    private final By TEXT_ERROR_SHORT_PASSWORD =
            By.xpath(String.format("//p[contains(text(),'%s')]", ERROR_MESSAGE_SHORT_PASSWORD));

    /**
     * Метод записывает в поле "Имя" переданный параметр
     *
     * @param newName новое значение для заполнения поля
     */
    @Step("Заполняем поле \"" + FIELD_TITLE_NAME + "\"")
    public void setName(String newName) {
        setField(FIELD_NAME, newName);
    }

    /**
     * Метод записывает в поле "Email" переданный параметр
     *
     * @param newEmail новое значение для заполнения поля
     */
    @Step("Заполняем поле \"" + FIELD_TITLE_EMAIL + "\"")
    public void setEmail(String newEmail) {
        setField(FIELD_EMAIL, newEmail);
    }

    /**
     * Метод записывает в поле "Пароль" переданный параметр
     *
     * @param newPassword новое значение для заполнения поля
     */
    @Step("Заполняем поле \"" + FIELD_TITLE_PASSWORD + "\"")
    public void setPassword(String newPassword) {
        setField(FIELD_PASSWORD, newPassword);
    }

    /**
     * Метод нажимает кнопку "Зарегистрироваться"
     */
    @Step("Нажимаем кнопку \"" + BUTTON_TITLE_REGISTER + "\"")
    public void clickRegistrationButton() {
        clickButton(BUTTON_REGISTRATION);
    }

    /**
     * Метод нажимает кнопку "Войти"
     */
    @Step("Нажимаем кнопку \"" + BUTTON_TITLE_LOGIN_SHORT + "\"")
    public void clickLoginButton() {
        clickButton(BUTTON_LOGIN);
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

    /**
     * Метод выполняет регистрацию нового пользователя
     *
     * @param newName     новое значение для заполнения поля "Имя"
     * @param newEmail    новое значение для заполнения поля "Email"
     * @param newPassword новое значение для заполнения поля "Пароль"
     */
    @Step("Выполняем регистрацию нового пользователя")
    public void registerUserShortPassword(String newName, String newEmail, String newPassword) {
        setName(newName);
        setEmail(newEmail);
        setPassword(newPassword.substring(0, 5));
        clickRegistrationButton();
    }
}
