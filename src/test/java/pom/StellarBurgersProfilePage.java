package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constant.ConstantFieldTitle.FIELD_TITLE_LOGIN;

public class StellarBurgersProfilePage extends BasePage {

    public StellarBurgersProfilePage(WebDriver driver) {
        super(driver);
    }

    // Поле "Email"
    private final By FIELD_EMAIL = By.xpath("//label[text()='" + FIELD_TITLE_LOGIN + "']//../input[@name='name']");

    /**
     * @return метод возвращает значение из поля "Email"
     */
    public String getEmailFieldValue() {
        return getAttributeValue(FIELD_EMAIL, "value");
    }
}
