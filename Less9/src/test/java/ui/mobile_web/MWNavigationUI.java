package ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUI;

public class MWNavigationUI extends NavigationUI {
    static  {
        MY_LIST_LINK = "id:Saved";
    }

    public MWNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
