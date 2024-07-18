package pageObjects;

import com.microsoft.playwright.Locator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomePage {

    private final Locator closeButton = page. locator("/html/body/div[3]/div/div/div[1]/button");
    private final Locator logInModalCloseButton = page. locator("//h5[@id='logInModalLabel']/following-sibling::button");
    private final Locator logInModalTitle = page. locator("//h5[@id='logInModalLabel']");
    private final Locator passwordInput = page. locator("//input[@id='loginpassword']");
    private final Locator signInButton = page. locator("//div[@id='logInModal']//div[@class='modal-footer']//button[2]");
    private final Locator usernameInput = page. locator("//input[@id='loginusername']");

    public String getLogInModalTitle() {
        return logInModalTitle.innerText();
    }

    public LoginPage clickLogINModalCloseButton() {
        logInModalCloseButton.click();
        return this;
    }

    public HomePage clickOnSignInButton() {
        signInButton.click();
        return new HomePage();
    }

    public LoginPage fillUsername(String username) {
        usernameInput.fill(username);
        return this;
    }

    public LoginPage fillPassword(String password) {
        passwordInput.fill(password);
        return this;
    }
}
