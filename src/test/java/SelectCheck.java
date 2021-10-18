//napisz metode która przyjmuje String jako parametr i zwraca typ boolean
//metoda sprawdza czy parametr String jest jedna z opcji w Select

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;


public class SelectCheck {

    public boolean checkOption(String optionText, WebElement element) {
        Select select = new Select(element);

        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(optionText))
                return true;
        }
        return false;
    }

}




