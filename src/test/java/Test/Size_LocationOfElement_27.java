package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Size_LocationOfElement_27 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement logo=driver.findElement(By.xpath("//div[@id='divLogo']//img"));

        //Location method 1
        System.out.println("logo.getLocation() = " + logo.getLocation());  //  (423, 75)
        System.out.println("logo.getLocation().getX() = " + logo.getLocation().getX());
        System.out.println("logo.getLocation().getY() = " + logo.getLocation().getY());

        //Location method 2
        System.out.println("logo.getRect().getX() = " + logo.getRect().getX());
        System.out.println("logo.getRect().getY() = " + logo.getRect().getY());

        // Size method 1
        System.out.println("logo.getSize() = " + logo.getSize());   // width and height
        System.out.println("logo.getSize().getHeight() = " + logo.getSize().getHeight());
        System.out.println("logo.getSize().getWidth() = " + logo.getSize().getWidth());

        // Size method 2
        System.out.println("logo.getRect().getDimension().getWidth() = " + logo.getRect().getDimension().getWidth());
        System.out.println("logo.getRect().getDimension().getHeight() = " + logo.getRect().getDimension().getHeight());

    }
}
