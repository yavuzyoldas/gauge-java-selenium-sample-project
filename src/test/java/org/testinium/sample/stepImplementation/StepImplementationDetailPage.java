package org.testinium.sample.stepImplementation;

import com.thoughtworks.gauge.Step;
import org.testinium.sample.pages.DetailPage;
import org.testinium.sample.pages.HomePage;

public class StepImplementationDetailPage {


    DetailPage detailPage;

    public StepImplementationDetailPage() {
        this.detailPage = new DetailPage();
        //webDriver = DriverFactory.getDriver();
    }


    @Step("get And Write Details To Txt")
    public void implementation1() {
        detailPage.getAndWriteDetailsToTxt();

    }

    @Step("add Product To Basket")
    public void implementation2() {
        detailPage.addProductToBasket();
    }
}
