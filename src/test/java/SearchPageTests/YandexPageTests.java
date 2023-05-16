package SearchPageTests;

import BaseTest.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class YandexPageTests extends BaseTest {

    @Test
    public void yandexEmptySearchTest() {
        openYandexPage();
        Assertions.assertEquals(true, onYandexPage().getEmptyError(),
                "На странице должно быть сообщение \"Задан пустой поисковый запрос\"");
    }


    @Test
    public void yandexSearchTest() {
        openYandexPage();
        onYandexPage().typeTextToSearchField("selenium is");
        onYandexPage().clickSearchButton();
        Assertions.assertNotEquals(15, onYandexPage().getNumberOfSearchResults(),
                "В поиске не должно быть более 15 результатов");
    }
}
