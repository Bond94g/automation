package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUI;
import ui.android.AndroidNavigationUi;
import ui.ios.iOSNavigationUI;
import ui.mobile_web.MWNavigationUI;

public class NavigationUIFactory {

    public static NavigationUI get (RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidNavigationUi(driver);
        }
        else if (Platform.getInstance().isIOS()) {
            return new iOSNavigationUI(driver);
        }
        else {
            return new MWNavigationUI(driver);
        }
    }
}
