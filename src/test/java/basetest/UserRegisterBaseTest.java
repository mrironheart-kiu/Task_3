package basetest;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pom.StellarBurgersRegisterPage;
import testdata.TestDataUser;
import util.WaitUtils;

import static constant.ConstantTestFailComment.DEFAULT_ERROR_COMMENT;
import static constant.ConstantUrl.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserRegisterBaseTest extends BaseTest {
    private StellarBurgersRegisterPage objRegisterPage;

    @BeforeEach
    @Step("Подготавливаем тестовые данные перед запуском теста")
    void setUp() {
        super.setUp();
        testDataUser = new TestDataUser();
        testDataUser.createUser();
    }

    @AfterEach
    @Step("Удаляем тестовые данные после завершения теста")
    void tearDown() {
        super.tearDown();
        testDataUser.deleteUser(testDataUser.getUserTokenList());
    }

    /**
     * Вспомогательный метод для регистрации пользователя на сайте
     */
    public void registerUser() {
        driver.get(URL_REGISTER_PAGE);
        objRegisterPage = new StellarBurgersRegisterPage(driver);
        objRegisterPage.registerUser(
                testDataUser.getUserRqBody().getName(),
                testDataUser.getUserRqBody().getEmail(),
                testDataUser.getUserRqBody().getPassword()
        );
    }

    /**
     * Вспомогательный метод для попытки регистрации пользователя на сайте со слишком коротким паролем
     */
    public void registerUserShortPassword() {
        driver.get(URL_REGISTER_PAGE);
        objRegisterPage = new StellarBurgersRegisterPage(driver);
        objRegisterPage.registerUserShortPassword(
                testDataUser.getUserRqBody().getName(),
                testDataUser.getUserRqBody().getEmail(),
                testDataUser.getUserRqBody().getPassword()
        );
    }

    @Step("Проверяем успешность регистрации пользователя")
    public void checkRegisterComplete() {
        WaitUtils.waitUrlToBe(driver, URL_LOGIN_PAGE);
        assertNotNull(testDataUser.getUserToken(), DEFAULT_ERROR_COMMENT);
    }

    @Step("Проверяем наличие ошибки при вводе пароля короче 6 символов")
    public void checkShortPasswordError() {
        WaitUtils.waitToBeVisible(driver, objRegisterPage.getTEXT_ERROR_SHORT_PASSWORD());
    }
}
