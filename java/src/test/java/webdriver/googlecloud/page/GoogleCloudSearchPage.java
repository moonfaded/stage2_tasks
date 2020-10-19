package webdriver.googlecloud.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudSearchPage extends AbstractPage{

  public GoogleCloudSearchPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//b[contains(text(),'Google Cloud Platform Pricing Calculator')]")
  private WebElement platformCalculatorSearchResult;

  public GoogleCloudPlatformCalculatorPage openGoogleCloudPlatformCalculator() {
    CustomConditions.clickOnVisibleElement(platformCalculatorSearchResult, driver);
    return new GoogleCloudPlatformCalculatorPage(driver);
  }
}
