package com.github.automation.first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static com.github.automation.first.FirstTest.driver;
/**
 * Created by mykhail on 18.07.17.
 */

public class OneSingleBet {

    public WebDriver webDriver;
//    public String element = "//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a";

    @BeforeClass
    public void setUp() {
        webDriver = driver;
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }

    public void SingleBetWithZeroStake () throws InterruptedException {
    String url = driver.getCurrentUrl();
        System.out.println("Url ->  " + "    "  + url);
        driver.switchTo().frame(driver.findElement(By.id("iframeContainer")));
        System.out.println("Bingo! You are at iframeContainer");

try {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a"))); // find Add to Bet slip button for Race 1 and Trap 1
} catch (Throwable e) {
    System.out.println("Error while swithing to the frame. " + e.getMessage());

}
    driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a"));
        System.out.println("Element Add to bet' slip'found!!");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")));
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); // Add single bet

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.findElement(By.className("singles__table"));
        System.out.println("Single bet added correctly ");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click(); //Click Start Game
        System.out.println("game started");
        System.out.println("Race loaded");
        WebDriverWait waitVideo = new WebDriverWait(driver, 1000);
        waitVideo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[2]")));
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[2]")).click(); // Click Watch Race button
        waitVideo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")));
        System.out.println("Skip all Button appeared after watching video");
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click(); // Click Skip All button
        System.out.println("New Game Button appeared");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click(); // Click New Game button


     driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }
     @Test
      public void  OneSingleBetGame() throws IOException, InterruptedException {
         FirstTest firstTest = new FirstTest();
         firstTest.setUp();
         firstTest.OpenLobbyRunGame();
        // Thread.sleep(5000);
         System.out.println("first step");
         //getLists().forEach(this::checkElement);
         SingleBetWithZeroStake();
         System.out.println("second step");
         String url = driver.getCurrentUrl();
         System.out.println(url);
         //firstTest.tearDown();
         System.out.println("third step");
        // firstTest.OpenLobbyRunGame();
    }

//    public List<String> getLists() throws IOException {
//        String fileName = "/Users/mykhail/IdeaProjects/first-test/src/test/resources/data.txt";
//        List<String> elements = new ArrayList<>();
//        Stream<String> stream = Files.lines(Paths.get(fileName));
//        stream.forEach(elements::add);
//        return elements;
//    }

}