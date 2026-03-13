import basetest.UserLoginBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static constant.ConstantButtonTitle.*;
import static constant.ConstantStoryTitle.TITLE_USER_LOGIN;

public class UserLoginTest extends UserLoginBaseTest {

    @Test
    @Story(TITLE_USER_LOGIN)
    @DisplayName("Успешная авторизация пользователя по кнопке \"" + BUTTON_TITLE_LOGIN + "\" на главной странице сайта")
    @Description("Авторизируемся пользователем")
    void loginFromMainPageLoginButtonSuccessTest() {
        loginUserFromMainPageButton();

        checkUserProfile();
    }

    @Test
    @Story(TITLE_USER_LOGIN)
    @DisplayName("Успешная авторизация пользователя по кнопке \"" + BUTTON_TITLE_ACCOUNT + "\" в хедере сайта")
    @Description("Авторизируемся пользователем")
    void loginFromHeaderPageAccountButtonSuccessTest() {
        loginUseFromHeaderPageButton();

        checkUserProfile();
    }

    @Test
    @Story(TITLE_USER_LOGIN)
    @DisplayName("Успешная авторизация пользователя по кнопке \"" + BUTTON_TITLE_LOGIN_SHORT + "\" на странице регистрации сайта")
    @Description("Авторизируемся пользователем")
    void loginFromRegisterPageLoginButtonSuccessTest() {
        loginUseFromRegisterPageButton();

        checkUserProfile();
    }

    @Test
    @Story(TITLE_USER_LOGIN)
    @DisplayName("Успешная авторизация пользователя по кнопке \"" + BUTTON_TITLE_LOGIN_SHORT + "\" на странице восстановления пароля сайта")
    @Description("Авторизируемся пользователем")
    void loginFromForgotPasswordPageLoginButtonSuccessTest() {
        loginUseFromForgotPasswordPageButton();

        checkUserProfile();
    }
}
