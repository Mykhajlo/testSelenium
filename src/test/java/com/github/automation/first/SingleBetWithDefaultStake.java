package com.github.automation.first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.github.automation.first.FirstTest.driver;
/**
 * Created by mykhail on 27.07.17.
 */
public class SingleBetWithDefaultStake {
    public WebDriver webDriver;
    @BeforeClass
    public void setUp() {
        webDriver = driver;
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }
    public  void SingleBetWithNotZeroStake(){
    // make one single bet with no Zero stake and run game
    }
    @Test
    public void  SingleBetWithDefaultStakeGame() throws IOException, InterruptedException {
        FirstTest firstTest = new FirstTest();
        firstTest.setUp();
        firstTest.OpenLobbyRunGame();
        System.out.println("Game is opened");
        SingleBetWithNotZeroStake();
        firstTest.tearDown();
    }
}


