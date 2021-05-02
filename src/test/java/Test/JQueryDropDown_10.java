package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JQueryDropDown_10 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        driver.manage().window().maximize();
        driver.findElement(By.id("justAnInputBox")).click();
       // selectChoicesValues(driver, "choice 1", "choice 2");
        selectChoicesValues(driver,"all");


    }

    public static void selectChoicesValues(WebDriver driver, String... value) {
        List<WebElement> choiceList = driver.findElements(By.xpath("//input[@id=\"justAnInputBox\"]/../..//span[@class=\"comboTreeItemTitle\"]"));
        if (!value[0].equalsIgnoreCase("all")) {
            for (WebElement item : choiceList) {
                String text = item.getText();
                for (String val : value) {
                    if (text.equals(val)) {
                        item.click();
                        break;
                    }
                }
            }
        } else {
            for (WebElement item : choiceList) {
                item.click();
            }


        }
    }


}
