import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LitresListing extends TestBase {


    @CsvSource(value = {
            "Наука, Результаты поиска «Наука»",
            "Философия, Результаты поиска «Философия»"
    })
    @ParameterizedTest(name = "Для поискового запроса {0} название листинга должно быть {1}")
    @Tag("WEB")
    void checkingTheListing (String searchQuery, String nameListing) {
        $(".SearchForm-module__hMZOXa__input").setValue(searchQuery).pressEnter();
       $("#pageTitle").shouldHave(text(nameListing));
    }

    @ValueSource(strings = {
            "Фантастика", "История"
    })
    @ParameterizedTest(name = "Для поискового запроса {0} должны отображаться найденные карточки товара")
    @Tag("WEB")
    @Tag("REGRESS")
    void searchResultsShouldNotBeEmpty(String searchQuery) {
        $(".SearchForm-module__hMZOXa__input").setValue(searchQuery).pressEnter();
        $$("[data-testid='art__wrapper']").shouldBe(sizeGreaterThan(0));
    }
}
