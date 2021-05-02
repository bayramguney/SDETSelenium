package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HandleBrowserWindows_15 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

        String windowID=driver.getWindowHandle();   //return single windowID
        System.out.println("first windowID = " + windowID);

        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();

        Set<String> windowIDs=driver.getWindowHandles();

        // First method iterator
        Iterator<String> it=windowIDs.iterator();
        String parentWindowID=it.next();
        String childWindowID=it.next();

        System.out.println("parentWindowID = " + parentWindowID);
        System.out.println("childWindowID = " + childWindowID);

        // Second method
        System.out.println("######################################");
        List<String> windowIDsList=new ArrayList<>(windowIDs); // converting to list

        String parentID=windowIDsList.get(0);
        String childID=windowIDsList.get(1);

        System.out.println("parentID = " + parentID);
        System.out.println("childID = " + childID);
        System.out.println("parent getTitle() = " + driver.getTitle());
        // switching to other window
        System.out.println("child getTitle() = " + driver.switchTo().window(childID).getTitle());

        //Third method
        System.out.println("##########################################");
        for (String win:windowIDsList) {
            String title=driver.switchTo().window(win).getTitle();
            System.out.println(title);
            if(title.equals("OrangeHRM")){
                driver.close();
            }
        }


    }
}
