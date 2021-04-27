package ui.ios;

import io.appium.java_client.AppiumDriver;
import ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "id:Java (programming language)";
        TITLE1 = "id:Appium";
        FOOTER_ELEMENT = "id:View article in browser";

        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_TITLE = "id:Back";
        CLOSE_ARTICLE_TITLE1 = "id:Cancel";
        SAVE_TEST = "id:org.wikipedia:id/item_title";
        TEXT = "id:Appium";
    }

    public iOSArticlePageObject(AppiumDriver driver) {
        super(driver);
    }


}
