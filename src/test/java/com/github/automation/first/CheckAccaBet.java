package com.github.automation.first;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.github.automation.first.Utils.setupEnvironment;
import static com.github.automation.first.Utils.switchToIframe;
import static org.openqa.selenium.By.xpath;

/**
 * @author Myhajlo.Rozputnyj on 28.08.2017.
 */
public class CheckAccaBet {

    private static final Logger LOGGER = Logger.getLogger(CheckAccaBet.class);

    public static WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = setupEnvironment();
    }

    @BeforeMethod
    public void OpenLobbyPage() throws InterruptedException {
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
//        System.out.println(driver.getCurrentUrl());

        //PageLoadTimeout Command
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("/html/body/div/div/section/div/div[5]/div[5]/a[1]")));
        driver.findElement(xpath("/html/body/div/div/section/div/div[5]/div[5]/a[1]")).click();
        Thread.sleep(5000);
        for (String handleGame : driver.getWindowHandles()) {
            driver.switchTo().window(handleGame);
        }
        LOGGER.info(driver.getCurrentUrl());
//        System.out.println(driver.getCurrentUrl());
        //Open url
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @Test
    public void CheckAccaBetFeatures() throws Exception {
        //Open Game
        switchToIframe(driver);
        LOGGER.info("Bingo! You are at iframeContainer");
//        System.out.println("Bingo! You are at iframeContainer");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5, 10000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a"))); // find Add to Bet slip button for Race 1 and Trap 6
        } catch (Throwable e) {
            System.out.println("Error while switching to the frame. " + e.getMessage());
        }
        Thread.sleep(1000);

        // submit four singles with stake = 0, addSixSinglesBetWithZeroStake
        addFourSinglesBetWithZeroStake();
        int bet;
        // open multiples page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a/span[1]")).click(); // open multiples  page
        Thread.sleep(2000);
        // check bet name
        String betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        System.out.println("Bet Name = " + betName);
        if (betName.equals("Acca")) { // check that Acca bet present at Multiples page
            System.out.println("Acca bet is present at Multiples");
        } else System.out.println("Acca bet is not present at Multiples");
        Thread.sleep(2000);
        // change stake
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for acca bet
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for acca bet
        Thread.sleep(2000);
        // check bet
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));// acca bet
        System.out.println("Numbers of bets at  " + betName + " = " + bet);
        // submit one more singles bet
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[5]")).click(); //open race 5 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[3]/td[4]/a")).click(); //add bet 3 trap 5 race
        Thread.sleep(2000);
        // check bet
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[4]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));// acca bet
        System.out.println("Numbers of bets at  " + betName + " = " + bet);

        // Start Game
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(2000);
        Double stake;
        Double result;
        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[2]/div")).getText());//acca stake
        System.out.println("Stake at " + betName + " = " + stake);
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[1]/span")).getText().substring(6));//acca bet
        System.out.println("Numbers of bets at " + betName + " = " + bet);
        Thread.sleep(1000);

        String gameOver;
        gameOver = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/span/translate/span")).getText();
        System.out.println("Game session = " + gameOver);

        // check that "Game Over message displayed" after 1 race

        for (int i = 0; i < 4; i++) {
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
                System.out.println("Acca bet is lost");
                result = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[3]/span")).getText());//acca result
                System.out.println("Win value of " + betName + " bet = " + result);
                driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click();// Click New Game
                break;
            }
        }
    }

    private void addFourSinglesBetWithZeroStake() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); //add bet 1 trap 1 race
        System.out.println("Bet at race 1 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[2]")).click(); //open race 2 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[5]/td[4]/a")).click(); //add bet 5 trap 2 race
        System.out.println("Bet at race 2 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[3]")).click(); //open race 3 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a")).click(); //add bet 6 trap 3 race
        System.out.println("Bet at race 3 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[4]")).click(); //open race 4 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a")).click(); //add bet 6 trap 4 race
        Thread.sleep(2000);
        System.out.println("Bet at race 4 added");
        Thread.sleep(2000);
    }
}
