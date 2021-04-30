package ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.ArticlePageObject;

public class MWArticlePageObject extends ArticlePageObject
{
    static {
        TITLE = "css:#content h1";
        TITLE1 = "id:Appium";
        FOOTER_ELEMENT = "css:footer";

        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions  li#page-actions-watch a";
        OPTIONS_REMOVE_FROM__MY_LIST_BUTTON="css:#page-actions a#ca-watch.watched";
        CLOSE_ARTICLE_TITLE = "id:Back";
        CLOSE_ARTICLE_TITLE1 = "id:Cancel";
        SAVE_TEST = "id:org.wikipedia:id/item_title";
        TEXT = "id:Appium";
    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}


