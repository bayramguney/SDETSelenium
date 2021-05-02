package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class KeyBoardMultipleActions_25 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://text-compare.com");
        driver.manage().window().maximize();

        Actions actions=new Actions(driver);

       WebElement input1= driver.findElement(By.xpath("//textarea[@id='inputText1']"));
       WebElement input2= driver.findElement(By.xpath("//textarea[@id='inputText2']"));
       input1.sendKeys("Welcome to Selenium");
       //CTRL + A        select the text in the box
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.perform();

        //CTRL + C
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.perform();

        //TAB  shift to inputbox 2
        actions.sendKeys(Keys.TAB);
        actions.perform();

        // CTRL + V
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("v");
        actions.keyUp(Keys.CONTROL);
        actions.perform();

        Assert.assertEquals(input1.getAttribute("value"),input2.getAttribute("value"));









    }
}
