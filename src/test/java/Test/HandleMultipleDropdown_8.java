package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleMultipleDropdown_8 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
        //Approach 1
        Select noOfEmployees = new Select(driver.findElement(By.name("NoOfEmployees")));
        Select industryDrp = new Select(driver.findElement(By.name("Industry")));
        Select countryDrp = new Select(driver.findElement(By.name("Country")));

        //Approach 2
        WebElement noOfEmpsEle = driver.findElement(By.name("NoOfEmployees"));
        selectOptionFromDropdown(noOfEmpsEle, "16 - 20");
        WebElement industryEle = driver.findElement(By.name("Industry"));
        selectOptionFromDropdown(industryEle, "Healthcare");
        WebElement country = driver.findElement(By.name("Country"));
        selectOptionFromDropdown(country, "Ghana");


    }

    public static void selectOptionFromDropdown(WebElement ele, String value) {
        Select drp = new Select(ele);
        List<WebElement> allOptions = drp.getOptions();
        for (WebElement each : allOptions) {
            if (each.getText().equals(value)) {
                each.click();
                break;
            }
        }
    }


}

