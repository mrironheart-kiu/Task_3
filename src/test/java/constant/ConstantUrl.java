package constant;

public class ConstantUrl {
    public static final String URL_MAIN_PAGE = "https://stellarburgers.education-services.ru";
    public static final String URL_REGISTER_PAGE = String.format("%s/register", URL_MAIN_PAGE);
    public static final String URL_LOGIN_PAGE = String.format("%s/login", URL_MAIN_PAGE);
    public static final String URL_ACCOUNT_PAGE = String.format("%s/account", URL_MAIN_PAGE);
    public static final String URL_PROFILE_PAGE = String.format("%s/profile", URL_ACCOUNT_PAGE);
    public static final String URL_FORGOT_PASSWORD_PAGE = String.format("%s/forgot-password", URL_MAIN_PAGE);

    public static final String URL_BASE_API_PATH = "/api";
    public static final String URL_BASE_API_AUTH_PATH = String.format("%s/auth", URL_BASE_API_PATH);
    public static final String URL_API_USER_REGISTER = String.format("%s/register", URL_BASE_API_AUTH_PATH);
    public static final String URL_API_USER_LOGIN = String.format("%s/login", URL_BASE_API_AUTH_PATH);
    public static final String URL_API_USER = String.format("%s/user", URL_BASE_API_AUTH_PATH);
}
