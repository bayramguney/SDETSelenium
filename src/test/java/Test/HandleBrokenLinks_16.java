package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandleBrokenLinks_16 {


    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.deadlinkcity.com/");
        driver.manage().window().maximize();

        List<WebElement> links =driver.findElements(By.tagName("a"));
        int brokenlink=0;
        for (WebElement element:links) {
            String url=element.getAttribute("href");
            if(url==null || url.isEmpty()){
                System.out.println("Url is empty");
                continue;
            }
            URL link= null;
            try {
                link = new URL(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HttpURLConnection httpconn= (HttpURLConnection) link.openConnection();
            httpconn.connect();
            if(httpconn.getResponseCode()>400){
                System.out.println(httpconn.getResponseCode() + url +"  is "+" Broken link");
                brokenlink++;
            }else{
                System.out.println(httpconn.getResponseCode() +url + "  is "+" Broken link");
            }
        }
        System.out.println("brokenlink = " + brokenlink);
    }
}
