import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImageTest {

    WebDriver driver;

    @Test
    public void imageTest() {


        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/image.html");

        WebElement image = driver.findElement(By.tagName("img"));
        String height = image.getAttribute("naturalHeight");
        System.out.println();

        Assert.assertEquals(height, "0");


    }
}
