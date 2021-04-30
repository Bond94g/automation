package ui;

import io.qameta.allure.Step;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SearchPageObject extends MainPageObject {
    protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULT_BY_SUBSTRING_TPL_ITEM,
            SEARCH_RESULT_BY_SUBSTRING_TPL_1,
            SEARCH_RESULT_BY_SUBSTRING_TPL_2,
            SEARCH_RESULT_BY_SUBSTRING_TPL_3,
            SEARCH_RESULT_BY_SUBSTRING_TPL2,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT_ELEMENT,
            SEARCH_RESULT_BY_SUBSTRING_TPL1;

    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getResultSearchElementItem(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL_ITEM.replace("{SUBSTRING}", substring);
    }

    private static String getResultSearchElement1(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL1.replace("{SUBSTRING}", substring);
    }

    private static String getResultSearchElement2(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL1.replace("{SUBSTRING1}", substring);
    }

    private static String getResultSearchElementNumber(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL_1.replace("{SUBSTRING}", substring);
    }

    private static String getResultSearchElementByTitleMW(String number, String substring) {
        String a = SEARCH_RESULT_BY_SUBSTRING_TPL_1.replace("{NUMBER}", number);
        String b = SEARCH_RESULT_BY_SUBSTRING_TPL_2.replace("{SUBSTRING}", substring);
        return a + b;
    }

    private static String getResultSearchElementByStrongTitleMW(String number, String substring, String substring1) {
        String a = SEARCH_RESULT_BY_SUBSTRING_TPL_1.replace("{NUMBER}", number);
        String b = SEARCH_RESULT_BY_SUBSTRING_TPL_3.replace("{SUBSTRING1}", substring1);
        String c = SEARCH_RESULT_BY_SUBSTRING_TPL_2.replace("{SUBSTRING}", substring);
        return a + b + c;
    }

    private static String getResultSearchElementByTitleAndDescriptionMW(String number, String substring, String substring1) {
        String a = SEARCH_RESULT_BY_SUBSTRING_TPL1.replace("{NUMBER}", number);
        String b = SEARCH_RESULT_BY_SUBSTRING_TPL_2.replace("{SUBSTRING}", substring);
        String c = SEARCH_RESULT_BY_SUBSTRING_TPL2.replace("{SUBSTRING1}", substring1);
        return a + b + c;
    }






    /* TEMPLATES METHODS */

    @Step("Initializing the search field")
    public void initSearchInput() {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element");
    }

    @Step("Waiting for button to cancel search result")
    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button", 10);
    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present", 10);
    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button", 5);
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring);
    }

    public void waitForElementByTitleAndDescription(String title, String description) {
        String search_result_xpath = getResultSearchElement1(title);
        String search_result_xpath1 = getResultSearchElement2(description);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with title " + title);
        this.waitForElementPresent(search_result_xpath1, "Cannot find search result with description " + description);
    }

    public void waitForNoSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementNotPresent(search_result_xpath, "Cannot find search result with substring " + substring, 5);
    }

    public String waitForSearchResult1(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        return this.waitForElementAndGetAttribute(search_result_xpath, "name", "Cannot find search result with substring " + substring, 5);
    }

    public void waitForSearchElementByTitleMW(String number, String substring) {
        String search_result_xpath = getResultSearchElementByTitleMW(number, substring);


        System.out.println(search_result_xpath);


        this.waitForElementPresent(search_result_xpath, "Cannot find search result with title " + number);

    }

    public void waitForSearchElementByTitleMW(String number, String substring, String substring1) {
        String search_result_xpath = getResultSearchElementByStrongTitleMW(number, substring, substring1);


        System.out.println(search_result_xpath);


        this.waitForElementPresent(search_result_xpath, "Cannot find search result with title " + number);

    }

    public void waitForSearchElementByTitleAndDescriptionMW(String number, String substring, String substring1) {
        String search_result_xpath = getResultSearchElementByTitleAndDescriptionMW(number, substring, substring1);


        System.out.println(search_result_xpath);


        this.waitForElementPresent(search_result_xpath, "Cannot find search result with title " + number);

    }

    public void waitForSearchResultNumber(String substring) {
        String search_result_xpath = getResultSearchElementNumber(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring);
    }


    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find click search result with substring " + substring, 15);
    }

    public void clickByArticleWithSubstringItem(String substring) {
        String search_result_xpath = getResultSearchElementItem(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find click search result with substring " + substring, 15);
    }



    public int getAmountOfFoundArticles() {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the request",
                15
        );
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }

    public void waitForEmptyResultsLabel() {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot find empty result elements.", 15);
    }

    public void assertThereIsNoResultOfSearch() {
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed not to find any results");

    }


}
