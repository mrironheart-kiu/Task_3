package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.WaitUtils;

import static constant.ConstantButtonTitle.BUTTON_TITLE_LOGOUT;
import static constant.ConstantFieldTitle.FIELD_TITLE_LOGIN;

public class StellarBurgersProfilePage extends BasePage {

    public StellarBurgersProfilePage(WebDriver driver) {
        super(driver);
    }

    // Поле "Email"
    private final By FIELD_EMAIL = By.xpath(String.format("//label[text()='%s']//../input[@name='name']", FIELD_TITLE_LOGIN));
    // Кнопка "Выход"
    private final By BUTTON_LOGOUT = By.xpath(String.format("//button[text()='%s']", BUTTON_TITLE_LOGOUT));

    /**
     * @return метод возвращает значение из поля "Email"
     */
    public String getEmailFieldValue() {
        return getAttributeValue(FIELD_EMAIL, "value");
    }

    /**
     * Метод нажимает кнопку "Выход"
     */
    @Step("Нажимаем кнопку \"" + BUTTON_TITLE_LOGOUT + "\"")
    public void clickLogoutButton() {
        WaitUtils.waitToBeClickable(driver, BUTTON_LOGOUT);
        clickButton(BUTTON_LOGOUT);
    }
}
