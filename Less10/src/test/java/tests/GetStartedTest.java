package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import org.junit.Test;
import ui.WelcomePageObject;

@Epic("Test for welcome ios")
public class GetStartedTest extends CoreTestCase {
    @Test
    @Features(value = {@Feature(value = "Welcome screen")})
    @DisplayName("Open welcome screen")
    @Description("We open welcome screen")
    @Step("Starting test testPassThroughWelcome")
    @Severity(value = SeverityLevel.MINOR)

    public void testPassThroughWelcome() {

        if (Platform.getInstance().isAndroid() || (Platform.getInstance().isMW())) {
            return;
        }

        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);

        welcomePageObject.waitForLearnMoreLink();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForNewWayToExploreText();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForAddOrEditPreferedLangText();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForLearnMoreAboutDataCollectedText();
        welcomePageObject.clickGetStartedButton();



    }
}
