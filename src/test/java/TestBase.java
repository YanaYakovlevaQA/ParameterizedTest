import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1980";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://www.detmir.ru/";
    }
}
