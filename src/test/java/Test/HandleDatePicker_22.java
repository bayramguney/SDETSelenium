package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandleDatePicker_22 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
        driver.manage().window().maximize();

        String year = "2022";
        String month = "Jul";
        String date = "10";

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");


        driver.findElement(By.xpath("//input[@id='dob']")).click(); //open the datepicker
        Select monthDrop = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        monthDrop.selectByVisibleText(month);


        Select yearDrop = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
        yearDrop.selectByVisibleText(year);
        //Date Selection
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

        for (WebElement ele : allDates) {
            String text = ele.getText();
            if (text.equals(date)) {
                ele.click();
                break;
            }
        }
    }
}
