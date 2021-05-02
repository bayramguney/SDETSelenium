package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTable_20 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.selenium.dev/downloads/");
        driver.manage().window().maximize();
        // how many rows in the table
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr"));
        System.out.println("rows.size() = " + rows.size());

        // how many column in the table
        List<WebElement> columns = driver.findElements(By.xpath("//table[@class='data-list']/thead/tr/th"));
        System.out.println("columns.size() = " + columns.size());

        //Retrive specific row or column
        WebElement value = driver.findElement(By.xpath("//table[@class='data-list']//tr[2]/td[1]"));
        System.out.println("value.getText() = " + value.getText());

        // Retrivin all data from the table

        for (int i = 1; i <= rows.size(); i++) {
            for (int j = 1; j <= columns.size(); j++) {
                String data = driver.findElement(By.xpath("//table[@class='data-list']//tr[" + i + "]/td[" + j + "]")).getText();
                System.out.print(data + "--------");
            }
            System.out.println();
        }

        // Print release date and Version no of java

        for (int i = 1; i <= rows.size(); i++) {
            String data = driver.findElement(By.xpath("//table[@class='data-list']//tr[" + i + "]/td[1]")).getText();
            if (data.equals("Java")) {
                String versionNo=driver.findElement(By.xpath("//table[@class='data-list']//tr[" + i + "]/td[2]")).getText();
                String releaseDate=driver.findElement(By.xpath("//table[@class='data-list']//tr[" + i + "]/td[3]")).getText();
                System.out.println("Java : "+versionNo+"----"+releaseDate);
                break;
            }
        }
    }


}
