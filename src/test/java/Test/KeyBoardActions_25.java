package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class KeyBoardActions_25 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/key_presses");
        driver.manage().window().maximize();

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);

        actions.sendKeys(Keys.BACK_SPACE).perform();
        Thread.sleep(3000);

        actions.sendKeys(Keys.RETURN).perform();
        Thread.sleep(3000);







    }
}
