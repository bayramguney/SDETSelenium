package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class UploadFile_31 {
    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.monsterindia.com/");
        driver.manage().window().maximize();
        // if atribute type is file or name is file
        driver.findElement(By.xpath("//span[@class='uprcse semi-bold']")).click();
        driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\bayra\\OneDrive\\Documents\\Pictures\\Low10Amazon.pdf");
        Thread.sleep(5000);


       // using robot class
        driver.get("https://www.monsterindia.com/");
        driver.findElement(By.xpath("//span[@class='uprcse semi-bold']")).click();
        WebElement button=driver.findElement(By.xpath("//input[@id='file-upload']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",button);
        // now copy the path -- ctrl+v (paste path in filename section)--Enter
        Robot robot=new Robot();
        robot.delay(2000);
        //CTRL+c
        StringSelection stringSelection=new StringSelection("C:\\Users\\bayra\\OneDrive\\Documents\\Pictures\\Low10Amazon.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
        //CTRL+v
        robot.keyPress(KeyEvent.VK_CONTROL);  // press on control key
        robot.keyPress(KeyEvent.VK_V);  // press on  v key
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        //Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);








    }
}
