package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constant.ConstantButtonTitle.BUTTON_TITLE_LOGIN_SHORT;

/**
 * Класс страницы восстановления пароля сайта Stellar Burgers
 */
public class StellarBurgersForgotPasswordPage extends BasePage {

    public StellarBurgersForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    // Кнопка "Войти"
    private final By BUTTON_LOGIN = By.xpath("//a[@href='/login']");

    /**
     * Метод нажимает кнопку "Войти"
     */
    @Step("Нажимаем кнопку \"" + BUTTON_TITLE_LOGIN_SHORT + "\"")
    public void clickLoginButton() {
        clickButton(BUTTON_LOGIN);
    }
}
