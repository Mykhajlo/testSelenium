package com.github.automation.first;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Myhajlo.Rozputnyj
 */
public class Utils {

    static void switchToIframe(WebDriver driver) {
        driver.switchTo().frame(driver.findElement(By.id("iframeContainer")));
    }

    static ChromeDriver setupEnvironment() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        Dimension d = new Dimension(1400, 900); // > HD resolution
        driver.manage().window().setSize(d);
        //driver.manage().window().maximize(); // full size  of screen
        return driver;
    }
}
