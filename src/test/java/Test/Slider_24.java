package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Slider_24 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();

        WebElement minslider=driver.findElement(By.xpath("//span[1]"));
        WebElement maxSlider= driver.findElement(By.xpath("//span[2]"));
        System.out.println("minslider.getLocation() = " + minslider.getLocation()); //59,250
        System.out.println("minslider.getSize() = " + minslider.getSize());  //21,21
        System.out.println("maxSlider.getLocation() = " + maxSlider.getLocation()); //(510, 250)

        Actions action=new Actions(driver);
        action.dragAndDropBy(minslider,100,0).perform();
        // x ekseninde 100 birim otelendi
        System.out.println("minslider.getLocation() = " + minslider.getLocation()); // 158,250
        System.out.println("minslider.getSize() = " + minslider.getSize());  //21,21

        action.dragAndDropBy(maxSlider,-100,0).perform();

        System.out.println("maxSlider.getLocation() = " + maxSlider.getLocation());  //(411, 250)


    }
}
