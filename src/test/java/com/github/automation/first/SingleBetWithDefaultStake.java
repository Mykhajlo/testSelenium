package com.github.automation.first;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.github.automation.first.FirstTest.driver;
/**
 * Created by mykhail on 27.07.17.
 */
public class SingleBetWithDefaultStake {
    public WebDriver webDriver;

    @Test
    public void  SingleBetWithDefaultStakeGame() throws IOException, InterruptedException {
        FirstTest firstTest = new FirstTest();
        firstTest.setUp();
        firstTest.OpenLobbyRunGame();
        System.out.println("GameLobby is opened");
    }
}


