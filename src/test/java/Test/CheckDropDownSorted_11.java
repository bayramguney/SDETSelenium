package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckDropDownSorted_11 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.twoplugs.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[normalize-space()='Live Posting']")).click();

        WebElement drpElement=driver.findElement(By.name("category_id"));
        Select drpSelect=new Select(drpElement);

        List<WebElement> options=drpSelect.getOptions();

        ArrayList<String> originallist=new ArrayList<>();
        ArrayList<String> templist=new ArrayList<>();

        for (WebElement option:options) {
            originallist.add(option.getText());
            templist.add(option.getText());
        }
        System.out.println("originallist = " + originallist);
        System.out.println("templist = " + templist);
        Collections.sort(templist);
        System.out.println("after sort templist = " + templist);

         Assert.assertEquals(originallist,templist);


    }
}
