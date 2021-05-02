package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getTextVsgetAttributeValue_7 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/login");

        WebElement emailinputbox=driver.findElement(By.id("Email"));
        emailinputbox.clear();
        emailinputbox.sendKeys("adm123@gmail.com");

        System.out.println("emailinputbox.getAttribute(\"value\") = " + emailinputbox.getAttribute("value"));
        System.out.println("emailinputbox.getText() = " + emailinputbox.getText());  // not right way
    }

}
