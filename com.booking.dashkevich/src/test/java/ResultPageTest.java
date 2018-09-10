import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class ResultPageTest {

    static final int EXPECTED_MIN_RESULTS = 3;
    static final int EXPECTED_MIN_RESULTS_FIVE_STARS_CHECKED = 1;
    static final String CITY_TO_ENTER = "Минск";
    static final String HOME_PAGE_URL = "https://www.booking.com/";


    protected static WebDriver driver;
    protected ResultPage resultPage;
    protected HomePage homePage;


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void runInitials() {
        driver.get(HOME_PAGE_URL);
        homePage = new HomePage(driver);
        homePage.enterSearch(CITY_TO_ENTER);
        homePage.clickCheckin();
        homePage.clickNextFriday();
        homePage.clickNextSunday();
        resultPage = homePage.submit();
    }

    @Test // Shows that we can find minimum three hotels available to booking in nearest weekend.
    public void canFindMinResults() {

        Assert.assertTrue(new IntParser().parseFirstInt(resultPage.getTextResultHeader()) >= EXPECTED_MIN_RESULTS);

    }

    @Test // Shows that we can find minimum one five star hotel available to booking in nearest weekend.
    public void canFindMinFiveStarResults() throws InterruptedException {
        resultPage.clickFiveStarsCheckbox();
        Thread.sleep(4000);
        Assert.assertTrue(new IntParser().parseFirstInt(resultPage.getTextResultHeader()) >= EXPECTED_MIN_RESULTS_FIVE_STARS_CHECKED);
    }

    @Test // Shows that  "by price and rating" button works and change results order.
    public void clickSortButtonChangeOrder() throws InterruptedException {

        List<String> beforeSortList = new ArrayList<String>();
        for (WebElement webElement : resultPage.getResults()) {
            beforeSortList.add(webElement.getText());
        }
        resultPage.clickSortButton();
        Thread.sleep(4000);
        List<String> afterSortList = new ArrayList<String>();
        for (WebElement webElement : resultPage.getResults()) {
            afterSortList.add(webElement.getText());
        }
        Assert.assertFalse(beforeSortList.equals(afterSortList));
    }

    @AfterMethod
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }


}
