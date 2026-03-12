package basetest;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pom.*;
import testdata.TestDataUser;
import util.WaitUtils;

import static constant.ConstantTestFailComment.DEFAULT_ERROR_COMMENT;
import static constant.ConstantUrl.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserLoginBaseTest extends BaseTest {
    private StellarBurgersLoginPage objLoginPage;
    private StellarBurgersHomePage objMainPage;
    private StellarBurgersHeaderPage objHeaderPage;
    private StellarBurgersRegisterPage objRegisterPage;
    private StellarBurgersForgotPasswordPage objForgotPasswordPage;
    private StellarBurgersProfilePage objProfilePage;

    @BeforeEach
    @Step("Подготавливаем тестовые данные перед запуском теста")
    void setUp() {
        super.setUp();
        objMainPage = new StellarBurgersHomePage(driver);
        objLoginPage = new StellarBurgersLoginPage(driver);
        objHeaderPage = new StellarBurgersHeaderPage(driver);
        objProfilePage = new StellarBurgersProfilePage(driver);
        objRegisterPage = new StellarBurgersRegisterPage(driver);
        objForgotPasswordPage = new StellarBurgersForgotPasswordPage(driver);
        testDataUser = new TestDataUser();
        testDataUser.createUser();
        testDataUser.registerUser();
    }

    @AfterEach
    @Step("Удаляем тестовые данные после завершения теста")
    void tearDown() {
        super.tearDown();
        testDataUser.deleteUser(testDataUser.getUserTokenList());
    }

    /**
     * Вспомогательный метод для авторизации пользователя на сайте через кнопку "Войти в аккаунт" на главной странице
     */
    public void loginUserFromMainPageButton() {
        driver.get(URL_MAIN_PAGE);
        objMainPage.clickLoginButton();
        objLoginPage.loginUser(
                testDataUser.getUserRqBody().getEmail(),
                testDataUser.getUserRqBody().getPassword()
        );
    }

    /**
     * Вспомогательный метод для авторизации пользователя на сайте через кнопку "Личный кабинет" в хедере
     */
    public void loginUseFromHeaderPageButton() {
        driver.get(URL_MAIN_PAGE);
        objHeaderPage.clickAccountButton();
        objLoginPage.loginUser(
                testDataUser.getUserRqBody().getEmail(),
                testDataUser.getUserRqBody().getPassword()
        );
    }

    /**
     * Вспомогательный метод для авторизации пользователя на сайте через кнопку "Войти" в форме регистрации
     */
    public void loginUseFromRegisterPageButton() {
        driver.get(URL_REGISTER_PAGE);
        objRegisterPage.clickLoginButton();
        objLoginPage.loginUser(
                testDataUser.getUserRqBody().getEmail(),
                testDataUser.getUserRqBody().getPassword()
        );
    }

    /**
     * Вспомогательный метод для авторизации пользователя на сайте через кнопку "Войти" форме восстановления пароля
     */
    public void loginUseFromForgotPasswordPageButton() {
        driver.get(URL_FORGOT_PASSWORD_PAGE);
        objForgotPasswordPage.clickLoginButton();
        objLoginPage.loginUser(
                testDataUser.getUserRqBody().getEmail(),
                testDataUser.getUserRqBody().getPassword()
        );
    }

    @Step("Проверяем данные пользователя")
    public void checkUserProfile() {
        WaitUtils.waitUrlToBe(driver, URL_MAIN_PAGE + "/");
        objHeaderPage.clickAccountButton();
        WaitUtils.waitUrlToBe(driver, URL_PROFILE_PAGE);
        Allure.step("Email пользователя в личном кабинете: " + objProfilePage.getEmailFieldValue());
        assertEquals(testDataUser.getUserRqBody().getEmail(), objProfilePage.getEmailFieldValue(), DEFAULT_ERROR_COMMENT);
    }
}
