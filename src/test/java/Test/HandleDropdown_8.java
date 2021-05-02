package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleDropdown_8 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.opencart.com/index.php?route=account/register");

        WebElement drpcountryEle=driver.findElement(By.xpath("//select[@id='input-country']"));
        Select drpCountry=new Select(drpcountryEle);

        drpCountry.selectByVisibleText("Cuba");
        drpCountry.selectByValue("10");
        drpCountry.selectByIndex(12);  // index start from 0

        List<WebElement> allOptions=drpCountry.getOptions();
        for (WebElement each:allOptions) {
           if( each.getText().equals("Cuba")){
                each.click();
                break;
            }
        }
    }


}

