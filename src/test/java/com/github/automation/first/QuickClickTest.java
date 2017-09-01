package com.github.automation.first;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.automation.first.FirstTest.driver;
import static com.github.automation.first.Utils.openLobby;
import static com.github.automation.first.Utils.setupEnvironment;
import static com.github.automation.first.Utils.switchToIframe;

/**
 * Created by Myhajlo.Rozputnyj on 31.08.2017.
 */
public class QuickClickTest {
    private static final Logger LOGGER = Logger.getLogger(AccaBetTest.class);

    public static WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = setupEnvironment();
    }

    @BeforeMethod
    public void openLobbyPage() throws InterruptedException {
        openLobby(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
    @Test
    public void QuickClickFeatures() throws Exception {
        /*Open Game

         */
        switchToIframe(driver);

        // Try Click several time  'Add to Bet Slip' button
        for (int i = 0; i < 6; i++) {
            try {
            driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); // click 'Add to Bet Slip' button : 1 trap 1 race
            Thread.sleep(100);
            LOGGER.info("Add to Bet Slip clicked " + i);
            } catch (Throwable e) {
                LOGGER.info("Button 'Add to Bet Slip' is not clicked ");
            }
        }
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); //add bet 1 trap 1 race
        LOGGER.info("Bet at race 1 added");
        Thread.sleep(2000);

        // Try Click several time  '+' button for single bet
        for (int i = 0; i < 6; i++) {
            try {
                driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// click "+"
                Thread.sleep(100);
                LOGGER.info("Button '+' clicked " + i);
            } catch (Throwable e) {
                LOGGER.info("Button '+' is not clicked ");
            }
        }
        Thread.sleep(2000);

        // Try Click several time  '-' button for single bet
        for (int i = 0; i < 6; i++) {
            try {
                driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[1]")).click();// click "-"
                Thread.sleep(100);
                LOGGER.info("Button '-' clicked " + i);
            } catch (Throwable e) {
                LOGGER.info("Button '-' is not clicked ");
            }
        }
        Thread.sleep(2000);

        // Try Click several time  'EW' button for single bet
        for (int i = 0; i < 6; i++) {
            try {
                driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[2]/div")).click();// click "EW"
                Thread.sleep(100);
                LOGGER.info("Button 'EW' clicked " + i);
            } catch (Throwable e) {
                LOGGER.info("Button 'EW' is not clicked ");
            }
        }
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[2]")).click(); //open race 2 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[5]/td[4]/a")).click(); //add bet 5 trap 2 race
        LOGGER.info("Bet at race 2 added");
        Thread.sleep(2000);
        // open multiples page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a/span[1]")).click(); // open multiples  page
        Thread.sleep(2000);

        // Try Click several time  '+' button for multiples bet
        for (int i = 0; i < 6; i++) {
            try {
                driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// click "+"
                Thread.sleep(100);
                LOGGER.info("Button '+' clicked " + i);
            } catch (Throwable e) {
                LOGGER.info("Button '+' is not clicked ");
            }
        }
        Thread.sleep(2000);

        // Try Click several time  '-' button for multiples bet
        for (int i = 0; i < 6; i++) {
            try {
                driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[1]")).click();// click "-"
                Thread.sleep(100);
                LOGGER.info("Button '-' clicked " + i);
            } catch (Throwable e) {
                LOGGER.info("Button '-' is not clicked ");
            }
        }
        Thread.sleep(2000);

        // Try Click several time  'EW' button for multiples bet
        for (int i = 0; i < 6; i++) {
            try {
                driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[2]/div/div")).click();// click "EW"
                Thread.sleep(100);
                LOGGER.info("Button 'EW' clicked " + i);
            } catch (Throwable e) {
                LOGGER.info("Button 'EW' is not clicked ");
            }
        }
        Thread.sleep(2000);

        //sibmit several more singles  bet with  stakes
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[3]")).click(); //open race 3 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a")).click(); //add bet 6 trap 3 race
        LOGGER.info("Bet at race 3 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[1]/a/span")).click(); // open singles page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// click "+"
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[4]")).click(); //open race 4 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a")).click(); //add bet 6 trap 4 race
        Thread.sleep(2000);
        LOGGER.info("Bet at race 4 added");
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[1]/a/span")).click(); // open singles page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[4]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// click "+"
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[5]")).click(); //open race 5 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[3]/td[4]/a")).click(); //add bet 3 trap 5 race
        Thread.sleep(2000);
        LOGGER.info("Bet at race 5 added");
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[1]/a/span")).click(); // open singles page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[5]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// click "+"
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[6]")).click(); //open race 6 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[4]/td[4]/a")).click(); //add bet 4 trap 6 race
        Thread.sleep(2000);
        LOGGER.info("Bet at race 6 added");
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[1]/a/span")).click(); // open singles page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[5]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// click "+"
        Thread.sleep(2000);


        // Try Click several time 'START GAME' button
        for (int i = 0; i < 6; i++) {
            try {
                driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// click "START GAME"
                Thread.sleep(100);
                LOGGER.info("Button 'START GAME' clicked " + i);
            } catch (Throwable e) {
                LOGGER.info("Button 'START GAME' is not clicked ");
            }
        }
        Thread.sleep(2000);

