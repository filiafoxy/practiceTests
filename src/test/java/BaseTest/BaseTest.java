package BaseTest;

import Pages.ImagePage;
import Pages.YandexPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected static WebDriver driver = null;

    private YandexPage yandexPage = null;
    private ImagePage imagePage = null;

    @BeforeEach
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    protected void openYandexPage() {
        driver.get("https://yandex.ru/search/?lr=44");
    }

    protected void openImagePage() {
        driver.get("https://yandex.ru/images/");
    }

    protected ImagePage onImagePage(){
        if (imagePage == null) {
            imagePage = new ImagePage(driver);
        }
        return imagePage;
    }
    protected YandexPage onYandexPage(){
        if (yandexPage == null) {
            yandexPage = new YandexPage(driver);
        }
        return yandexPage;
    }

    @AfterEach
    public void shutDown(){
        driver.quit();
        driver = null;
    }
}
