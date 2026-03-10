package testdata;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.Getter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pojo.user.UserRqBody;
import pojo.user.UserRsBody;
import util.HttpManager;

import java.util.ArrayList;
import java.util.List;

import static constant.ConstantUrl.*;

/**
 * Класс для создания и удаления тестовых пользователей через API /register и /user
 */
@Getter
public class TestDataUser {
    protected HttpManager httpManager;
    protected Response response;
    protected UserRqBody userRqBody = new UserRqBody();
    protected String userToken;
    protected final List<String> userTokenList = new ArrayList<>();

    @Step("Создаём тестовые данные перед выполнением теста")
    @BeforeEach
    void setUp() {
        httpManager = new HttpManager(URL_MAIN_PAGE);
        userRqBody = userRqBody.toBuilder()
                .email(TestDataProvider.getRandomEmail())
                .password(TestDataProvider.getRandomPassword())
                .name(TestDataProvider.getRandomName())
                .build();
        Allure.step("Устанавливаем URL по умолчанию: " + URL_MAIN_PAGE);
        Allure.step("Создаём тестового клиента: " + userRqBody.toString());
    }

    @Step("Очищаем тестовые данные после выполнения теста")
    @AfterEach
    void tearDown() {
        deleteUser(userTokenList);
    }

    /**
     * Метод создаёт пользователя со случайными данными
     */
    public void createUser() {
        response = httpManager.httpPost(URL_API_USER_REGISTER, userRqBody);

        if (response.body().as(UserRsBody.class).getAccessToken() != null) {
            userToken = response.body().as(UserRsBody.class).getAccessToken().split(" ")[1];
            userTokenList.add(userToken);
        }
    }

    /**
     * Метод создаёт пользователя с указанными данными
     */
    public void createUser(UserRqBody userRqBody) {
        response = httpManager.httpPost(URL_API_USER_REGISTER, userRqBody);
    }

    /**
     * Метод удаялет пользователя по его токену
     */
    public void deleteUser(List<String> userTokenList) {
        if (!userTokenList.isEmpty()) {
            for (String userToken : userTokenList) {
                httpManager.httpDelete(URL_API_USER, userToken);
            }
        }
    }
}
