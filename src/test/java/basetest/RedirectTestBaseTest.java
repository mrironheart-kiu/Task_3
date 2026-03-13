package basetest;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pom.*;
import testdata.TestDataUser;
import util.WaitUtils;

import static constant.ConstantButtonTitle.*;
import static constant.ConstantTestFailComment.DEFAULT_ERROR_COMMENT;
import static constant.ConstantUrl.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RedirectTestBaseTest extends BaseTest {
    private StellarBurgersLoginPage objLoginPage;
    private StellarBurgersHomePage objHomePage;
    private StellarBurgersHeaderPage objHeaderPage;
    private StellarBurgersProfilePage objProfilePage;

    @BeforeEach
    @Step("Подготавливаем тестовые данные перед запуском теста")
    void setUp() {
        super.setUp();
        objHomePage = new StellarBurgersHomePage(driver);
        objLoginPage = new StellarBurgersLoginPage(driver);
        objHeaderPage = new StellarBurgersHeaderPage(driver);
        objProfilePage = new StellarBurgersProfilePage(driver);
        testDataUser = new TestDataUser();
        testDataUser.createUser();
        testDataUser.registerUser();
        authorizeUser();
    }

    @AfterEach
    @Step("Удаляем тестовые данные после завершения теста")
    void tearDown() {
        super.tearDown();
        testDataUser.deleteUser(testDataUser.getUserTokenList());
    }

    /**
     * Вспомогательный метод для авторизации пользователя
     */
    public void authorizeUser() {
        driver.get(URL_HOME_PAGE);
        objHeaderPage.clickAccountButton();
        objLoginPage.loginUser(
                testDataUser.getUserRqBody().getEmail(),
                testDataUser.getUserRqBody().getPassword()
        );
    }

    /**
     * Вспомогательный метод для перехода в личный кабинет через кнопку "Личный кабинет" в хедере
     */
    public void goToProfilePageFromMainPage() {
        objHeaderPage.clickAccountButton();
    }

    /**
     * Вспомогательный метод для перехода из личного кабинета на главную через кнопку "Конструктор" в хедере
     */
    public void goToMainPageFromProfilePageViaBuilderButton() {
        objHeaderPage.clickBuilderButton();
    }

    /**
     * Вспомогательный метод для перехода из личного кабинета на главную через логотип в хедере
     */
    public void goToMainPageFromProfilePageViaLogo() {
        objHeaderPage.clickLogo();
    }

    /**
     * Вспомогательный метод для перехода из личного кабинета на страницу авторизации по кнопке "Выход"
     */
    public void logOut() {
        goToProfilePageFromMainPage();
        objProfilePage.clickLogoutButton();
    }

    /**
     * Вспомогательный метод для перехода к разделу "Булки" в конструкторе
     */
    public void switchBuilderFilterToBun() {
        switchBuilderFilterToSauce();
        objHomePage.clickBuilderBunButton();
    }

    /**
     * Вспомогательный метод для перехода к разделу "Соусы" в конструкторе
     */
    public void switchBuilderFilterToSauce() {
        objHomePage.clickBuilderSauceButton();
    }

    /**
     * Вспомогательный метод для перехода к разделу "Начинки" в конструкторе
     */
    public void switchBuilderFilterToFilling() {
        objHomePage.clickBuilderFillingButton();
    }

    @Step("Проверяем переход в " + BUTTON_TITLE_PROFILE)
    public void checkRedirectToProfilePage() {
        WaitUtils.waitUrlToBe(driver, URL_PROFILE_PAGE);
        Allure.step("Email пользователя в личном кабинете: " + objProfilePage.getEmailFieldValue());
        assertEquals(testDataUser.getUserRqBody().getEmail(), objProfilePage.getEmailFieldValue(), DEFAULT_ERROR_COMMENT);
    }

    @Step("Проверяем переход на главную страницу")
    public void checkRedirectToMainPage() {
        WaitUtils.waitUrlToBe(driver, URL_HOME_PAGE + "/");
        WaitUtils.waitToBeVisible(driver, objHomePage.getBUTTON_ORDER());
    }

    @Step("Проверяем переход на страницу авторизации")
    public void checkRedirectToLoginPage() {
        WaitUtils.waitUrlToBe(driver, URL_LOGIN_PAGE);
        WaitUtils.waitToBeVisible(driver, objLoginPage.getBUTTON_LOGIN());
    }

    @Step("Проверяем переход по фильтру \"" + BUTTON_TITLE_INGREDIENT_BUN + "\" в конструкторе")
    public void checkBuilderFilterBun() {
        WaitUtils.waitUrlToBe(driver, URL_HOME_PAGE + "/");
        WaitUtils.waitToBeVisible(driver, objHomePage.getTITLE_BUILDER_BUN());
    }

    @Step("Проверяем переход по фильтру \"" + BUTTON_TITLE_INGREDIENT_SAUCE + "\" в конструкторе")
    public void checkBuilderFilterSauce() {
        WaitUtils.waitUrlToBe(driver, URL_HOME_PAGE + "/");
        WaitUtils.waitToBeVisible(driver, objHomePage.getTITLE_BUILDER_SAUCE());
    }

    @Step("Проверяем переход по фильтру \"" + BUTTON_TITLE_INGREDIENT_FILLING + "\" в конструкторе")
    public void checkBuilderFilterFilling() {
        WaitUtils.waitUrlToBe(driver, URL_HOME_PAGE + "/");
        WaitUtils.waitToBeVisible(driver, objHomePage.getTITLE_BUILDER_FILLING());
    }
}
