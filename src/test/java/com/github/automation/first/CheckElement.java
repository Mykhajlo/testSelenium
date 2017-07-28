package com.github.automation.first;

import org.omg.CORBA.SystemException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static com.github.automation.first.FirstTest.driver;
/**
 * Created by mykhail on 27.07.17.
 */
public class CheckElement {
    public WebDriver webDriver;
    @BeforeClass
    public void setUp() {
        webDriver = driver;
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }
    public Boolean CheckElement(String element) throws Exception {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if(java.util.Optional.ofNullable(driver.findElement(By.xpath(element))).isPresent()){
            System.out.println("Element present");
            return true;
        } else {
            System.out.println("Element required");
            return false;
        }
        //Check element from  list at the  main page

//
//        for (int i=1; i<=getLists().size(); i++)
//        {
//            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//            driver.findElement(By.xpath(element));
//        }     return false;
    }
    @Test
    public void  CheckAllElements() throws IOException, InterruptedException {
        FirstTest firstTest = new FirstTest();
        firstTest.setUp();
        firstTest.OpenLobbyRunGame();
        System.out.println("Game is opened");
        driver.switchTo().frame(driver.findElement(By.id("iframeContainer")));
        System.out.println("Bingo! You are at iframeContainer");
        getLists().forEach(s ->{
                    try {
                       if(!CheckElement(s)) {
                           System.out.println("Element is required");
                       }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
        }
        );
        firstTest.tearDown();
    }
    public List<String> getLists() throws IOException {
        String fileName = "/Users/mykhail/IdeaProjects/first-test/src/test/resources/data.txt";
        List<String> elements = new ArrayList<>();
        Stream<String> stream = Files.lines(Paths.get(fileName));
        stream.forEach(elements::add);
        return elements;
    }
}
