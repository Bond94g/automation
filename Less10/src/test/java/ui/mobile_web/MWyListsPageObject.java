package ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.MyListPageObject;

public class MWyListsPageObject extends MyListPageObject {
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class, 'watchlist')]//h3[contains(text(), '{TITLE}')]";
        REMOVE_FROM_SAVED_BUTTON = "xpath://ul[contains(@class, 'watchlist')]//h3[contains(text(), '{TITLE}')]/../../a[contains(@class, 'watched')]";
        CLOSE_WINDOW = "id:Close";
    }

    public MWyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
