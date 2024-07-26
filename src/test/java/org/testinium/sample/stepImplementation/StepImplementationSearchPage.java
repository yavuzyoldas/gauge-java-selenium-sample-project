package org.testinium.sample.stepImplementation;

import com.thoughtworks.gauge.Step;
import org.testinium.sample.pages.HomePage;
import org.testinium.sample.pages.SearchPage;

public class StepImplementationSearchPage {

    SearchPage searchPage;

    public StepImplementationSearchPage() {
        this.searchPage = new SearchPage();
        //webDriver = DriverFactory.getDriver();
    }


    @Step("read Data From Excel For First")
    public void implementation1() {
        searchPage.readDataFromExcelForFirst();
    }

    @Step("type Data To Search Bar First")
    public void implementation2() {
        searchPage.typeDataToSearchBarFirst();
    }

    @Step("clean To Search Bar")
    public void implementation3() {
        searchPage.cleanToSearchBar();
    }

    @Step("read Data From Excel For Second")
    public void implementation4() {
        searchPage.readDataFromExcelForSecond();
    }

    @Step("type Data To Search Bar Second")
    public void implementation5() {
        searchPage.typeDataToSearchBarSecond();
    }

    @Step("send Key Data With Enter")
    public void implementation6() {
        searchPage.sendKeyDataWithEnter();
    }

    @Step("choose Random Shirt")
    public void implementation7() {
        searchPage.chooseRandomShirt();
    }
}
