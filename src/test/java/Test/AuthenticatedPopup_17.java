package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AuthenticatedPopup_17 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driver.get("https://the-internet.herokuapp.com/basic_auth");
        driver.manage().window().maximize();
        //Sytax
        //https://admin:admin@the-internet.herokuapp.com/basic_auth
        //https://user:password@URL
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");


    }
}
