package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CaptureScreenshots_26 {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        // Full Page Screenshot
        TakesScreenshot screenshot=(TakesScreenshot) driver;
        File src=screenshot.getScreenshotAs(OutputType.FILE);
        File target=new File(".\\screenshots\\homepage.png");
        FileUtils.copyFile(src,target);

        //Screen of section/portion of page

        WebElement section=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
        File src1=section.getScreenshotAs(OutputType.FILE);
        File target1=new File(".\\screenshots\\features.png");
        FileUtils.copyFile(src1,target1);

        //Screen of specific webelement

        WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        File src2=logo.getScreenshotAs(OutputType.FILE);
        File target2=new File(".\\screenshots\\logo.png");
        FileUtils.copyFile(src2,target2);



    }
}
