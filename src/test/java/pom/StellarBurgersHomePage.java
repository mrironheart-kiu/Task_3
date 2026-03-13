package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.WaitUtils;

import static constant.ConstantButtonTitle.BUTTON_TITLE_LOGIN;
import static constant.ConstantUrl.URL_LOGIN_PAGE;

/**
 * Класс главной страницы сайта Stellar Burgers
 */
public class StellarBurgersHomePage extends BasePage {

    public StellarBurgersHomePage(WebDriver driver) {
        super(driver);
    }

    // Кнопка "Войти в аккаунт"
    private final By BUTTON_LOGIN = By.xpath(String.format("//button[text()='%s']", BUTTON_TITLE_LOGIN));

    /**
     * Метод нажимает кнопку "Войти в аккаунт"
     */
    @Step("Нажимаем кнопку \"" + BUTTON_TITLE_LOGIN + "\"")
    public void clickLoginButton() {
        clickButton(BUTTON_LOGIN);
        WaitUtils.waitUrlToBe(driver, URL_LOGIN_PAGE);
    }
}
