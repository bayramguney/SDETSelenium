package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandleLinks_16 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

       // driver.findElement(By.linkText("Today's Deals")).click();
        driver.findElement(By.partialLinkText("Deals")).click();

        // capture all links
        List<WebElement> links=driver.findElements(By.tagName("a"));
        System.out.println("links.size() = " + links.size());

        for (WebElement link:links) {
            System.out.println(link.getText()+"--"+link.getAttribute("href"));
        }



    }
}
