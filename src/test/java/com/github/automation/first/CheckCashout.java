package com.github.automation.first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.github.automation.first.FirstTest.driver;
import static java.util.Optional.ofNullable;

/**
 * Created by mykhail on 10.08.17.
 */
public class CheckCashout {
    public WebDriver webDriver;
    @BeforeClass
    public void setUp() {
        webDriver = driver;
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }

    public void CheckCashoutFeatures () throws Exception {
        /* Open Game
        add 6th singles bet with stakes!= 0
        start race, skip all races one by one anf check Cashout button
        add 3 singles bet with stakes!= 0
        start race, skip all races one by one anf check Cashout button
        add 4th singles bet
        start race, skip all races one by one anf check Cashout button
        */
        driver.switchTo().frame(driver.findElement(By.id("iframeContainer")));
        System.out.println("Bingo! You are at iframeContainer");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5, 10000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a"))); // find Add to Bet slip button for Race 1 and Trap 6
        } catch (Throwable e) {
            System.out.println("Error while switching to the frame. " + e.getMessage());
        }
        Thread.sleep(1000);

        //add 6th singles bet
        addSixSinglesWithStakes();

        // start race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(1000);

        // skip 1  race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click();// Click Skip
        Thread.sleep(1000);
        // check that Next Race appeared
        checkNextRaceIsPresent();
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click();// Click Next Race
        Thread.sleep(1000);
        // Check that Cashout button is present
        checkCashoutIsPresent();
        Thread.sleep(1000);

        // skip 2 race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click();// Click Skip
        Thread.sleep(1000);
        // check that Next Race appeared
        checkNextRaceIsPresent();
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click();// Click Next Race
        Thread.sleep(1000);
        // Check that Cashout button is present
        checkCashoutIsPresent();
        Thread.sleep(1000);

        // skip 3 race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click();// Click Skip
        Thread.sleep(1000);
        // check that Next Race appeared
        checkNextRaceIsPresent();
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click();// Click Next Race
        Thread.sleep(1000);
        // Check that Cashout button is present
        checkCashoutIsPresent();
        Thread.sleep(1000);

        // skip 4 race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click();// Click Skip
        Thread.sleep(1000);
        // check that Next Race appeared
        checkNextRaceIsPresent();
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click();// Click Next Race
        Thread.sleep(1000);
        // Check that Cashout button is present
        checkCashoutIsPresent();
        Thread.sleep(1000);

        // skip 5 race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click();// Click Skip
        Thread.sleep(1000);
        // check that Next Race appeared
        checkNextRaceIsPresent();
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click();// Click Next Race
        Thread.sleep(1000);
        // Check that Cashout button is present
        checkCashoutIsPresent();
        Thread.sleep(1000);

        // skip 6 race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click();// Click Skip
        Thread.sleep(1000);
        // Check that Cashout button is present
        checkCashoutIsPresent();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click(); // Click New Game button
        Thread.sleep(1000);

