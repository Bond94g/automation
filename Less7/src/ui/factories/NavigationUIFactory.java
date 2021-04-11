package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import ui.NavigationUI;
import ui.android.AndroidNavigationUi;
import ui.ios.iOSNavigationUI;

public class NavigationUIFactory {

    public static NavigationUI get (AppiumDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidNavigationUi(driver);
        }
        else {
            return new iOSNavigationUI(driver);
        }
    }
}
