package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.util.List;

public class YandexPage extends AbstractPage{

    @FindBy(xpath = "//*[contains(@type, 'submit')]")
    private Button searchButton;

    @FindBy(xpath = "//*[contains(@class, 'serp-item') and not (contains(@class, 'card__narrow'))and not (contains(@class, 'serp-item_card-extra-shadow'))]")
    private List<HtmlElement> searchResults;

    @FindBy(css =".mini-suggest__input")
    private TextInput searchField;

    @FindBy(css = ".RequestMeta-Message")
    private TextBlock emptyRequestError;

    public YandexPage(WebDriver driver) {
        super(driver);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public int getNumberOfSearchResults() {
        return searchResults.size();
    }

    public void typeTextToSearchField(String text) {
        searchField.sendKeys(text);
    }

    public boolean getEmptyError() {
        return emptyRequestError.exists();
    }
}
