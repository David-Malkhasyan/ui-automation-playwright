package pageObjects;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import driverManager.PlaywrightFactory;


public class BasePage {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    public BasePage() {
        browser = PlaywrightFactory.getBrowser();
        browserContext = PlaywrightFactory.getBrowserContext();
        page = PlaywrightFactory.getPage();
    }


}