        // add 3  singles  bet
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); //add bet 1 trap 1 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add default stake ("+")
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add stake ("+")
        System.out.println("Bet at race 1 added");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[2]")).click(); //open race 2 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[5]/td[4]/a")).click(); //add bet 5 trap 2 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add default stake ("+")
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add stake ("+")
        System.out.println("Bet at race 2 added");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[3]")).click(); //open race 3 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[2]/td[4]/a")).click(); //add bet 2 trap 3 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add default stake ("+")
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add stake ("+")
        System.out.println("Bet at race 3 added");
        Thread.sleep(1000);

        // start race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(1000);

        // skip 1  race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click();// Click Skip
        Thread.sleep(1000);
        // check that Next Race appeared
        checkNextRaceIsPresent();
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click();// Click Next Race
        Thread.sleep(1000);
        // Check that Cashout button is present
        checkCashoutIsPresent();
        Thread.sleep(1000);

        // skip 2 race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click();// Click Skip
        Thread.sleep(1000);
        // check that Next Race appeared
        checkNextRaceIsPresent();
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click();// Click Next Race
        Thread.sleep(1000);
        // Check that Cashout button is present
        checkCashoutIsPresent();
        Thread.sleep(1000);

        // skip 3 race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click();// Click Skip
        Thread.sleep(1000);
        // Check that Cashout button is present
        checkCashoutIsPresent();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click(); // Click New Game button
        Thread.sleep(1000);

        //add 4th singles bet
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); //add bet 1 trap 1 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add default stake ("+")
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add stake ("+")
        System.out.println("Bet at race 1 added");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[3]")).click(); //open race 3 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[2]/td[4]/a")).click(); //add bet 2 trap 3 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add default stake ("+")
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add stake ("+")
        System.out.println("Bet at race 3 added");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[4]")).click(); //open race 4 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[2]/td[4]/a")).click(); //add bet 2 trap 4 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add default stake ("+")
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add stake ("+")
        System.out.println("Bet at race 4 added");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[5]")).click(); //open race 5 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[3]/td[4]/a")).click(); //add bet 3 trap 5 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[1]/a/span")).click(); // open singles page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[4]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add default stake ("+")
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[4]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add stake ("+")
        System.out.println("Bet at race 5 added");
        Thread.sleep(1000);

        // start race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(1000);

        // skip 1  race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click();// Click Skip
        Thread.sleep(1000);
        // check that Next Race appeared
        checkNextRaceIsPresent();
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click();// Click Next Race
        Thread.sleep(1000);
        // Check that Cashout button is present
        checkCashoutIsPresent();
        Thread.sleep(1000);

        // skip 2 race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click();// Click Skip
        Thread.sleep(1000);
        // check that Next Race appeared
        checkNextRaceIsPresent();
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click();// Click Next Race
        Thread.sleep(1000);
        // Check that Cashout button is present
        checkCashoutIsPresent();
        Thread.sleep(1000);

        // skip 3 race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click();// Click Skip
        Thread.sleep(1000);
        // check that Next Race appeared
        checkNextRaceIsPresent();
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click();// Click Next Race
        Thread.sleep(1000);
        // Check that Cashout button is present
        checkCashoutIsPresent();
        Thread.sleep(1000);

        // skip 4 race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click();// Click Skip
        Thread.sleep(1000);
        // Check that Cashout button is present
        checkCashoutIsPresent();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click(); // Click New Game button
        Thread.sleep(1000);

    }

    public void addSixSinglesWithStakes() throws InterruptedException {
        //add 6th singles bet
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); //add bet 1 trap 1 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add default stake ("+")
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add stake ("+")
        System.out.println("Bet at race 1 added");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[2]")).click(); //open race 2 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[5]/td[4]/a")).click(); //add bet 5 trap 2 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add default stake ("+")
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add stake ("+")
        System.out.println("Bet at race 2 added");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[3]")).click(); //open race 3 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[2]/td[4]/a")).click(); //add bet 2 trap 3 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add default stake ("+")
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add stake ("+")
        System.out.println("Bet at race 3 added");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[4]")).click(); //open race 4 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[2]/td[4]/a")).click(); //add bet 2 trap 4 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[1]/a/span")).click(); // open singles page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[4]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add default stake ("+")
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[4]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add stake ("+")
        System.out.println("Bet at race 4 added");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[5]")).click(); //open race 5 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[3]/td[4]/a")).click(); //add bet 3 trap 5 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[1]/a/span")).click(); // open singles page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[5]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add default stake ("+")
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[5]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add stake ("+")
        System.out.println("Bet at race 5 added");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[6]")).click(); //open race 6 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[4]/td[4]/a")).click(); //add bet 4 trap 6 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[1]/a/span")).click(); // open singles page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[6]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add default stake ("+")
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[6]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add stake ("+")
        System.out.println("Bet at race 6 added");
        Thread.sleep(1000);
    }

    public void checkNextRaceIsPresent()  {
        String nextRace;
        nextRace = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).getText();
        System.out.println(nextRace);
        if (nextRace.equals("NEXT RACE")) {
            System.out.println("Next Race is appeared");
        } else System.out.println("Next Race is NOT appeared");
    }

    public void checkCashoutIsPresent()  {
        CheckElement checkElement = new CheckElement();
        try {
            if (!checkElement.CheckElement("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a[1]/div/div")) {
                System.err.println("Element is required");
            }
        } catch (Exception e) {
            System.err.println("Element : Cashout is not present");
            //e.printStackTrace();
        }
    }

    @Test
    public void CheckCashout () throws Exception {
        FirstTest firstTest = new FirstTest();
        firstTest.setUp();
        firstTest.OpenLobbyRunGame();
        System.out.println("Game is opened");
        CheckCashoutFeatures();
        firstTest.tearDown();

    }
}
