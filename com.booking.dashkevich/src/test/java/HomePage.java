import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends PageObject {


    @FindBy(xpath = "//*[@id=\"sort_by\"]/ul/li[2]/a") 
    private WebElement resultsHeader;

    @FindBy(id = "ss")
    private WebElement city;

    @FindBy(css = "div[data-mode=\"checkin\"]")
    private WebElement checkinDate;

    @FindBy(css = "div[data-mode=\"checkout\"]")
    private WebElement checkoutDate;

    @FindBy(css = "td[data-id=\"1536883200000\"]")
    private WebElement nextFriday;

    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div[3]/div/div/div[1]/table/tbody/tr[3]/td[7]/span")
    private WebElement nextSunday;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement submitButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void enterSearch(String city) {
        this.city.clear();
        this.city.sendKeys(city);
    }

    public void clickCheckin() {
        checkinDate.click();
    }

    public void clickCheckout() {
        checkoutDate.click();
    }

    public void clickNextFriday() {
        nextFriday.click();
    }

    public void clickNextSunday() {
        nextSunday.click();
    }

    public ResultPage submit() {
        submitButton.click();
        return new ResultPage(driver);
    }

    public void clickResultsHeader() {
        resultsHeader.click();
    }

}
