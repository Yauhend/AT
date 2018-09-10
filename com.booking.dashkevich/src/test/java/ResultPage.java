import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultPage extends PageObject {


    @FindBy(xpath = "//*[@id=\"right\"]/div[3]/div/div/div/h1")
    private WebElement resultsHeader;

    @FindBy(xpath = "//*[@id=\"filter_class\"]/div[2]/a[4]/div/span")
    private WebElement fiveStarsCheckbox;

    @FindBy(className = "sr-hotel__name")
    private List<WebElement> results;

    @FindBy(className = "sort_review_score_and_price")
    private WebElement sortButton;


    public ResultPage(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> getResults() {
        return results;
    }

    public void clickFiveStarsCheckbox() {
        fiveStarsCheckbox.click();
    }

    public String getTextResultHeader() {
        return resultsHeader.getText();
    }

    public void clickSortButton() {
        sortButton.click();
    }
}
