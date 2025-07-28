import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LitresListing extends TestBase {

//    @Test
//    void checkingTheListing () {
//        open("https://www.detmir.ru/");
//        $("li[role=\"menuitem\"][data-dy=\"magnifier\"] button.qr.ft span").click();
//    }



    @CsvSource(value = {
            "Наука, Результаты поиска «Наука»",
            "Философия, Результаты поиска «Философия»"
    })
    @ParameterizedTest(name = "Для поискового запроса {0} название листинга должно быть {1}")
    @Tag("WEB")
    void checkingTheListing (String searchQuery, String nameListing) {
        open("https://www.litres.ru/");
        $(".SearchForm-module__hMZOXa__input").setValue(searchQuery).pressEnter();
       $("#pageTitle").shouldHave(text(nameListing));
    }
}
