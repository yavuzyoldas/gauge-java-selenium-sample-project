package org.testinium.sample.stepImplementation;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.testinium.sample.pages.MyBasketPage;

public class StepImplementationBasketPage {

    MyBasketPage myBasketPage;
    public StepImplementationBasketPage(){
        this.myBasketPage = new MyBasketPage();
    }

    @Step("open The Basket")
    public void implementation1() {
        myBasketPage.openTheBasket();
    }

    @Step("comparison Of Product Price And Basket Price")
    public void implementation2() {
        myBasketPage.comparisonOfProductPriceAndBasketPrice();
    }

    @Step("increase Number Products")
    public void implementation3() {
        myBasketPage.increaseNumberProducts();
    }

    @Step("product Number Check")
    public void implementation4() {
        myBasketPage.productNumberCheck();

    }

    @Step("delete Products From Basket And Check")
    public void implementation5() {
        myBasketPage.deleteProductsFromBasketAndCheck();
    }
}
