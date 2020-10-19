package webdriver.googlecloud.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class GoogleCloudPlatformCalculatorPage extends AbstractPage {

  public GoogleCloudPlatformCalculatorPage(WebDriver driver) {
    super(driver);
  }

  private final String NUMBER_OF_PLATFORM_INSTANCES = "4";

  @FindBy(xpath = "//*[@id='cloud-site']//iframe")
  private WebElement firstFrame;

  @FindBy(xpath = "//*[@id='myFrame']")
  private WebElement secondFrame;

  @FindBy(xpath = "//md-tab-item//div[text()='Compute Engine']")
  private WebElement computeEngineIcon;

  @FindBy(id = "input_61")
  private WebElement numberOfInstancesInput;

  @FindBy(id = "select_value_label_54")
  private WebElement operatingSystemField;

  @FindBy(id = "select_option_63")
  private WebElement freeOperatingSystemOrSoftwareOption;

  @FindBy(id = "select_value_label_55")
  private WebElement machineClassField;

  @FindBy(id = "select_option_76")
  private WebElement machineClassRegularOption;

  @FindBy(id = "select_value_label_57")
  private WebElement SeriesField;

  @FindBy(id = "select_option_186")
  private WebElement SeriesOption;

  @FindBy(id = "select_value_label_58")
  private WebElement machineTypeField;

  @FindBy(id = "select_option_358")
  private WebElement machineTypeOption;

  @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
  private WebElement addGpusCheckbox;

  @FindBy(id = "select_value_label_390")
  private WebElement numberOfGpusField;

  @FindBy(id = "select_option_397")
  private WebElement numberOfGpusSingleGpuOption;

  @FindBy(id = "select_value_label_391")
  private WebElement gpuTypeField;

  @FindBy(id = "select_option_404")
  private WebElement requiredGpuType;

  @FindBy(id = "select_value_label_352")
  private WebElement localSsdField;

  @FindBy(id = "select_option_379")
  private WebElement requiredLocalSsd;

  @FindBy(id = "select_value_label_59")
  private WebElement datacenterLocationField;

  @FindBy(id = "select_option_203")
  private WebElement requiredDatacenterLocation;

  @FindBy(id = "select_value_label_60")
  private WebElement committedUsageField;

  @FindBy(id = "select_option_94")
  private WebElement committedUsageOneYearOption;

  @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[contains(text(),'Add to Estimate')]")
  private WebElement addToEstimateButton;

  public GoogleCloudPlatformCalculatorPage setPlatformProperties() {
    CustomConditions.switchToInnerFrame(firstFrame, secondFrame, driver);
    chooseTheComputeEngineSection()
        .specifyNumberOfInstances(NUMBER_OF_PLATFORM_INSTANCES)
        .selectFreeOperatingSystem()
        .selectRegularVmClass()
        .selectSeries()
        .selectMachineType()
        .clickToAddGpusCheckbox()
        .addGpus()
        .selectLocalSsd()
        .selectDatacenterLocation()
        .selectCommittedUsage();
    return this;
  }

  public GoogleCloudPlatformCalculatorPage chooseTheComputeEngineSection() {
    CustomConditions.clickOnVisibleElement(computeEngineIcon, driver);
    return this;
  }

  public GoogleCloudPlatformCalculatorPage specifyNumberOfInstances(String numberOfInstances) {
    numberOfInstancesInput.click();
    numberOfInstancesInput.sendKeys(numberOfInstances);
    return this;
  }

  public GoogleCloudPlatformCalculatorPage selectFreeOperatingSystem() {
    CustomConditions.selectFromTheDropdownList(operatingSystemField, freeOperatingSystemOrSoftwareOption, driver);
    return this;
  }

  public GoogleCloudPlatformCalculatorPage selectRegularVmClass() {
    CustomConditions.selectFromTheDropdownList(machineClassField, machineClassRegularOption, driver);
    return this;
  }

  public GoogleCloudPlatformCalculatorPage selectSeries() {
    CustomConditions.selectFromTheDropdownList(SeriesField, SeriesOption, driver);
    return this;
  }

  public GoogleCloudPlatformCalculatorPage selectMachineType() {
    CustomConditions.selectFromTheDropdownList(machineTypeField, machineTypeOption, driver);
    return this;
  }

  public GoogleCloudPlatformCalculatorPage clickToAddGpusCheckbox() {
    CustomConditions.clickOnVisibleElement(addGpusCheckbox, driver);
    return this;
  }

  public GoogleCloudPlatformCalculatorPage addGpus() {
    CustomConditions.selectFromTheDropdownList(numberOfGpusField, numberOfGpusSingleGpuOption, driver);
    CustomConditions.selectFromTheDropdownList(gpuTypeField, requiredGpuType, driver);
    return this;
  }

  public GoogleCloudPlatformCalculatorPage selectLocalSsd() {
    CustomConditions.selectFromTheDropdownList(localSsdField, requiredLocalSsd, driver);
    return this;
  }

  public GoogleCloudPlatformCalculatorPage selectDatacenterLocation() {
    CustomConditions.selectFromTheDropdownList(datacenterLocationField, requiredDatacenterLocation, driver);
    return this;
  }

  public GoogleCloudPlatformCalculatorPage selectCommittedUsage() {
    CustomConditions.selectFromTheDropdownList(committedUsageField, committedUsageOneYearOption, driver);
    return this;
  }
  public GoogleCloudPlatformCalculatorPage addPlatformToEstimate() {
    CustomConditions.clickOnVisibleElement(addToEstimateButton, driver);
    return this;
  }

  public TenMinuteMailPage openTenMinuteMailPageInNewTab() {
    ((JavascriptExecutor) driver).executeScript("window.open()");
    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    return new TenMinuteMailPage(driver).openTenMinuteMail();
  }
}
