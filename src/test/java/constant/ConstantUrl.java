package constant;

public class ConstantUrl {
    public static final String URL_MAIN_PAGE = "https://stellarburgers.education-services.ru";
    public static final String URL_REGISTER_PAGE = URL_MAIN_PAGE + "/register";
    public static final String URL_LOGIN_PAGE = URL_MAIN_PAGE + "/login";

    public static final String URL_BASE_API_PATH = "/api";
    public static final String URL_BASE_API_AUTH_PATH = URL_BASE_API_PATH + "/auth";
    public static final String URL_API_USER_REGISTER = URL_BASE_API_AUTH_PATH + "/register";
    public static final String URL_USER_LOGIN = URL_BASE_API_AUTH_PATH + "/login";
    public static final String URL_API_USER = URL_BASE_API_AUTH_PATH + "/user";
}
