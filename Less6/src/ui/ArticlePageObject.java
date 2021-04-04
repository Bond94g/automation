package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {
    private static final String
            TITLE = "id:org.wikipedia:id/view_page_title_text",
            FOOTER_ELEMENT = "xpath://*[@text='View page in browser']",
            OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']",
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Add to reading list']",
            ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button",
            MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "xpath://*[@text='OK']",
            CLOSE_ARTICLE_TITLE = "xpath://android.widget.ImageButton[@content-desc='Navigate up']",
            SAVE_TEST = "id:org.wikipedia:id/item_title",
            TEXT = "xpath://*[@text='Appium']";


    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page", 15);

    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter() {
        this.swipeUpToFindElement(FOOTER_ELEMENT, "Cannot find the end of article", 20);
    }

    public void addArticleToMyList(String name_of_folder) {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find options to add article to reading list",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Got it' tip overlay",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of articles folder",
                5
        );


        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text info articles folder input",
                5
        );

        this.waitForElementAndClick(
              MY_LIST_OK_BUTTON,
                "Cannot press OK button",
                5
        );
    }

    public void addArticle1ToMyList() {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
               OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find options to add article to reading list",
                15
        );

        this.waitForElementAndClick(
               SAVE_TEST,
                "Cannot find button to open article options",
                15
        );


    }

    public void closeArticle() {
        this.waitForElementAndClick(
              CLOSE_ARTICLE_TITLE,
                "Cannot close article, cannot find X link",
                5
        );
    }

    public void saveTest() {
        this.waitForElementAndClick(
               OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );
    }

    public void waitForElement() {
        this.waitForElementPresent(TEXT, "Cannot find element", 5);
    }

    public void waitForElementAndClick() {
        this.waitForElementAndClick(TEXT, "Cannot find element", 5);
    }


}
