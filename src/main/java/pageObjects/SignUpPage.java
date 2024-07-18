package pageObjects;

import com.microsoft.playwright.Locator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends HomePage {

    private final Locator closeButton = page. locator("//div[@id='signInModal']//div[@class='modal-footer']//button[1]");
    private final Locator passwordInput = page. locator("//input[@id='sign-password']");
    private final Locator signUpButton = page. locator("//div[@id='signInModal']//div[@class='modal-footer']//button[2]");
    private final Locator signUpModalCloseButton = page. locator( "//h5[@id='signInModalLabel']/following-sibling::button");
    private final Locator signUpModalTitle = page. locator("//h5[@id='signInModalLabel']");
    private final Locator usernameInput = page. locator("//input[@id='sign-username']");

    public String getSignUpModalTitle() {
        return signUpModalTitle.innerText();
    }

    public SignUpPage clickSignUpModalCloseButton() {
        signUpModalCloseButton.click();
        return this;
    }

    public SignUpPage clickOnSignUpButton() {
        signUpButton.click();
        return this;
    }

    public SignUpPage fillUsername(String username) {
        usernameInput.fill(username);
        return this;
    }

    public SignUpPage fillPassword(String password) {
        passwordInput.fill(password);
        return this;
    }
}
