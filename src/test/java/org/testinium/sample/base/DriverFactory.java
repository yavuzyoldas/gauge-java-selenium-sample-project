package org.testinium.sample.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {


    private static WebDriver driver;

    // Get WebDriver instance based on browser type
    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            System.out.println("driver == null");
            switch (browser.toLowerCase()) {
                case "chrome":

                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    System.out.println("chromeee");
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                // Add more browsers here if needed (e.g., Firefox, Edge, etc.)
                default:
                    throw new IllegalArgumentException("Browser " + browser + " not supported.");
            }
        }
        System.out.println("chromeee2");
        return driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }

    // Quit the WebDriver instance
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
