package com.github.automation.first;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

import static com.github.automation.first.FirstTest.driver;
import static org.openqa.selenium.By.xpath;

/**
 * @author Myhajlo.Rozputnyj
 */
public class Utils {
    private static final Logger LOGGER = Logger.getLogger(Utils.class);

    static void switchToIframe(WebDriver driver) throws InterruptedException {
        driver.switchTo().frame(driver.findElement(By.id("iframeContainer")));
        LOGGER.info("Bingo! You are at iframeContainer");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5, 10000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a"))); // find Add to Bet slip button for Race 1 and Trap 6
        } catch (Throwable e) {
            LOGGER.info("Error while switching to the frame. " + e.getMessage());
        }
        Thread.sleep(1000);
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

    static void openLobby(WebDriver driver) throws InterruptedException {
        driver.get("https://cdn.gameiom.com/gameiom/gamelobby/test/build-4/index.html#!/login");
        driver.getWindowHandle();
        Thread.sleep(1000);
        // Fill 'Login' field
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("/html/body/div/div/section/section/form/input[1]")));
        driver.findElement(xpath("/html/body/div/div/section/section/form/input[1]"))
                .sendKeys("gameiom_test4");
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        //Click 'Login' button
        driver.findElement(xpath("/html/body/div/div/section/section/form/button")).click();
        LOGGER.info(driver.getCurrentUrl());

        //PageLoadTimeout Command
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("/html/body/div/div/section/div/div[5]/div[5]/a[1]")));
        driver.findElement(xpath("/html/body/div/div/section/div/div[5]/div[5]/a[1]")).click();
        Thread.sleep(5000);
        for (String handleGame : driver.getWindowHandles()) {
            driver.switchTo().window(handleGame);
        }
        LOGGER.info(driver.getCurrentUrl());
        //Open url
    }

    static void addSixSinglesBetWithZeroStakes(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); //add bet 1 trap 1 race
        LOGGER.info("Bet at race 1 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[2]")).click(); //open race 2 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[5]/td[4]/a")).click(); //add bet 5 trap 2 race
        LOGGER.info("Bet at race 2 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[3]")).click(); //open race 3 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a")).click(); //add bet 6 trap 3 race
        LOGGER.info("Bet at race 3 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[4]")).click(); //open race 4 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a")).click(); //add bet 6 trap 4 race
        Thread.sleep(2000);
        LOGGER.info("Bet at race 4 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[5]")).click(); //open race 5 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[3]/td[4]/a")).click(); //add bet 3 trap 5 race
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[1]/a/span")).click(); // open singles page
        LOGGER.info("Bet at race 5 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[6]")).click(); //open race 6 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[4]/td[4]/a")).click(); //add bet 4 trap 6 race
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[1]/a/span")).click(); // open singles page
        LOGGER.info("Bet at race 6 added");
        Thread.sleep(2000);
    }
    static void addFiveSinglesBetWithZeroStakes(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); //add bet 1 trap 1 race
        LOGGER.info("Bet at race 1 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[2]")).click(); //open race 2 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[5]/td[4]/a")).click(); //add bet 5 trap 2 race
        LOGGER.info("Bet at race 2 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[3]")).click(); //open race 3 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a")).click(); //add bet 6 trap 3 race
        LOGGER.info("Bet at race 3 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[4]")).click(); //open race 4 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a")).click(); //add bet 6 trap 4 race
        Thread.sleep(2000);
        LOGGER.info("Bet at race 4 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[5]")).click(); //open race 5 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[3]/td[4]/a")).click(); //add bet 3 trap 5 race
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[1]/a/span")).click(); // open singles page
        LOGGER.info("Bet at race 5 added");
        Thread.sleep(2000);
    }
    static void addFourSinglesBetWithZeroStakes(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); //add bet 1 trap 1 race
        LOGGER.info("Bet at race 1 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[2]")).click(); //open race 2 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[5]/td[4]/a")).click(); //add bet 5 trap 2 race
        LOGGER.info("Bet at race 2 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[3]")).click(); //open race 3 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a")).click(); //add bet 6 trap 3 race
        LOGGER.info("Bet at race 3 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[4]")).click(); //open race 4 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a")).click(); //add bet 6 trap 4 race
        Thread.sleep(2000);
        LOGGER.info("Bet at race 4 added");
        Thread.sleep(2000);
    }
}
