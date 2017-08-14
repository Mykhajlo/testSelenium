package com.github.automation.first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.github.automation.first.FirstTest.driver;

/**
 * Created by mykhail on 09.08.17.
 */
public class CheckSinglesRacesFullFlow {
    public WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        webDriver = driver;
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }
    public void CheckSinglesRacesFullFlowFeatures () throws Exception {
        /* Open Game
        add one  bet, start game, check all element at left and right part of page, watch video, check elements, start new game,
        add 6 singles bets with no zero stakes, start game, skip race  one  by one until Cashout button appeared, click Cashout
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
        //add bet 1 trap 1 race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); //add bet 1 trap 1 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add default stake ("+")
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add stake ("+")
        System.out.println("Stake changed");
        String dogName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]/span")).getText();
        System.out.println(dogName);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        // check all element at left and right part of page
        CheckElement checkElement = new CheckElement();
        getElements().forEach(s -> {
                    try {
                        if (!checkElement.CheckElement(s)) {
                            System.err.println("Element is required");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
        Thread.sleep(1000);

        String dogNameRace = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr/td[3]/span[1]")).getText();
        System.out.println(dogNameRace);
        if (dogNameRace.equals(dogName)) {
            System.out.println("Dog name is same with stake");
        } else System.out.println("Wrong dog name");
        Thread.sleep(1000);
        WebDriverWait waitVideo = new WebDriverWait(driver, 1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[2]")).click();// Click Watch Race
        // Check that selected bet and Skip button displayed under video
        String dogNameVideo = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/div[3]/div/table/tbody/tr/td[2]/div")).getText();
        System.out.println(dogNameRace);
        if (dogNameVideo.equals(dogNameRace)) {
            System.out.println("Dog name is same video");
        } else System.out.println("Wrong dog name");
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a/div/translate/span"));

        waitVideo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")));
        System.out.println("New Game Button appeared");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click(); // Click New Game button
        Thread.sleep(1000);

        //add bet 1 trap 1 race
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
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click();// Click Skip
        Thread.sleep(1000);
        // check that Next Race appeared
        String nextRace = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).getText();
        System.out.println(nextRace);
        if (nextRace.equals("NEXT RACE")) {
            System.out.println("Next Race is appeared");
        } else System.out.println("Next Race is NOT appeared");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click();// Click Next Race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click();// Click Skip
        Thread.sleep(1000);
        // check that Next Race button appeared
        nextRace = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).getText();
        System.out.println(nextRace);
        if (nextRace.equals("NEXT RACE")) {
            System.out.println("Next Race is appeared");
        } else System.out.println("Next Race is NOT appeared");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click();// Click Next Race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click();// Click Skip
        Thread.sleep(1000);
        // check that Next Race button appeared
        String cashout = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a[1]/div/div")).getText();
        System.out.println(cashout);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a[1]/div/div")).click();// Click Cashout
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click(); // Click New Game button
        Thread.sleep(1000);

        Thread.sleep(5000);



    }
    @Test
    public void CheckSinglesRacesFullFlow () throws Exception {
        FirstTest firstTest = new FirstTest();
        firstTest.setUp();
        firstTest.OpenLobbyRunGame();
        System.out.println("Game is opened");
        CheckSinglesRacesFullFlowFeatures();
        firstTest.tearDown();
    }

    public List<String> getElements() throws IOException {
        String fileName = "/Users/mykhail/IdeaProjects/first-test/src/test/resources/newRaceDetail.txt";
        List<String> elements = new ArrayList<>();
        Stream<String> stream = Files.lines(Paths.get(fileName));
        stream.forEach(elements::add);
        return elements;
    }
}
