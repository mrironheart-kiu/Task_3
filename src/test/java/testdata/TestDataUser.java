package testdata;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.Getter;
import pojo.user.UserRqBody;
import pojo.user.UserRsBody;
import util.HttpManager;

import java.util.ArrayList;
import java.util.List;

import static constant.ConstantUrl.*;
import static constant.ConstantUrl.URL_API_USER_LOGIN;

/**
 * Класс для создания и удаления тестовых пользователей через API /register, /login и /user
 */
@Getter
public class TestDataUser extends TestDataProvider {
    protected HttpManager httpManager = new HttpManager(URL_MAIN_PAGE);
    protected Response response;
    protected UserRqBody userRqBody = new UserRqBody();
    protected String userToken;
    protected List<String> userTokenList = new ArrayList<>();

    /**
     * Метод создаёт пользователя со случайными данными
     */
    @Step("Создаём случайные учётные данные для тестового пользователя")
    public void createUser() {
        userRqBody = userRqBody.toBuilder()
                .email(TestDataProvider.getRandomEmail())
                .password(TestDataProvider.getRandomPassword())
                .name(TestDataProvider.getRandomName())
                .build();
        Allure.step("Учётные данные для тестового пользователя: " + userRqBody.toString());
    }

    /**
     * Метод регистрирует пользователя со случайными данными
     */
    public void registerUser() {
        response = httpManager.httpPost(URL_API_USER_REGISTER, userRqBody);
        saveUserToken();
    }

    /**
     * Метод авторизируется созданным случайным пользователем
     */
    public void loginUser() {
        response = httpManager.httpPost(URL_API_USER_LOGIN, userRqBody);
        saveUserToken();
    }

    /**
     * Метод удаялет пользователя по его токену
     */
    @Step("Удаляем учётные данные тестового пользователя")
    public void deleteUser(List<String> userTokenList) {
        if (!userTokenList.isEmpty()) {
            for (String userToken : userTokenList) {
                httpManager.httpDelete(URL_API_USER, userToken);
            }
        }
    }

    /**
     * Метод авторизируется созданным случайным пользователем возвращает токен
     *
     * @return String пользовательский токен
     */
    public String getUserToken() {
        loginUser();
        return response.body().as(UserRsBody.class).getAccessToken().split(" ")[1];
    }

    /**
     * Метод сохраняет токен пользователя
     */
    public void saveUserToken() {
        if (response.body().as(UserRsBody.class).getAccessToken() != null) {
            userToken = response.body().as(UserRsBody.class).getAccessToken().split(" ")[1];
            userTokenList.add(userToken);
        }
    }
}
