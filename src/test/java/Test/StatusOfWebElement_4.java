package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// Part 4
public class StatusOfWebElement_4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/register");


        WebElement searchStore=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        // isDisplayed()   isdisplayed()
        System.out.println("searchStore.isDisplayed() = " + searchStore.isDisplayed());
        System.out.println("searchStore.isEnabled() = " + searchStore.isEnabled());

        // isSelected()
        WebElement male=driver.findElement(By.xpath("//input[@id='gender-male']"));
        male.click();
        System.out.println("male.isSelected() = " + male.isSelected());

    }
}
