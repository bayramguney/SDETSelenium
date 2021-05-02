package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DynamicWebTableWithPagination_21 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.opencart.com/admin/index.php");
        driver.manage().window().maximize();
        //Login
        WebElement username = driver.findElement(By.id("input-username"));
        username.clear();
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.id("input-password"));
        password.clear();
        password.sendKeys("demo");

        driver.findElement(By.xpath("//button[text()=' Login']")).click();

        driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();

        //Table
        //1 ) find total number of pages in table
        String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
        System.out.println("text = " + text);  // text = Showing 1 to 20 of 8840 (442 Pages)

        int pageNo = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));
        System.out.println("total pages = " + pageNo);

        String secondWayPageNO = text.split("\\(")[1].substring(0, 4);
        System.out.println("asd = " + secondWayPageNO);
        //2) find howmany rows exist in each pages
        for (int p = 1; p <= pageNo; p++) {
            WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']//li/span"));
            System.out.println("activePage number = " + activePage.getText());
            activePage.click();

            int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr")).size();
            System.out.println("rowsNo = " + rows);

            // read all the rows from each page

            for (int i = 1; i <=rows ; i++) {
                String orderID = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + i + "]//td[2]")).getText();
                String customeName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + i + "]//td[3]")).getText();
                String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + i + "]//td[4]")).getText();

                if (status.equals("Pending")){
                    System.out.println(orderID + "--" + customeName + "--" + status);
            }
            }

            String pagenumber = Integer.toString(p + 1); // trying pass next page
            driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+pagenumber+"']")).click();
        }




    }
}
