package webdriver.googlecloud.test;

import org.testng.Assert;
import org.testng.annotations.*;
import webdriver.googlecloud.page.GoogleCloudHomePage;
import webdriver.googlecloud.page.TenMinuteMailPage;

public class EstimateCalculatorAndMailTest extends AbstractTest {

  private final String EXPECTED_PLATFORM_COST = "USD 1,082.77";

  @Test
  public void estimatedCostEqualsEmailedCost() {
    GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver)
                                                  .openPage()
                                                  .searchForGoogleCloudPlatformCalculator()
                                                  .openGoogleCloudPlatformCalculator()
                                                  .setPlatformProperties()
                                                  .addPlatformToEstimate()
                                                  .openTenMinuteMailPageInNewTab()
                                                  .copyGeneratedTenMinuteMail()
                                                  .switchToCalculatorTab()
                                                  .clickEmailEstimateButton()
                                                  .sendEstimateEmail()
                                                  .switchToTenMinuteMailTab()
                                                  .openMessageWithEmailedEstimate();

    Assert.assertEquals(EXPECTED_PLATFORM_COST, TenMinuteMailPage.getPlatformCostFromEmail());
  }
}
