package ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.SearchPageObject;

public class MWSearchPageObject extends SearchPageObject {
    static {

        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:div.header-action>button.cancel";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class,'wikidata-description')][contains(text(),'{SUBSTRING}')]";
        SEARCH_RESULT_BY_SUBSTRING_TPL_1 = "xpath://ul[contains(@class,'page-list')]//li[{NUMBER}]";
        SEARCH_RESULT_BY_SUBSTRING_TPL_2 = "//strong[contains(text(), '{SUBSTRING}')]";
        SEARCH_RESULT_BY_SUBSTRING_TPL_3 = "//h3[contains(text(), '{SUBSTRING1}')]";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
        SEARCH_RESULT_BY_SUBSTRING_TPL1 = "xpath://ul[contains(@class, 'page-list')]/li[{NUMBER}]";
        SEARCH_RESULT_BY_SUBSTRING_TPL2="/../../div[@class= 'wikidata-description'][contains(text(), '{SUBSTRING1}')]";


    }


    public  MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
