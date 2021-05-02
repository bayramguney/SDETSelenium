package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class DownloadWordFile_30 {
    public static void main(String[] args) {

        String location=System.getProperty("user.dir")+"\\Download\\";

        // Chrome
      /*  HashMap preperence=new HashMap();
        preperence.put("download.default_directory",location);

        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("prefs",preperence);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        */

        // Edge
/*
        HashMap preperence=new HashMap();
        preperence.put("download.default_directory",location);

        EdgeOptions options=new EdgeOptions();
        options.setExperimentalOption("prefs",preperence);
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver(options);
*/
        //Firefox

        FirefoxProfile profile=new FirefoxProfile();
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/msword");  //mime types
        profile.setPreference("browser.download.folderList",2); // 0- desktop 1-download 2- loacation
        profile.setPreference("browser.download.dir",location);

        FirefoxOptions options=new FirefoxOptions();
        options.setProfile(profile);
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver(options);






        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();

    }
}
