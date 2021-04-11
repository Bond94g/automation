package tests;

import lib.CoreTestCase;
import lib.Platform;
import org.junit.Test;
import ui.ArticlePageObject;
import ui.MyListPageObject;
import ui.NavigationUI;
import ui.SearchPageObject;
import ui.factories.ArticlePageObjectFactory;
import ui.factories.MyListsPageObjectFactory;
import ui.factories.NavigationUIFactory;
import ui.factories.SearchPageObjectFactory;

public class MyListsTests extends CoreTestCase {

    private static final String name_of_folder = "Learn programming";

    @Test
    public void testSaveFirstArticleToMyList() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeArticle();
        if (Platform.getInstance().isIOS()) {
            ArticlePageObject.closeArticle1();
        }


        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyList();


        MyListPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            MyListPageObject.openFolderByName(name_of_folder);
        } else {
            MyListPageObject.closeWindow();
        }

        MyListPageObject.swipeByArticleToDelete(article_title);

    }

    @Test
    public void testSaveSecondArticleToMyList() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        }

        else {
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeArticle();
        if (Platform.getInstance().isIOS()) {
            ArticlePageObject.closeArticle1();
        }

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring("Appium");
        if (Platform.getInstance().isIOS()) {
            String article_title1 = ArticlePageObject.getArticleTitleIOS();
            ArticlePageObject.waitForIosTitleElement();
        }



        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticle1ToMyList();
        }
        else {
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeArticle();
        if (Platform.getInstance().isIOS()) {
            ArticlePageObject.closeArticle1();
        }


        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyList();

        MyListPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            MyListPageObject.openFolderByName(name_of_folder);
        }
        else {
            MyListPageObject.closeWindow();
        }



        MyListPageObject.swipeByArticleToDelete(article_title);
        ArticlePageObject.waitForElement();
    }
}
