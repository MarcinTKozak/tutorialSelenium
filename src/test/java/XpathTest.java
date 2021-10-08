import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class XpathTest {

    @Test
    public void findElement() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        //clickOnMe
        By buttonId = By.xpath("//button[@id='clickOnMe']");
        WebElement clickOnMeButton = driver.findElement(buttonId);

        //fname
        By firstName = By.xpath("//input[@name='fname']");
        WebElement firstNameInput = driver.findElement(firstName);
        WebElement firstNameInput2 = driver.findElement(By.name("fname"));

        //topSecret
        By paraHidden = By.xpath("//p[@class='topSecret']");
        WebElement paraHiddenClass = driver.findElement(paraHidden);

        By inputLocator = By.xpath("//input");
        WebElement input = driver.findElement(inputLocator);
        input.sendKeys("Pierwszy");
        List<WebElement> inputs = driver.findElements(inputLocator);
        System.out.println(inputs.size());

        By linkText = By.xpath("//a[text()='Visit W3Schools.com!']");
        WebElement schoolLink = driver.findElement(linkText);

        By partialLink = By.xpath("//a[contains(text(),'Visit')]");
        WebElement partialLinks = driver.findElement(partialLink);

        By fullPath = By.xpath("/html/body/div/ul");
        driver.findElement(fullPath);

        By shortPath = By.xpath("//ul");
        driver.findElement(shortPath);

        By allXpath = By.xpath("//*");
        driver.findElement(allXpath);

        By secondElement = By.xpath("(//input)[2]");
        driver.findElement(secondElement);

        By lastElement = By.xpath("(//input)[last()]");
        driver.findElement(lastElement);

        By elementWithAttribute = By.xpath("//*[@name]");
        driver.findElement(elementWithAttribute);

        By attrEquals = By.xpath("//button[@id='clickOnMe']");
        driver.findElement(attrEquals);

        By attrNotEqual = By.xpath("//button[@id!='clickOnMe']");
        driver.findElement(attrNotEqual);

        By attrContain = By.xpath("//*[contains(@name,'ame')]");
        driver.findElement(attrContain);

        By startWith = By.xpath("//*[starts-with(@name,'user')]");
        driver.findElement(startWith);

        By endsWith = By.xpath("//*[substring(@name, string-length(@name)-string-length('ame')+1)='ame']");
        driver.findElement(endsWith);

        //----

        By child = By.xpath("//div/child::ul");
        By desc = By.xpath("//div/descendant::*");
        By parent = By.xpath("//div/../..");
        By ascending = By.xpath("//div/ancestor::*");
        By following = By.xpath("//img/following::*");
        By follSibling = By.xpath("//img/following-sibling::*");
        By precedeing = By.xpath("//img/preceding::*");
        By precedSibling = By.xpath("//img/preceding-sibling::*");

        driver.findElement(child);
        driver.findElement(desc);
        driver.findElement(parent);
        driver.findElement(ascending);
        driver.findElement(following);
        driver.findElement(follSibling);
        driver.findElement(precedeing);
        driver.findElement(precedSibling);

        // operatory |, and, or

        By divsAndLinks = By.xpath("//a | //div");
        By andOp = By.xpath("//input[@name='fname' and @id='fname'] ");
        By orOperator = By.xpath("//input[@name='fname' or @id='fname']");

        driver.findElement(divsAndLinks);
        driver.findElement(andOp);
        driver.findElement(orOperator);




    }

}
