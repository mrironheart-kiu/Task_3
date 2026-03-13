import basetest.RedirectTestBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static constant.ConstantButtonTitle.*;
import static constant.ConstantStoryTitle.TITLE_REDIRECT;

public class RedirectTest extends RedirectTestBaseTest {

    @Test
    @Story(TITLE_REDIRECT)
    @DisplayName("Успешнный переход в личный кабинет по кнопке \"" + BUTTON_TITLE_PROFILE + "\" в хедере сайта")
    @Description("Нажимаем на кнопку \"" + BUTTON_TITLE_PROFILE + "\"")
    void redirectFromMainPageToProfilePageViaHeaderPageAccountButtonSuccessTest() {
        goToProfilePageFromMainPage();

        checkRedirectToProfilePage();
    }

    @Test
    @Story(TITLE_REDIRECT)
    @DisplayName("Успешнный переход из личного кабинета в конструктор по кнопке \"" +
            BUTTON_TITLE_BUILDER + "\" в хедере сайта")
    @Description("Нажимаем на кнопку \"" + BUTTON_TITLE_BUILDER + "\"")
    void redirectFromAccountPageToMainPageViaHeaderPageBuilderButtonSuccessTest() {
        goToMainPageFromProfilePageViaBuilderButton();

        checkRedirectToMainPage();
    }

    @Test
    @Story(TITLE_REDIRECT)
    @DisplayName("Успешнный переход из личного кабинета в конструктор по клику на логотип в хедере сайта")
    @Description("Нажимаем на логотип")
    void redirectFromAccountPageToMainPageViaHeaderPageLogoSuccessTest() {
        goToMainPageFromProfilePageViaLogo();

        checkRedirectToMainPage();
    }

    @Test
    @Story(TITLE_REDIRECT)
    @DisplayName("Успешнный переход из личного кабинета на страницу авторизации по кнопке \"" + BUTTON_TITLE_LOGOUT + "\"")
    @Description("Нажимаем на кнопку \"" + BUTTON_TITLE_LOGOUT + "\"")
    void redirectFromAccountPageToMainPageViaLogoutButtonSuccessTest() {
        logOut();

        checkRedirectToLoginPage();
    }

    @Test
    @Story(TITLE_REDIRECT)
    @DisplayName("Успешнный переход в конструкторе на вкладку \"" + BUTTON_TITLE_INGREDIENT_BUN + "\"")
    @Description("Нажимаем на вкладку \"" + BUTTON_TITLE_INGREDIENT_BUN + "\"")
    void redirectToBunInBuilderSuccessTest() {
        switchBuilderFilterToBun();

        checkBuilderFilterBun();
    }

    @Test
    @Story(TITLE_REDIRECT)
    @DisplayName("Успешнный переход в конструкторе на вкладку \"" + BUTTON_TITLE_INGREDIENT_SAUCE + "\"")
    @Description("Нажимаем на вкладку \"" + BUTTON_TITLE_INGREDIENT_SAUCE + "\"")
    void redirectToSauceInBuilderSuccessTest() {
        switchBuilderFilterToSauce();

        checkBuilderFilterSauce();
    }

    @Test
    @Story(TITLE_REDIRECT)
    @DisplayName("Успешнный переход в конструкторе на вкладку \"" + BUTTON_TITLE_INGREDIENT_FILLING + "\"")
    @Description("Нажимаем на вкладку \"" + BUTTON_TITLE_INGREDIENT_FILLING + "\"")
    void redirectToFillingInBuilderSuccessTest() {
        switchBuilderFilterToFilling();

        checkBuilderFilterFilling();
    }
}
