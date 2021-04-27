package ui.ios;

import io.appium.java_client.AppiumDriver;
import ui.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "id:Search Wikipedia";
        SEARCH_CANCEL_BUTTON = "xpath://XCUIElementTypeButton[@name='Cancel']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "id:{SUBSTRING}";
        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeCell";
        SEARCH_EMPTY_RESULT_ELEMENT = "id:No results found";
        SEARCH_RESULT_BY_SUBSTRING_TPL1 = "xpath://XCUIElementTypeStaticText[@name='{SUBSTRING}' or @name='{SUBSTRING1}']";
    }

    public iOSSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
}
