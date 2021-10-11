import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MyTest {

    @Test
    public void testing(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://en-gb.facebook.com/");
        driver.manage().window().maximize();
        ///html/body/header/button
        By invButton = By.xpath("//button[@title='Allow All Cookies']");
        WebElement RequestInviteButton = driver.findElement(invButton);
        RequestInviteButton.click();

        By createAccButton = By.xpath("//a[text()='Create New Account']");
        WebElement newAccount = driver.findElement(createAccButton);
        newAccount.click();
        ////*[@id="u_3_b_Vp"]
        ////*[@id="facebook"]/body/div[3]/div[2]/div/div

        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

        By firstName = By.xpath("//input[@name='firstname']");
        WebElement firstNameB = driver.findElement(firstName);
        firstNameB.sendKeys("Mikołaj");
        ////*[@id="u_3_d_9A"]
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        By lastName = By.xpath("//input[@name='lastname']");
        WebElement surname = driver.findElement(lastName);
        surname.sendKeys("Kozak");





    }
}