//        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[2]/div")).click();// click "WATCH RACE"
//        Thread.sleep(2000);

        // Try Click several time 'WATCH RACE' button
        for (int i = 0; i < 6; i++) {
            try {
                driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[2]/div")).click();// click "WATCH RACE"
                Thread.sleep(1);
                LOGGER.info("Button 'WATCH RACE' clicked " + i);
            } catch (StaleElementReferenceException e) {
                LOGGER.info(e.getMessage());
                LOGGER.info("Button 'WATCH RACE' is not clicked ");
            }
        }
        Thread.sleep(1000);

        // Try Click several time 'SKIP' button at video
        for (int i = 0; i < 6; i++) {
            try {
                driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a/div")).click();// click "SKIP"
                Thread.sleep(100);
                LOGGER.info("Button 'SKIP' at  video is clicked " + i);
            } catch (Throwable e) {
                LOGGER.info("Button 'SKIP' at  video is not clicked ");
            }
        }
        Thread.sleep(3000);

        // Try Click several time 'Next Race' button
        for (int i = 0; i < 6; i++) {
            try {
                driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click();// click "Next Race"
                Thread.sleep(100);
                LOGGER.info("Button 'Next Race' at  video is clicked " + i);
            } catch (Throwable e) {
                LOGGER.info("Button 'Next Race' at  video is not clicked ");
            }
        }
        Thread.sleep(2000);

        // Try Click several time 'Skip' button at race part
        for (int i = 0; i < 6; i++) {
            try {
                driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click();// click "Skip"
                Thread.sleep(100);
                LOGGER.info("Button 'Skip' at  video is clicked " + i);
            } catch (Throwable e) {
                LOGGER.info("Button 'Skip' at  video is not clicked ");
            }
        }
        Thread.sleep(2000);

        // Try Click several time 'Skip All' button at race part
        for (int i = 0; i < 6; i++) {
            try {
                driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div")).click();// click "Skip All"
                Thread.sleep(100);
                LOGGER.info("Button 'Skip All' at  video is clicked " + i);
            } catch (Throwable e) {
                LOGGER.info("Button 'Skip All' at  video is not clicked ");
            }
        }
        Thread.sleep(2000);

        // Try Click several time 'New Game' button at race part
        for (int i = 0; i < 6; i++) {
            try {
                driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div")).click();// click "New Game"
                Thread.sleep(100);
                LOGGER.info("Button 'New Game' at  video is clicked " + i);
            } catch (Throwable e) {
                LOGGER.info("Button 'New Game' at  video is not clicked ");
            }
        }
        Thread.sleep(2000);



    }
}
