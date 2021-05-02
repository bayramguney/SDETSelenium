package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BoostStraoDropdownMethod_9 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.hdfcbank.com/");

//product type
        driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();
        List<WebElement> productTypes=driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
        System.out.println("productTypes.size() = " + productTypes.size());

       selectOptionFromDropDown(productTypes,"Salary Accounts");
    }
    public static void selectOptionFromDropDown(List<WebElement> options,String value){
        for (WebElement each:options) {
            if (each.getText().equals(value)){
                each.click();
                break;
            }
        }
    }
}
