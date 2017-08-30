package com.github.automation.first;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.automation.first.Utils.*;

/**
 * @author Myhajlo.Rozputnyj on 28.08.2017.
 */
public class AccaBetTest {

    private static final Logger LOGGER = Logger.getLogger(AccaBetTest.class);

    public static WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        LOGGER.info("setup environment");
        driver = setupEnvironment();
    }

    @BeforeMethod
    public void openLobbyPage() throws InterruptedException {
        LOGGER.info("open lobby");
        openLobby(driver);
    }

    @AfterClass
    public void tearDown() {
        LOGGER.info("driver close");
        driver.close();
    }

    @Test
    public void checkAccaBetFeatures() throws Exception {
        /*Open Game
        submit five singles with stake = 0, open multiples page
        check bet name, change stake, check bet
        Start Game, check acca result after skipping races, Click New Game
        submit four singles with stake = 0, open multiples page
        check bet name, change stake, check bet
        Start Game, check acca result after skipping races, Click New Game
        submit six singles with stake = 0, open multiples page
        check bet name, change stake, check bet
        Start Game, check acca result after skipping races, Click New Game
        submit four singles with stake = 0, open multiples page, add EW to Acca
        check bet name, change stake, check bet
        Start Game, check acca result after skipping races, Click New Game
         */
        switchToIframe(driver);
        // submit four singles with stake = 0
        addFourSinglesBetWithZeroStakes(driver);
        int bet;
        // open multiples page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a/span[1]")).click(); // open multiples  page
        Thread.sleep(2000);
        // check bet name
        String betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        LOGGER.info("Bet Name = " + betName);
        if ("Acca".equals(betName)) { // check that Acca bet present at Multiples page
            LOGGER.info("Acca bet is present at Multiples");
        } else {
            LOGGER.info("Acca bet is not present at Multiples");
        }
        Thread.sleep(2000);
        // change stake
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for acca bet
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for acca bet
        Thread.sleep(2000);
        // check bet
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));// acca bet
        LOGGER.info("Numbers of bets at  " + betName + " = " + bet);
        // submit one more singles bet
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[5]")).click(); //open race 5 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[3]/td[4]/a")).click(); //add bet 3 trap 5 race
        Thread.sleep(2000);
        // check bet
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[4]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));// acca bet
        LOGGER.info("Numbers of bets at  " + betName + " = " + bet);

        // Start Game
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(2000);
        Double stake;
        Double result;
        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[2]/div")).getText());//acca stake
        System.out.println("Stake at " + betName + " = " + stake);
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[1]/span")).getText().substring(6));//acca bet
        LOGGER.info("Numbers of bets at  " + betName + " = " + bet);
        Thread.sleep(1000);

        String gameOver;
        gameOver = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/span/translate/span")).getText();
        LOGGER.info("Game session = " + gameOver);

        // check that "Game Over message displayed" after 1 race

        for (int i = 0; i <= 4; i++) {
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click(); // click skip race
            Thread.sleep(2000);
            gameOver = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/span/translate/span")).getText();
            System.out.println("Game session = " + gameOver);
            if (!"Game Over".equals(gameOver)) { // check that Game over is NOT appeared
                result = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[3]/span")).getText());//acca result
                System.out.println("Win value of " + betName + " bet = " + result);
                driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click(); // click Next Race
                Thread.sleep(1000);
                if (i == 3) {
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click();// Click New Game
                }
            } else {
                LOGGER.info("Acca bet is lost");
                result = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[3]/span")).getText());//acca result
                LOGGER.info("Win value of " + betName + " bet = " + result);
                driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click();// Click New Game
                break;
            }
        }

        // check acca for 4 singles
        addFourSinglesBetWithZeroStakes(driver);
        // open multiples page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a/span[1]")).click(); // open multiples  page
        Thread.sleep(2000);
        // check bet name
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        LOGGER.info("Bet Name = " + betName);
        if ("Acca".equals(betName)) { // check that Acca bet present at Multiples page
            LOGGER.info("Acca bet is present at Multiples");
        } else {
            LOGGER.info("Acca bet is not present at Multiples");
        }
        Thread.sleep(2000);
        // change stake
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for acca bet
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for acca bet
        Thread.sleep(2000);
        // check bet
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));// acca bet
        LOGGER.info("Numbers of bets at  " + betName + " = " + bet);

        // Start Game
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(2000);
        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[2]/div")).getText());//acca stake
        System.out.println("Stake at " + betName + " = " + stake);
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[1]/span")).getText().substring(6));//acca bet
        LOGGER.info("Numbers of bets at  " + betName + " = " + bet);
        Thread.sleep(1000);

        gameOver = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/span/translate/span")).getText();
        LOGGER.info("Game session = " + gameOver);

        skipFourRacesForAcca(betName);

        /* check acca for 6 singles */
        addSixSinglesBetWithZeroStakes(driver);
        // open multiples page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a/span[1]")).click(); // open multiples  page
        Thread.sleep(2000);
        // check bet name
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[5]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        LOGGER.info("Bet Name = " + betName);
        if ("Acca".equals(betName)) { // check that Acca bet present at Multiples page
            LOGGER.info("Acca bet is present at Multiples");
        } else {
            LOGGER.info("Acca bet is not present at Multiples");
        }
        Thread.sleep(2000);
        // change stake
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[5]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for acca bet
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[5]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for acca bet
        Thread.sleep(2000);
        // check bet
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[5]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));// acca bet
        LOGGER.info("Numbers of bets at  " + betName + " = " + bet);
        // Start Game
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(2000);
        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[2]/div")).getText());//acca stake
        System.out.println("Stake at " + betName + " = " + stake);
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[1]/span")).getText().substring(6));//acca bet
        LOGGER.info("Numbers of bets at  " + betName + " = " + bet);
        Thread.sleep(1000);

        gameOver = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/span/translate/span")).getText();
        LOGGER.info("Game session = " + gameOver);

        for (int i = 0; i <= 5; i++) {
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click(); // click skip race
            Thread.sleep(2000);
            gameOver = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/span/translate/span")).getText();
            System.out.println("Game session = " + gameOver);
            if (!"Game Over".equals(gameOver)) { // check that Game over is NOT appeared
                result = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[3]/span")).getText());//acca result
                System.out.println("Win value of " + betName + " bet = " + result);
                driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click(); // click Next Race
                Thread.sleep(1000);
                if (i == 5) {
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click();// Click New Game
                }
            } else {
                LOGGER.info("Acca bet is lost");
                result = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[3]/span")).getText());//acca result
                LOGGER.info("Win value of " + betName + " bet = " + result);
                driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click();// Click New Game
                break;
            }
        }

        /* check acca (EW = yes) for 4 with singles */
        addFourSinglesBetWithZeroStakes(driver);
        // open multiples page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a/span[1]")).click(); // open multiples  page
        Thread.sleep(2000);
        // check bet name
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        LOGGER.info("Bet Name = " + betName);
        if ("Acca".equals(betName)) { // check that Acca bet present at Multiples page
            LOGGER.info("Acca bet is present at Multiples");
        } else {
            LOGGER.info("Acca bet is not present at Multiples");
        }
        Thread.sleep(2000);
        // change stake
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for acca bet
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for acca bet
        Thread.sleep(2000);
        // set EW = yes
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[2]/div/div")).click();// Set EW = yes for acca bet
        Thread.sleep(2000);
        // check bet
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));// acca bet
        LOGGER.info("Numbers of bets at  " + betName + " = " + bet);

        // Start Game
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(2000);
        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[2]/div")).getText());//acca stake
        System.out.println("Stake at " + betName + " = " + stake);
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[1]/span")).getText().substring(6));//acca bet
        LOGGER.info("Numbers of bets at  " + betName + " = " + bet);
        Thread.sleep(1000);

        gameOver = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/span/translate/span")).getText();
        LOGGER.info("Game session = " + gameOver);

        skipFourRacesForAcca(betName);
        LOGGER.info("Test completed");
    }

    public void skipFourRacesForAcca(String betName) throws InterruptedException {
        String gameOver;
        Double result;
        for (int i = 0; i <= 3; i++) {
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click(); // click skip race
            Thread.sleep(2000);
            gameOver = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/span/translate/span")).getText();
            System.out.println("Game session = " + gameOver);
            if (!"Game Over".equals(gameOver)) { // check that Game over is NOT appeared
                result = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[3]/span")).getText());//acca result
                System.out.println("Win value of " + betName + " bet = " + result);
                driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click(); // click Next Race
                Thread.sleep(1000);
                if (i == 2) {
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click();// Click New Game
                }
            } else {
                LOGGER.info("Acca bet is lost");
                result = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[3]/span")).getText());//acca result
                LOGGER.info("Win value of " + betName + " bet = " + result);
                driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click();// Click New Game
                Thread.sleep(2000);
                break;
            }
        }
    }

}
