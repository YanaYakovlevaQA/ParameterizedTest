import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeEach
     void setUp() {
        open("https://www.litres.ru/");
        Configuration.browserSize = "1920x1980";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 20000;
        Configuration.holdBrowserOpen = true;
    }
}
