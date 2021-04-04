package tests.iOS;

import lib.iOSCoreTestCase;
import org.junit.Test;
import ui.WelcomePageObject;

public class GetStartedTest extends iOSCoreTestCase {
    @Test
    public void testPassThroughWelcome() {

        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);

        welcomePageObject.waitForLearnMoreLink();

    }
}
