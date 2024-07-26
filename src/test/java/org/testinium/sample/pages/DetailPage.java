package org.testinium.sample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testinium.sample.base.DriverFactory;
import org.testinium.sample.uiElements.DetailPageUIElements;
import org.testinium.sample.uiElements.MyBasketPageUIElements;
import org.testinium.sample.util.ElementHelper;
import org.testinium.sample.util.Log;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.testinium.sample.util.UtilFunctions.saveToTxtFile;

public class DetailPage {


    DetailPageUIElements detailPageUIElements;
    MyBasketPageUIElements myBasketPageUIElements;
    ElementHelper elementHelper;
    public static String price;
    WebDriver driver;

    public DetailPage() {
        this.driver = DriverFactory.getDriver();
        //this.driver.navigate().to("https://www.beymen.com");

        this.detailPageUIElements = new DetailPageUIElements();
        this.myBasketPageUIElements = new MyBasketPageUIElements();
        this.elementHelper = new ElementHelper(driver,new WebDriverWait(driver, Duration.ofSeconds(60)));

    }

    public void getAndWriteDetailsToTxt(){

        String description = elementHelper.getText(detailPageUIElements.detailPageDescription);
        price = elementHelper.getText(detailPageUIElements.detailPagePrice);
        saveToTxtFile(description,price);
        elementHelper.waitElements(30);
        Log.info("step -> getAndWriteDetailsToTxt");

    }

    public boolean addProductToBasket(){

        elementHelper.waitVisibilityOfElementLocated(detailPageUIElements.detailPageSize);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> elements = elementHelper.findElements(detailPageUIElements.detailPageSize);
        System.out.println(elements.size());
        WebElement selectSize = null;
        for(WebElement element : elements){
            if (!element.getAttribute("class").contains("-disabled")){
                System.out.println("elements : " + element.getAttribute("class"));
                selectSize = element;
            }

        }
        elementHelper.click(selectSize);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        elementHelper.click(detailPageUIElements.detailPageAddToBasket);
        elementHelper.waitVisibilityOfElementLocated(myBasketPageUIElements.myBasketCount);

        if(elementHelper.isDisplayedElement(myBasketPageUIElements.myBasketCount)){
            if(Objects.equals(elementHelper.findElement(myBasketPageUIElements.myBasketCount).getText(), "(1)")){
                Log.info("step -> addProductToBasket");
                return true;
            }
        }
        Log.info("step -> addProductToBasket");
        return false;



    }

}
