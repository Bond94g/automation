package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.MyListPageObject;
import ui.android.AndroidMyListsPageObject;
import ui.ios.iOSMyListsPageObject;
import ui.mobile_web.MWyListsPageObject;

public class MyListsPageObjectFactory {
    public static MyListPageObject get (RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidMyListsPageObject(driver);
        }
        else if (Platform.getInstance().isIOS()) {
            return new iOSMyListsPageObject(driver);
        }
        else {
            return new MWyListsPageObject(driver);
        }
    }
}
