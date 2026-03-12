package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constant.ConstantButtonTitle.BUTTON_TITLE_ACCOUNT;

/**
 * Класс хедера страниц сайта Stellar Burgers
 */

public class StellarBurgersHeaderPage extends BasePage {

    public StellarBurgersHeaderPage(WebDriver driver) {
        super(driver);
    }

    // Кнопка "Личный кабинет"
    private final By BUTTON_ACCOUNT = By.xpath("//a[@href='/account']");

    /**
     * Метод нажимает кнопку "Личный кабинет"
     */
    @Step("Нажимаем кнопку \"" + BUTTON_TITLE_ACCOUNT + "\"")
    public void clickAccountButton() {
        clickButton(BUTTON_ACCOUNT);
    }
}
