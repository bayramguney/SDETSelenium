package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandleCheckBox_14 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        driver.manage().window().maximize();

        //1) select specific checkbox

      //  driver.findElement( By.xpath("//input[@id='Monday']")).click();

        // select all check box

        List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
        System.out.println("checkboxes.size() = " + checkboxes.size());

        for (int i = 0; i <checkboxes.size() ; i++) {
            checkboxes.get(i).click();
        }

        Thread.sleep(5000);
        for (WebElement each:checkboxes) {
            each.click();
        }

        //3) select multiple checkboxes by choice  (Monday and sunday)
        for (WebElement each:checkboxes) {
            String checkboxName=each.getAttribute("id");
            if(checkboxName.equals("monday") || checkboxName.equals("tuesday")){
                each.click();
            }
        }

        //4) Select last 32 checkboxes

        for (int i =checkboxes.size()-2; i <checkboxes.size() ; i++) {
            checkboxes.get(i).click();
        }

    }
}

