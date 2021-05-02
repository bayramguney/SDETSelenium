package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementVsFindElements_6 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");

        //FindElement return single element
        WebElement searchbox=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        searchbox.sendKeys("something");

        WebElement ele=driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
        System.out.println("ele.getText() = " + ele.getText());   // get the first webelement

        //FindElements return multiple elements

        List<WebElement> links=driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
        System.out.println("links.size() = " + links.size());
        for (WebElement each:links) {
            System.out.print(each.getText()+" ");

        }


        List<WebElement> logo=driver.findElements(By.xpath("//img[@alt='nopCommerce demo store']")); //single
        System.out.println("logo.size() = " + logo.size());

    }
}
