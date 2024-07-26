package org.testinium.sample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testinium.sample.base.DriverFactory;
import org.testinium.sample.uiElements.HomePageUIElements;
import org.testinium.sample.util.ElementHelper;
import org.testinium.sample.util.Log;

import java.time.Duration;

public class HomePage {

    HomePageUIElements homePageUIElements;
    ElementHelper elementHelper;

    WebDriver driver;


    public HomePage() {
        driver = DriverFactory.getDriver();
        driver.navigate().to("https://www.beymen.com");

        this.homePageUIElements = new HomePageUIElements();
        this.elementHelper = new ElementHelper(driver,new WebDriverWait(driver, Duration.ofSeconds(60)));

    }

    public void closeAllPopUps() {

        elementHelper.waitVisibilityOfElementLocated(homePageUIElements.homePageAcceptCookie);
        WebElement element1 = elementHelper.findElement(homePageUIElements.homePageAcceptCookie);

        if(elementHelper.isDisplayedElement(element1)){
            elementHelper.click(homePageUIElements.homePageAcceptCookie);
        }else{
            Log.error("homePageAcceptCookie not exist");
        }

        elementHelper.waitVisibilityOfElementLocated(homePageUIElements.homePageGenderButton);
        WebElement element2 = elementHelper.findElement(homePageUIElements.homePageGenderButton);
        if (elementHelper.isDisplayedElement(element2)) {
            elementHelper.click(homePageUIElements.homePageGenderButton);
        }else{
            Log.error("homePageGenderButton not exist");
        }

        elementHelper.waitVisibilityOfElementLocated(homePageUIElements.homePageNoThanks);

        WebElement element3 = elementHelper.findElement(homePageUIElements.homePageNoThanks);
        if (elementHelper.isDisplayedElement(element3)) {
            elementHelper.click(homePageUIElements.homePageNoThanks);
        }else{
            Log.error("homePageNoThanks not exist");
        }

        Log.info("step -> homePageCheck");

    }


    public boolean homePageCheck(){
        closeAllPopUps();
        boolean check =  elementHelper.isDisplayedElement(elementHelper.findElement(homePageUIElements.homePageCampaigns));
        if (check) Log.info("Home page available!");
        else Log.error("Home page not available!");
        return check;
    }

}
