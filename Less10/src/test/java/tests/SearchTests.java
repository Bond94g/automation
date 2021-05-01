package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import org.junit.Assert;
import org.junit.Test;
import ui.SearchPageObject;
import ui.factories.SearchPageObjectFactory;

@Epic("Test for search")
public class SearchTests extends CoreTestCase {
    @Test
    @Features(value = {@Feature(value = "Search")})
    @DisplayName("test search")
    @Description("We search article")
    @Step("Starting test testSearch")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testSearch() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("bject-oriented programming language");


    }

    @Test
    @Features(value = {@Feature(value = "Search")})
    @DisplayName("test cancel search")
    @Description("We cancel search")
    @Step("Starting test testCancelSearch1")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testCancelSearch1() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
    }

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Amount") })
    @DisplayName("test amount search")
    @Description("We amount search")
    @Step("Starting test testAmountOfNotEmptySearch")
    @Severity(value = SeverityLevel.NORMAL)
    public void testAmountOfNotEmptySearch() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park Diskography";

        SearchPageObject.typeSearchLine(search_line);

        //*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        Assert.assertTrue(
                "We found too few results",
                amount_of_search_results > 0
        );


    }

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Amount") })
    @DisplayName("test amount no search")
    @Description("We amount no search")
    @Step("Starting test testAmountOfEmptySearch")
    @Severity(value = SeverityLevel.NORMAL)
    public void testAmountOfEmptySearch() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "DSADSADSA";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();

    }

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Cancel") })
    @DisplayName("test cancel search")
    @Description("We cancel search")
    @Step("Starting test testCancelSearch")
    @Severity(value = SeverityLevel.NORMAL)
    public void testCancelSearch() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");

        if (Platform.getInstance().isMW()) {
            SearchPageObject.waitForSearchElementByTitleMW("1", "Java");
            SearchPageObject.waitForSearchElementByTitleMW("2", "Java", "Script");
            SearchPageObject.waitForSearchElementByTitleMW("3", "Java", " (programming language)");

        } else {

            String article_title = SearchPageObject.waitForSearchResult1("Java");

            Assert.assertEquals(
                    "We see unexpected title",
                    "Java",
                    article_title
            );


            String article_title1 = SearchPageObject.waitForSearchResult1("JavaScript");

            Assert.assertEquals(
                    "We see unexpected title",
                    "JavaScript",
                    article_title1
            );

            String article_title2 = SearchPageObject.waitForSearchResult1("Java (programming language)");

            Assert.assertEquals(
                    "We see unexpected title",
                    "Java (programming language)",
                    article_title2
            );

            SearchPageObject.clickCancelSearch();
            SearchPageObject.waitForNoSearchResult("Java");

        }
    }

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article") })
    @DisplayName("test wait for element by title and description")
    @Description("We wait 3 article for element by title and description ")
    @Step("Starting test testWaitForElementByTitleAndDescription")
    @Severity(value = SeverityLevel.NORMAL)
    public void testWaitForElementByTitleAndDescription() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");

        if (Platform.getInstance().isMW()) {
            SearchPageObject.waitForSearchElementByTitleAndDescriptionMW("2","Java", "High-level programming language" );
            SearchPageObject.waitForSearchElementByTitleAndDescriptionMW("3","Java", "Object-oriented programming language" );
            SearchPageObject.waitForSearchElementByTitleAndDescriptionMW("1","Java", "Indonesian island" );

        } else {

            if (Platform.getInstance().isIOS()) {
                SearchPageObject.waitForElementByTitleAndDescription("JavaScript", "High-level programming language");
            } else {
                SearchPageObject.waitForElementByTitleAndDescription("JavaScript", "Programming language");
            }

            SearchPageObject.waitForElementByTitleAndDescription("Java (programming language)", "Object-oriented programming language");
            if (Platform.getInstance().isAndroid()) {
                SearchPageObject.waitForElementByTitleAndDescription("Java", "Island of Indonesia");
            } else {
                SearchPageObject.waitForElementByTitleAndDescription("Java", "Indonesian island");
            }
        }


    }
}
