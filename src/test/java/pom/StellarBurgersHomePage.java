package pom;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.WaitUtils;

import static constant.ConstantButtonTitle.*;
import static constant.ConstantUrl.URL_LOGIN_PAGE;

/**
 * Класс главной страницы сайта Stellar Burgers
 */
@Getter
public class StellarBurgersHomePage extends BasePage {

    public StellarBurgersHomePage(WebDriver driver) {
        super(driver);
    }

    // Кнопка "Войти в аккаунт"
    private final By BUTTON_LOGIN = By.xpath(String.format("//button[text()='%s']", BUTTON_TITLE_LOGIN));
    // Кнопка "Оформить заказ"
    private final By BUTTON_ORDER = By.xpath(String.format("//button[text()='%s']", BUTTON_TITLE_ORDER));
    // Кнопка "Булки" в конструкторе
    private final By BUTTON_BUILDER_BUN = By.xpath(String.format("//span[text()='%s']", BUTTON_TITLE_INGREDIENT_BUN));
    // Кнопка "Соусы" в конструкторе
    private final By BUTTON_BUILDER_SAUCE =
            By.xpath(String.format("//span[text()='%s']", BUTTON_TITLE_INGREDIENT_SAUCE));
    // Кнопка "Начинки" в конструкторе
    private final By BUTTON_BUILDER_FILLING =
            By.xpath(String.format("//span[text()='%s']", BUTTON_TITLE_INGREDIENT_FILLING));
    // Заголовок "Булки" в конструкторе
    private final By TITLE_BUILDER_BUN = By.xpath(String.format("//h2[text()='%s']", BUTTON_TITLE_INGREDIENT_BUN));
    // Заголовок "Соусы" в конструкторе
    private final By TITLE_BUILDER_SAUCE =
            By.xpath(String.format("//h2[text()='%s']", BUTTON_TITLE_INGREDIENT_SAUCE));
    // Заголовок "Начинки" в конструкторе
    private final By TITLE_BUILDER_FILLING =
            By.xpath(String.format("//h2[text()='%s']", BUTTON_TITLE_INGREDIENT_FILLING));

    /**
     * Метод нажимает кнопку "Войти в аккаунт"
     */
    @Step("Нажимаем кнопку \"" + BUTTON_TITLE_LOGIN + "\"")
    public void clickLoginButton() {
        clickButton(BUTTON_LOGIN);
        WaitUtils.waitUrlToBe(driver, URL_LOGIN_PAGE);
    }

    /**
     * Метод нажимает кнопку "Булки" в конструкторе
     */
    @Step("Нажимаем кнопку \"" + BUTTON_TITLE_INGREDIENT_BUN + "\" в конструкторе")
    public void clickBuilderBunButton() {
        WaitUtils.waitToBeClickable(driver, BUTTON_BUILDER_BUN);
        clickButton(BUTTON_BUILDER_BUN);
    }

    /**
     * Метод нажимает кнопку "Соусы" в конструкторе
     */
    @Step("Нажимаем кнопку \"" + BUTTON_TITLE_INGREDIENT_SAUCE + "\" в конструкторе")
    public void clickBuilderSauceButton() {
        WaitUtils.waitToBeClickable(driver, BUTTON_BUILDER_SAUCE);
        clickButton(BUTTON_BUILDER_SAUCE);
    }

    /**
     * Метод нажимает кнопку "Начинки" в конструкторе
     */
    @Step("Нажимаем кнопку \"" + BUTTON_TITLE_INGREDIENT_FILLING + "\" в конструкторе")
    public void clickBuilderFillingButton() {
        WaitUtils.waitToBeClickable(driver, BUTTON_BUILDER_FILLING);
        clickButton(BUTTON_BUILDER_FILLING);
    }
}
