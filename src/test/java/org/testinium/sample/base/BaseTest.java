package org.testinium.sample.base;

import com.thoughtworks.gauge.*;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    public WebDriver driver;

    @BeforeSpec
    public void setUp() {

        driver = DriverFactory.getDriver("chrome");

    }

    @AfterSpec
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
