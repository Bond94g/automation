package ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {
    protected static String
            TITLE,
            TITLE1,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            OPTIONS_REMOVE_FROM__MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            CLOSE_ARTICLE_TITLE,
            CLOSE_ARTICLE_TITLE1,
            SAVE_TEST,
            TEXT,
            TEXT1;


    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    @Step("Waiting for title on the article page")
    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page", 135);

    }

    @Step("Waiting for ios title on the article page")
    public WebElement waitForIosTitleElement() {
        return this.waitForElementPresent(TITLE1, "Cannot find article title on page", 15);

    }

    @Step("Get article title")
    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        screenshot(this.takeScreenshot("article_title"));
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()) {
            return title_element.getAttribute("name");
        } else {
            return title_element.getText();
        }
    }

    @Step("Get article ios title")
    public String getArticleTitleIOS() {
        WebElement title_element = waitForIosTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }
    }

@Step("Swiping to footer on article page")
    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(FOOTER_ELEMENT, "Cannot find the end of article", 40);
        } else if (Platform.getInstance().isIOS()) {
            this.swipeUpTillElementAppear(FOOTER_ELEMENT, "Cannot find the end of article", 40);
        } else {
            this.scrollWebPageTitleElementNotVisible(FOOTER_ELEMENT, "Cannot find the end of article", 40);
        }

    }

    @Step("Adding the article to my list")
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

    @Step("Adding the article1 to my list")
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

    @Step("Adding the article to my saved articles")
    public void addArticlesToMySaved() throws InterruptedException {
        Thread.sleep(3000);
        if (Platform.getInstance().isMW()) {
            this.removeArticleFromSavedIfItAdded();
        }
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to reading list", 10);
    }

    @Step("Removing the article from saved if it has been added")
    public void removeArticleFromSavedIfItAdded() {
        if (this.isElementPresent(OPTIONS_REMOVE_FROM__MY_LIST_BUTTON)) {
            this.waitForElementAndClick(
                    OPTIONS_REMOVE_FROM__MY_LIST_BUTTON,
                    "Cannot click button to remove an article from saved",
                    1
            );


            this.waitForElementPresent(
                    OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find button to add an article to saved list after removing it from this list before"
            );

        }
    }

    @Step("Closing the article")
    public void closeArticle() {
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()) {
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_TITLE,
                    "Cannot close article, cannot find X link",
                    5
            );
        } else {
            System.out.println("Methods closeArticle() does nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }

    @Step("Closing the article 1")
    public void closeArticle1() {
        if (Platform.getInstance().isIOS()) {
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_TITLE1,
                    "Cannot close article, cannot find X link",
                    5
            );
        } else {
            System.out.println("Methods closeArticle() does nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }

    public void saveTest() {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );
    }

    @Step("Waiting for element")
    public void waitForElement() {
        this.waitForElementPresent(TEXT, "Cannot find element", 5);
    }

    @Step("Waiting for element description")
    public void waitForElementDescription() {
        this.waitForElementPresent(TEXT1, "Cannot find element", 5);
    }


    public void waitForElementAndClick() {
        this.waitForElementAndClick(TEXT, "Cannot find element", 5);
    }


}
