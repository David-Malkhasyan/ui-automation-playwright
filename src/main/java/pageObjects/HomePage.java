package pageObjects;

import com.microsoft.playwright.Locator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private final Locator aboutUsButton = page. locator("//div[@id='navbarExample']//li[3]");
    private final Locator cartButton = page. locator("//div[@id='navbarExample']//li[4]");
    private final Locator contactButton = page. locator("//div[@id='navbarExample']//li[2]");
    private final Locator homeButton = page. locator("//div[@id='navbarExample']//li[1]");
    private final Locator logInButton = page. locator("//div[@id='navbarExample']//li[5]");
    private final Locator logOutButton = page. locator("//div[@id='navbarExample']//li[6]");
    private final Locator signUpButton = page. locator("//div[@id='navbarExample']//li[8]");
    private final Locator usernameTitle = page. locator("//div[@id='navbarExample']//li[7]");

    public HomePage clickOnHomeButton() {
        homeButton.click();
        return this;
    }

    public HomePage clickOnContactButton() {
        homeButton.click();
        return this;
    }

    public HomePage clickOnAboutUsButton() {
        aboutUsButton.click();
        return this;
    }

    public HomePage clickOnCartButton() {
        cartButton.click();
        return this;
    }

    public LoginPage clickOnLogInButton() {
        logInButton.click();
        return new LoginPage();
    }

    public SignUpPage clickOnSignUpButton() {
        signUpButton.click();
        return new SignUpPage();
    }

    public HomePage clickOnLogOutButton() {
        logOutButton.click();
        return this;
    }

    public String getUsernameTitle() {
        return usernameTitle.innerText();
    }
}
