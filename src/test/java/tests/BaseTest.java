package tests;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import driverManager.PlaywrightFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import testData.expectedResultsData.MainTestDataExpected;
import testData.inputData.MainTestData;
import utils.Configurations;
import utils.JsonParser;


public class BaseTest {
    public static MainTestData mainTestData;
    public static MainTestDataExpected mainTestDataExpected;
    protected Logger logger;
    protected SoftAssert softAssert;
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    @BeforeMethod
    public void setup() {
        PlaywrightFactory.initBrowser();
        browser = PlaywrightFactory.getBrowser();
        browserContext = PlaywrightFactory.getBrowserContext();
        page = PlaywrightFactory.getPage();
        softAssert = new SoftAssert();
        generateTestData();
        page.navigate("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void closure(){
        browser.close();
    }


    protected void sleep(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void generateTestData() {
        mainTestData = JsonParser.deserializeJsonFile(MainTestData.mainTestDataJsonPath, MainTestData.class);
        mainTestDataExpected = JsonParser.deserializeJsonFile(MainTestDataExpected.mainTestDataJsonPath, MainTestDataExpected.class);
    }
}
