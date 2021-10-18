import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExecutorTest {


    @Test
    public void executeJavascript(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");

        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        //zastepuje .click();
        executor.executeScript("arguments[0].click();",basicPageLink);
        //zastepuje .sendkeys();
        WebElement firstname = driver.findElement(By.name("fname"));
        executor.executeScript("arguments[0].setAttribute('value','Bartekkk');", firstname);



    }
}
