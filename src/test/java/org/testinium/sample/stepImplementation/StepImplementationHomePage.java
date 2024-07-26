package org.testinium.sample.stepImplementation;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testinium.sample.base.DriverFactory;
import org.testinium.sample.pages.HomePage;


public class StepImplementationHomePage {

    WebDriver webDriver;
    HomePage homePage;

    public StepImplementationHomePage() {
        this.homePage = new HomePage();
        //webDriver = DriverFactory.getDriver();
    }



    @Step("Beymen HomePage Check")
    public void implementation1() {
        homePage.homePageCheck();

    }
}
