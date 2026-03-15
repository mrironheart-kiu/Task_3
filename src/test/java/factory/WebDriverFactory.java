package factory;

import constant.ConstantBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    public WebDriver getWebDriver(ConstantBrowser browserName){
        switch (browserName){
            case CHROME:
                return new ChromeDriver();
            case YANDEX:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/yandexdriver.exe");
                ChromeOptions options = new ChromeOptions();
                // Указан локальный путь до Яндекс Браузера. Как сделать универсальнее не знаю
                options.setBinary("C:\\Users\\VANO\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                return new ChromeDriver(options);
            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }
}
