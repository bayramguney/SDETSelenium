package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OpenURLin2Tab_27 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        //Bu ozellikl selenium 4 ile geliyor ve ikinci url nxt tabde acilir
//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.get("https://www.twoplugs.com/");
    }
}
