package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constant.ConstantButtonTitle.*;

/**
 * Класс хедера страниц сайта Stellar Burgers
 */

public class StellarBurgersHeaderPage extends BasePage {

    public StellarBurgersHeaderPage(WebDriver driver) {
        super(driver);
    }

    // Кнопка "Личный кабинет"
    private final By BUTTON_ACCOUNT = By.xpath("//a[@href='/account']");
    // Кнопка "Личный кабинет"
    private final By BUTTON_BUILDER = By.xpath(String.format("//p[text()='%s']", BUTTON_TITLE_BUILDER));
    // Логотип "Stellar Burgers"
    private final By LOGO_MAIN = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");

    /**
     * Метод нажимает кнопку "Личный кабинет"
     */
    @Step("Нажимаем кнопку \"" + BUTTON_TITLE_PROFILE + "\"")
    public void clickAccountButton() {
        clickButton(BUTTON_ACCOUNT);
    }

    /**
     * Метод нажимает кнопку "Конструктор"
     */
    @Step("Нажимаем кнопку \"" + BUTTON_TITLE_BUILDER + "\"")
    public void clickBuilderButton() {
        clickButton(BUTTON_BUILDER);
    }

    /**
     * Метод нажимает логотип "Stellar Burgers"
     */
    @Step("Нажимаем на логотип")
    public void clickLogo() {
        clickButton(LOGO_MAIN);
    }
}
