package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InnerIFrame_18 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.automationtesting.in/Frames.html");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']")).click();
        WebElement outerframe=driver.findElement(By.xpath("//*[@id=\"Multiple\"]/iframe"));
        driver.switchTo().frame(outerframe);

        WebElement innerframe=driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
        driver.switchTo().frame(innerframe);

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Welcome");
    }
}
