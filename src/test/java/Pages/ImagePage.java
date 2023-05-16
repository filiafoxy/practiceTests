package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;

public class ImagePage extends AbstractPage{

    @FindBy(xpath = "//*[contains(@type, 'submit')]")
    private Button searchButton;

    @FindBy(css = ".serp-item__preview")
    private List<HtmlElement> searchResults;

    @FindBy(css = ".PopularRequestList-Shadow")
    private List<HtmlElement> popularRequestResults;

    @FindBy(css =".mini-suggest__input")
    private TextInput searchField;

    public ImagePage(WebDriver driver) {
        super(driver);
    }
    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickSearchInput() {
        searchField.click();
    }

    public void typeTextToSearchField(String text) {
        searchField.sendKeys(text);
    }

    public int getNumberOfSearchResults() {
        return searchResults.size();
    }
    public int getNumberOfPopularSearchResults() {
        return popularRequestResults.size();
    }
}
