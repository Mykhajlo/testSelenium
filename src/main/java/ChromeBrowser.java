import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by mykhail on 18.07.17.
 */
public class ChromeBrowser {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.google.com");
        if (driver.findElement(By.xpath("//input[@name='q']")).isEnabled()) {
            System.out.println("Google search text box Is enabled.");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//input[@name='q']")).sendKeys("WebDriver Test successful.");
            driver.findElement(By.xpath("//button[@name='btnG']")).click();
            System.out.println("Google search completed.");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else {
            System.out.println("Google search test box Is Not enabled.");

        }
        //driver.close();
    }
}
