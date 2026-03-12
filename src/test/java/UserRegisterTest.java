import basetest.UserRegisterBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static constant.ConstantStoryTitle.TITLE_USER_REGISTER;

public class UserRegisterTest extends UserRegisterBaseTest {

    @Test
    @Story(TITLE_USER_REGISTER)
    @DisplayName("Успешная регистрация нового пользователя")
    @Description("Регистрируем нового пользователя")
    void registerSuccessTest() {
        registerUser();

        checkRegisterComplete();
    }

    @Test
    @Story(TITLE_USER_REGISTER)
    @DisplayName("Невозможно зарегистрировать нового пользователя с паролем короче 6 символов")
    @Description("Выполняем попытку регистрации нового пользователя")
    void registerShortPasswordTest() {
        registerUserShortPassword();

        checkShortPasswordError();
    }
}
