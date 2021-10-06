import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class SeleniumTest {


    @Test
    public void openGooglePage() {

        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
       // Dimension windowSize = new Dimension(200, 200);
        //driver.manage().window().setSize(windowSize);
        driver.get("https://www.google.co.uk/");
        //JavascriptExecutor executor = (JavascriptExecutor) driver;
        //executor.executeScript("window.open('https://www.google.co.uk','blank','height=200,width=200')");

        //przechodzimy do okienka z plikami cookie


        //driver.switchTo().frame(0);
        //znalezienie przycisku
        WebElement agreeButton = driver.findElement(By.xpath("//div[contains(text(),'I agree')]"));
       // WebElement agreeButton = driver.findElement(By.className("jyfHyd"));
        // klikniecie przycisku
       agreeButton.click();
        // powrót to pierwotnego okna

        //driver.switchTo().defaultContent();
        //znajdz pole wyszukiwania
        WebElement searchField = driver.findElement(By.name("q"));
       //wprowadz wartosc selenium do pola
        searchField.sendKeys(("Selenium"));
        //zasymuluj nacisnienie przycisku enter
        searchField.sendKeys(Keys.ENTER);
        //znalezc rezultat
        WebElement result = driver.findElement(By.xpath("//a[contains(@href, 'selenium.dev')]//h3"));

        Assert.assertTrue(result.isDisplayed());

    }

    public WebDriver getDriver(String browser) throws IllegalArgumentException {

        switch (browser) {

            case "chrome":
                //  String chromePath = "C:\\Users\\kozi\\Downloads\\chromedriver_win32\\chromedriver.exe";
                //  System.setProperty("webdriver.chrome.driver", chromePath);
                return new ChromeDriver();

            case "firefox":
                String firefoxPath = "C:\\Users\\kozi\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe";
                System.setProperty("webdriver.gecko.driver", firefoxPath);
                return new FirefoxDriver();

            case "ie":
                String iePath = "C:\\Users\\kozi\\Downloads\\IEDriverServer_x64_3.150.2\\IEDriverServer.exe";
                System.setProperty("webdriver.ie.driver", iePath);
                InternetExplorerOptions options = new InternetExplorerOptions();
                options.withInitialBrowserUrl("https://www.google.co.uk/");
                return new InternetExplorerDriver();

            default:
                throw new InvalidArgumentException("Invalid browser name");
        }

    }


}


