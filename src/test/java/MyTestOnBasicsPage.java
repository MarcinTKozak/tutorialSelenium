import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class MyTestOnBasicsPage {

    @Test
    public void testing() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        //hoover  test on heading <h1>
        Actions actions = new Actions(driver);
        WebElement head = driver.findElement(By.tagName("h1"));
        actions.moveToElement(head).perform();
        System.out.println(head.getText());
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //find input and send text
        driver.findElement(By.id("fname")).sendKeys("Marcin");
        //find link and click
        //driver.findElement(By.linkText("IamWeirdLink")).click();

        //select class and drop off option
        WebElement selectCars = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selectCars);
        cars.selectByValue("mercedes");

        List<WebElement> carList = cars.getOptions();
        for (WebElement option : carList) {
            System.out.println(option.getText());
        }


        //checkbox
        driver.findElement(By.cssSelector("[type='checkbox']")).click();
        //radiobutton
        driver.findElement(By.cssSelector("[value='male']")).click();

        //input login
        WebElement login = driver.findElement(By.name("username"));
        login.clear();
        login.sendKeys("kozimster");

        WebElement submit = driver.findElement(By.cssSelector("[value='Submit']"));
        submit.click();

        //handle alerts
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();
        driver.switchTo().alert().accept();


    }
}
