package ui.ios;

import io.appium.java_client.AppiumDriver;
import ui.MyListPageObject;

public class iOSMyListsPageObject extends MyListPageObject {
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[@name = '{TITLE}']";
        CLOSE_WINDOW = "id:Close";
    }

    public iOSMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}
