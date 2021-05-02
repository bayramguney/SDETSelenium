package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MouseAction_23 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        driver.manage().window().maximize();

        WebElement button=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions action=new Actions(driver);
        action.contextClick(button).perform();   //Right click action

        Thread.sleep(3000);


        driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
        driver.manage().window().maximize();
        driver.switchTo().frame("iframeResult");
        WebElement firstField=driver.findElement(By.xpath("//input[@id='field1']"));
        firstField.clear();
        firstField.sendKeys("Welcome to Selenium");

        WebElement button2=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
        action.doubleClick(button2).perform();  // doubleclick

        Thread.sleep(5000);
        driver.navigate().to("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        WebElement sourceElement=driver.findElement(By.id("box6"));
        WebElement targetelement=driver.findElement(By.id("box106"));

        action.dragAndDrop(sourceElement,targetelement).perform();  //drag And drop

        Thread.sleep(5000);
        driver.navigate().to("https://www.globalsqa.com/demo-site/draganddrop/");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));

        List<WebElement> images=driver.findElements(By.xpath("//ul[@id='gallery']//li"));
        WebElement target=driver.findElement(By.xpath("//div[@id='trash']"));

        for (WebElement image:images ) {
          action.dragAndDrop(image,target).perform();  // multiple image drag and drop
          Thread.sleep(1000);
        }

        Thread.sleep(5000);
        driver.navigate().to("https://demo.opencart.com/");
       WebElement desktop= driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
       WebElement mac=driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));

       action.moveToElement(desktop).moveToElement(mac).click().perform(); // mouse over action







    }
}
