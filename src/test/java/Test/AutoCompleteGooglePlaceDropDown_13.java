package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutoCompleteGooglePlaceDropDown_13 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.twoplugs.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()='Live Posting']")).click();

        WebElement searchBox = driver.findElement(By.id("autocomplete"));
        searchBox.clear();
        searchBox.sendKeys("Toronto");

        String text;

        do {
            searchBox.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(3000);
            text = searchBox.getAttribute("value");

            if (text.equals("Toronto, OH, USA")) {
                searchBox.sendKeys(Keys.ENTER);
                break;
            }
            Thread.sleep(2000);
        } while (!text.isEmpty());
    }
}
