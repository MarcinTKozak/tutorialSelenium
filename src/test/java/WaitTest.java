import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitTest {


        WebDriver driver;

        @Test
        public void WaitTest() {


            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

            driver.findElement(By.id("clickOnMe")).click();
            //Thread.sleep(5000);

            FluentWait<WebDriver> wait = new FluentWait<>(driver);
            wait.ignoring(NoSuchElementException.class );
            wait.withTimeout(Duration.ofSeconds(10));
            wait.pollingEvery(Duration.ofSeconds(1));//sprawdza co sekunde
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("pa")));

            driver.findElement(By.cssSelector("p"));


        }
    }

