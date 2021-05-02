package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations_5 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.snapdeal.com/");
        driver.navigate().to("https://www.amazon.com/");

        driver.navigate().back();   //snapdeal
        driver.navigate().forward();  //amazon

        driver.navigate().refresh();
    }
}
