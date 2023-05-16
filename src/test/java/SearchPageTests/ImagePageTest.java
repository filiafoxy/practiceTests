package SearchPageTests;

import BaseTest.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImagePageTest extends BaseTest {
    @Test
    public void popularImageSearchTest() {
        openImagePage();
        Assertions.assertEquals(20, onImagePage().getNumberOfPopularSearchResults(),
                "В поиске по картинкам подгружается 20 элементов популярных картинок");
    }
    @Test
    public void imageSearchTest() {
        openImagePage();
        onImagePage().clickSearchInput();
        onImagePage().typeTextToSearchField("тест");
        onImagePage().clickSearchButton();
        Assertions.assertEquals(55, onImagePage().getNumberOfSearchResults(),
                "В поиске по картинкам подгружается 55 элементов");
    }
}
