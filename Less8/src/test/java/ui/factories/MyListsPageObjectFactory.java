package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import ui.MyListPageObject;
import ui.android.AndroidMyListsPageObject;
import ui.ios.iOSMyListsPageObject;

public class MyListsPageObjectFactory {
    public static MyListPageObject get (AppiumDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidMyListsPageObject(driver);
        }
        else {
            return new iOSMyListsPageObject(driver);
        }
    }
}
