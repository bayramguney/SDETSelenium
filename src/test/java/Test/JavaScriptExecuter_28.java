package Test;

import Utils.JavaScriptMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecuter_28 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();


        //Drawing border & take screenShot
        WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        JavaScriptMethods.drawBorder(driver,logo);
        JavaScriptMethods.takeScreenShot(driver,logo,"logoCommerce");

        //Highlighting
        JavaScriptMethods.flash(driver,logo);

        //Getting title of the page
       String title=JavaScriptMethods.getTitle(driver);
        System.out.println("title = " + title);


        //Click action
        WebElement registerLink=driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        JavaScriptMethods.clickElementByJS(driver,registerLink);


        //Generate Alert
        JavaScriptMethods.generateAlert(driver,"Selam Dunya");
        Alert alert=driver.switchTo().alert();
        alert.accept();


        //Refreshing the page
        JavaScriptMethods.refreshBrowser(driver);


        //Scrolling the page
        JavaScriptMethods.scrollDown(driver);
        Thread.sleep(3000);
        JavaScriptMethods.scrollUp(driver);


        //zoom page
        JavaScriptMethods.zoomPageJS(driver);



    }
}
