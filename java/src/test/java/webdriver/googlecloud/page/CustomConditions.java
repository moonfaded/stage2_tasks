package webdriver.googlecloud.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomConditions {

  public static void switchToInnerFrame(WebElement firstFrame, WebElement secondFrame, WebDriver driver) {
    switchToAvailableFrame(firstFrame, driver);
    switchToAvailableFrame(secondFrame, driver);
  }

  private static void switchToAvailableFrame(WebElement frame, WebDriver driver) {
    new WebDriverWait(driver, 15)
        .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
  }

  public static void clickOnVisibleElement(WebElement webElement, WebDriver driver) {
    new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(webElement)).click();
  }

  public static void clickOnClickableElement(WebElement webElement, WebDriver driver) {
    new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(webElement)).click();
  }

  public static void selectFromTheDropdownList(WebElement dropdownList, WebElement requiredOption, WebDriver driver) {
    clickOnVisibleElement(dropdownList, driver);
    clickOnVisibleElement(requiredOption, driver);
  }
}
