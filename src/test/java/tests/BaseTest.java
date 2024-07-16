package tests;


import com.microsoft.playwright.Browser;
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
    protected Browser browser = PlaywrightFactory.getBrowser();
    protected Logger logger;
    protected SoftAssert softAssert;

    @BeforeMethod
    public void setup() {
        logger = LogManager.getLogger(this);
        logger.info("WebDriver for creation" + Configurations.BROWSER + "browser started");
        PlaywrightFactory.initBrowser();
        logger.info("WebDriver for creation" + Configurations.BROWSER + "browser created");
        softAssert = new SoftAssert();
        logger.info("Test data deserialization");
        generateTestData();
        logger.info("Test data is deserialized");
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
