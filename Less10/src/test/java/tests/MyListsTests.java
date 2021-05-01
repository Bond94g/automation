package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import org.junit.Assert;
import org.junit.Test;
import ui.*;
import ui.factories.ArticlePageObjectFactory;
import ui.factories.MyListsPageObjectFactory;
import ui.factories.NavigationUIFactory;
import ui.factories.SearchPageObjectFactory;

@Epic("Test for adding and delete article in favorites")
public class MyListsTests extends CoreTestCase {

    private static final String name_of_folder = "Learn programming";
    private static final String
            login = "bond94g",
            password = "cerwtccbz";

    @Test
    @Features(value = {@Feature(value = "Favorites"), @Feature(value = "Article")})
    @DisplayName("Adding article in favorites")
    @Description("We adding article in favorites and delete article")
    @Step("Starting test testSaveFirstArticleToMyList")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testSaveFirstArticleToMyList() throws InterruptedException {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }

        if (Platform.getInstance().isMW()) {

            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Thread.sleep(1000);
            Auth.clickAuthButton();

            Auth.enterLoginData(login, password);
            Auth.submitForm();
            Thread.sleep(3000);

            Assert.assertEquals("We are not on the same page after login", article_title, ArticlePageObject.getArticleTitle());
            Thread.sleep(3000);
            ArticlePageObject.addArticlesToMySaved();
            Thread.sleep(3000);
        }

        ArticlePageObject.closeArticle();
        if (Platform.getInstance().isIOS()) {
            ArticlePageObject.closeArticle1();
        }
        Thread.sleep(3000);

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.openNavigaion();

        NavigationUI.clickMyList();
        Thread.sleep(3000);

        MyListPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);

        if (Platform.getInstance().isAndroid()) {
            MyListPageObject.openFolderByName(name_of_folder);
        } else if (Platform.getInstance().isIOS()) {
            MyListPageObject.closeWindow();
        }

        MyListPageObject.swipeByArticleToDelete(article_title);

    }

    @Test
    @Features(value = {@Feature(value = "Favorites"), @Feature(value = "Article")})
    @DisplayName("Adding 2 article in favorites")
    @Description("We adding two article in favorites and delete article")
    @Step("Starting test testSaveSecondArticleToMyList")
    @Severity(value = SeverityLevel.CRITICAL)

    public void testSaveSecondArticleToMyList() throws InterruptedException {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }

        if (Platform.getInstance().isMW()) {

            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Thread.sleep(1000);
            Auth.clickAuthButton();

            Auth.enterLoginData(login, password);
            Auth.submitForm();
            Thread.sleep(3000);

            Assert.assertEquals("We are not on the same page after login", article_title, ArticlePageObject.getArticleTitle());
            Thread.sleep(3000);
            ArticlePageObject.addArticlesToMySaved();
            Thread.sleep(3000);
        }

        ArticlePageObject.closeArticle();
        if (Platform.getInstance().isIOS()) {
            ArticlePageObject.closeArticle1();
        }

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        Thread.sleep(1000);
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            SearchPageObject.clickByArticleWithSubstring("Appium");
        } else {
            SearchPageObject.clickByArticleWithSubstringItem("Appium");
        }

        if (Platform.getInstance().isIOS()) {
            String article_title1 = ArticlePageObject.getArticleTitleIOS();
            ArticlePageObject.waitForIosTitleElement();
        }


        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticle1ToMyList();
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeArticle();
        if (Platform.getInstance().isIOS()) {
            ArticlePageObject.closeArticle1();
        }

        Thread.sleep(1000);


        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.openNavigaion();
        NavigationUI.clickMyList();

        MyListPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            MyListPageObject.openFolderByName(name_of_folder);
        } else if (Platform.getInstance().isIOS()) {
            MyListPageObject.closeWindow();
        }


        MyListPageObject.swipeByArticleToDelete(article_title);
        if (Platform.getInstance().isMW()) {
            ArticlePageObject.waitForElementDescription();
        } else {
            ArticlePageObject.waitForElement();
        }
    }
}
