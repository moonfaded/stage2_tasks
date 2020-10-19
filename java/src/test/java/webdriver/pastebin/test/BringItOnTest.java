package webdriver.pastebin.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.pastebin.page.NewPastebinPage;
import webdriver.pastebin.page.PastebinHomePage;

public class BringItOnTest {
  private final String PASTE_NAME = "how to gain dominance among developers";
  private final String CODE = "git config --global user.name  \"New Sheriff in Town\"\n"
                                  + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
                                  + "git push origin master --force";
  private WebDriver driver;
  private NewPastebinPage newPage;

  @BeforeTest
  public void setupBrowser() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();

    newPage = new PastebinHomePage(driver)
                  .openPage()
                  .addCode(CODE)
                  .selectSyntaxHighlightingAsBash()
                  .selectPasteExpirationAsTenMinutes()
                  .addPasteNameOrTitle(PASTE_NAME)
                  .createNewPaste();
  }

  @Test
  public void checkIfReceivedTitleMatchesPasteName() {
    Assert.assertEquals(newPage.getPasteName(), PASTE_NAME);
  }

  @Test
  public void checkIfSyntaxIsHighlighted() {
    Assert.assertTrue(newPage.hasBashButton());
  }

  @Test
  public void checkIfReceivedTextMatchesCode() {
    Assert.assertTrue(newPage.getHighlightedText().contains(CODE));
  }

  @AfterTest
  public void closeBrowser() {
    driver.quit();
    driver = null;
  }
}
