package webdriver.googlecloud.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class EstimateMailingPage extends AbstractPage {

  public EstimateMailingPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//*[@id='cloud-site']//iframe")
  private WebElement firstFrame;

  @FindBy(xpath = "//*[@id='myFrame']")
  private WebElement secondFrame;

  @FindBy(xpath = "//button[contains(text(),'Email Estimate')]")
  private WebElement emailEstimateButton;

  @FindBy(id = "input_475")
  private WebElement emailInput;

  @FindBy(xpath = "//button[contains(text(),'Send Email')]")
  private WebElement sendEmailButton;

  public EstimateMailingPage clickEmailEstimateButton() {
    CustomConditions.switchToInnerFrame(firstFrame, secondFrame, driver);
    CustomConditions.clickOnVisibleElement(emailEstimateButton, driver);
    new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(emailInput));
    return this;
  }

  public EstimateMailingPage sendEstimateEmail() {
    emailInput.sendKeys(Keys.chord(Keys.CONTROL, "v"));
    CustomConditions.clickOnClickableElement(sendEmailButton, driver);
    return this;
  }
  public TenMinuteMailPage switchToTenMinuteMailTab() {
    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    return new TenMinuteMailPage(driver);
  }
}
