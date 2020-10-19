package webdriver.googlecloud.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends AbstractPage {

  private final String GOOGLE_CLOUD_HOME_PAGE_URL = "https://cloud.google.com/";
  private  final String PLATFORM_PRICING_CALCULATOR_SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";

  public GoogleCloudHomePage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//input[@name='q']")
  private WebElement searchInput;

  public GoogleCloudHomePage openPage() {
    driver.get(GOOGLE_CLOUD_HOME_PAGE_URL);
    return this;
  }

  public GoogleCloudSearchPage searchForGoogleCloudPlatformCalculator() {
    CustomConditions.clickOnVisibleElement(searchInput, driver);
    searchInput.sendKeys(PLATFORM_PRICING_CALCULATOR_SEARCH_QUERY + Keys.ENTER);
    return new GoogleCloudSearchPage(driver);
  }
}
