package webdriver.pastebin.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.pastebin.page.NewPastebinPage;
import webdriver.pastebin.page.PastebinHomePage;

public class ICanWinTest {
  private final String PASTE_NAME = "helloweb";
  private final String CODE = "Hello from WebDriver";
  private WebDriver driver;

  @BeforeTest
  public void setupBrowser() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @Test
  public void createNewPasteHelloWeb() {
    NewPastebinPage newPage = new PastebinHomePage(driver)
                                  .openPage()
                                  .addCode(CODE)
                                  .selectPasteExpirationAsTenMinutes()
                                  .addPasteNameOrTitle(PASTE_NAME)
                                  .createNewPaste();
  }

  @AfterTest
  public void closeBrowser() {
    driver.quit();
    driver = null;
  }
}

