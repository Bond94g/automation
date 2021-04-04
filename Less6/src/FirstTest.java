import lib.CoreTestCase;
import org.junit.Test;

import ui.*;


public class FirstTest extends CoreTestCase {



//    @Test
//    public void testCancelSearch() {
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/search_container"),
//                "Cannot find search Wikipedia input",
//                5
//        );
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                "Java",
//                "Cannot find search input",
//                5
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/search_close_btn"),
//                "Cannot find X to cancel search",
//                5
//        );
//
//        MainPageObject.waitForElementNotPresent(
//                By.id("org.wikipedia:id/search_close_btn"),
//                "X is still present on the page",
//                5
//        );
//    }





//    @Test
//    public void testComparePlaceholderSearch() {
//        MainPageObject.assertElementHasText(By.xpath("//*[@resource-id='org.wikipedia:id/search_container']//*[@text='Search Wikipedia']"), "Search Wikipedia", "placeholder don't find");
//    }
//
//    @Test
//    public void testcheckWordSeacrh() {
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Cannot find search Wikipedia input",
//                5
//        );
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                "Java",
//                "Cannot find search input",
//                5
//        );
//
//        WebElement title_element = MainPageObject.waitForElementPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Java']"),
//                "Cannot find artical title",
//                15
//        );
//
//        String article_title = title_element.getAttribute("text");
//
//        assertTrue("text don't find", article_title.contains("Java"));
//
//
//        WebElement title_element1 = MainPageObject.waitForElementPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='JavaScript']"),
//                "Cannot find artical title",
//                15
//        );
//
//        String article_title1 = title_element1.getAttribute("text");
//
//        assertTrue(article_title1.contains("Java"));
//
//        WebElement title_element2 = MainPageObject.waitForElementPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Java (programming language)']"),
//                "Cannot find artical title",
//                15
//        );
//
//        String article_title2 = title_element2.getAttribute("text");
//
//        assertTrue(article_title2.contains("Java"));
//
//
//    }



//





//    @Test
//    public void testAssertElementPresent() {
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Cannot find search Wikipedia input",
//                5
//        );
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                "Java",
//                "Cannot find search input",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//                "Cannot find search Wikipedia input",
//                15
//        );
//
//
//        MainPageObject.assertElementPresent(By.id("org.wikipedia:id/view_page_title_text"), "Java (programming language)");
//    }


}
