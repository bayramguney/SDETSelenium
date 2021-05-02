package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InnerFrame2_18 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe");
        driver.manage().window().maximize();

        driver.switchTo().frame("iframeResult");  // switch to outer frame
        driver.switchTo().frame(0);  // switch to innerframe by index
        System.out.println("inner message :  " + driver.findElement(By.xpath("//h1")).getText());

        driver.switchTo().parentFrame();

        String outsideText=driver.findElement(By.xpath("//p[contains(text(),'An iframe is used to display a web page within a w')]")).getText();
        System.out.println("outsideText = " + outsideText);
    }
}
