package ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject {
    protected static String
            MY_LIST_LINK,OPEN_NAVIGATION;

    public NavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

    public void openNavigaion()
    {
        if (Platform.getInstance().isMW()) {
            this.waitForElementAndClick(OPEN_NAVIGATION, "Cannot find and click open navigation button", 5);
        }
        else {
            System.out.println("Method openNavigaion() do nothing for platform"  + Platform.getInstance().getPlatformVar());
        }
    }
    public void clickMyList() throws InterruptedException {
        Thread.sleep(1000);
        if (Platform.getInstance().isMW())  {
            this.tryClickElementWithFewAttempts(
                    MY_LIST_LINK,
                    "Cannot find navigation button to My List",
                    10
            );
        }

        Thread.sleep(2000);
        this.waitForElementAndClick(
                MY_LIST_LINK,
                "Cannot find navigation button to My List",
                10
        );
        Thread.sleep(2000);
        System.out.println(7777777);
    }
}
