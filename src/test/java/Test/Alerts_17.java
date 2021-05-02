package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Alerts_17 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        //Alert with with OK button
        driver.findElement(By.xpath("//button[@id='alertButton']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        // Alert window with OK and Cancel button
        driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
        Thread.sleep(3000);
      //  driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();

        //Alert with info box,capture the text
        driver.findElement(By.xpath("//button[@id='promtButton']")).click();
        Thread.sleep(3000);
        Alert alertwindow= driver.switchTo().alert();
        System.out.println("alertwindow.getText() = " + alertwindow.getText());

        alertwindow.sendKeys("Welcome");
        Thread.sleep(3000);
        alertwindow.accept();


    }
}
