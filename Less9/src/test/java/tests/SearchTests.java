package tests;

import lib.CoreTestCase;
import lib.Platform;
import org.junit.Test;
import ui.SearchPageObject;
import ui.factories.SearchPageObjectFactory;

public class SearchTests extends CoreTestCase {
    @Test
    public void testSearch() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("bject-oriented programming language");


    }

    @Test
    public void testCancelSearch1() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
    }

    @Test
    public void testAmountOfNotEmptySearch() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park Diskography";

        SearchPageObject.typeSearchLine(search_line);

        //*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        assertTrue(
                "We found too few results",
                amount_of_search_results > 0
        );


    }

    @Test
    public void testAmountOfEmptySearch() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "DSADSADSA";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();

    }

    @Test
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

            assertEquals(
                    "We see unexpected title",
                    "Java",
                    article_title
            );


            String article_title1 = SearchPageObject.waitForSearchResult1("JavaScript");

            assertEquals(
                    "We see unexpected title",
                    "JavaScript",
                    article_title1
            );

            String article_title2 = SearchPageObject.waitForSearchResult1("Java (programming language)");

            assertEquals(
                    "We see unexpected title",
                    "Java (programming language)",
                    article_title2
            );

            SearchPageObject.clickCancelSearch();
            SearchPageObject.waitForNoSearchResult("Java");

        }
    }

    @Test
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
