package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutoSuggestDropdown_12 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
        List<WebElement> list=driver.findElements(By.xpath("//li[@class='sa_sg']//span"));

        System.out.println("list.size() = " + list.size());

        for (WebElement each:list) {
            if(each.getText().contains("testing")){
                each.click();
                System.out.println("driver.getTitle() = " + driver.getTitle());
                break;
            }
        }

    }
}
