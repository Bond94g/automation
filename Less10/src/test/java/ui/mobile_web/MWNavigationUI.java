package ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUI;

public class MWNavigationUI extends NavigationUI {
    static  {
        MY_LIST_LINK = "xpath://a[@data-event-name='menu.unStar']/..";
        OPEN_NAVIGATION = "css:#mw-mf-main-menu-button";
    }

    public MWNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
