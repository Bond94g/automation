package ui.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUI;

public class AndroidNavigationUi extends NavigationUI {
    static {
        MY_LIST_LINK = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
    }

    public AndroidNavigationUi(RemoteWebDriver driver) {
        super(driver);
    }
}
