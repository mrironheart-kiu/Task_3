package pom;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constant.ConstantButtonTitle.*;
import static constant.ConstantFieldTitle.*;

/**
 * Класс страницы авторизации сайта Stellar Burgers
 */
@Getter
public class StellarBurgersLoginPage extends BasePage {

    public StellarBurgersLoginPage(WebDriver driver) {
        super(driver);
    }

    // Поле "Email"
    private final By FIELD_EMAIL = By.xpath(String.format("//label[text()='%s']//../input[@name='name']", FIELD_TITLE_EMAIL));
    // Поле "Пароль"
    private final By FIELD_PASSWORD = By.xpath("//input[@type='password']");
    // Кнопка "Войти"
    private final By BUTTON_LOGIN = By.xpath(String.format("//button[contains(text(),'%s')]", BUTTON_TITLE_LOGIN_SHORT));

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
     * Метод нажимает кнопку "Войти"
     */
    @Step("Нажимаем кнопку \"" + BUTTON_TITLE_LOGIN_SHORT + "\"")
    public void clickLoginButton() {
        clickButton(BUTTON_LOGIN);
    }

    @Step("Выполняем авторизацию пользователя")
    public void loginUser(String newEmail, String newPassword) {
        setEmail(newEmail);
        setPassword(newPassword);
        clickLoginButton();
    }
}
