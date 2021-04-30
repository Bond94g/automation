package ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject {
    private static final String
    LOGIN_BUTTON="xpath://body//div/a[text()='Log in']",
    LOGIN_INPUT="css:input[name='wpName']",
    PASSWORD_INPUT="css:input[name='wpPassword']",
    SUBMIT_BUTTON="css:button#wpLoginAttempt";

    public AuthorizationPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickAuthButton() throws InterruptedException {
        Thread.sleep(1000);
        this.waitForElementPresent(LOGIN_BUTTON, "Cannot find auth button", 40);
        this.waitForElementAndClick(LOGIN_BUTTON, "Cannot find and click auth button", 40);
    }

    public void enterLoginData(String login, String password) throws InterruptedException {
        Thread.sleep(1000);
        this.waitForElementAndSendKeys(LOGIN_INPUT, login, "Cannot find and put a login to the login input", 45);
        this.waitForElementAndSendKeys(PASSWORD_INPUT, password, "Cannot find and put a login to the login input", 45);
    }

    public void submitForm() {
        System.out.println(555);
        this.waitForElementAndClick(SUBMIT_BUTTON, "Cannot find and click submit auth button", 5);
    }


}
