package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Cookies_29 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        //How to capture cookies from browser
        Set<Cookie> cookies=driver.manage().getCookies();
        System.out.println("cookies.size() = " + cookies.size());
        //how to print the cookies
        for (Cookie cookie:cookies) {
            System.out.println("cookie.getName() = " + cookie.getName()+" --cookie.value : "+cookie.getValue());
        }
        //How to add the cookie to the browser
        Cookie cookieobj=new Cookie("Mycookie123","123456");
        driver.manage().addCookie(cookieobj);
        cookies=driver.manage().getCookies();
        System.out.println("-----------------------");
        for (Cookie cookie:cookies) {
            System.out.println("cookie.getName() = " + cookie.getName()+" --cookie.value : "+cookie.getValue());
        }
        //How to delete the cookie
        System.out.println("----------------------------");
        driver.manage().deleteCookie(cookieobj);
        cookies=driver.manage().getCookies();
        for (Cookie cookie:cookies) {
            System.out.println("cookie.getName() = " + cookie.getName()+" --cookie.value : "+cookie.getValue());
        }

        //delete the cookie by name
        System.out.println("----------------------------");
        driver.manage().deleteCookieNamed("_ga");
        cookies=driver.manage().getCookies();
        for (Cookie cookie:cookies) {
            System.out.println("cookie.getName() = " + cookie.getName()+" --cookie.value : "+cookie.getValue());
        }

        //Delete all cookies
        System.out.println("----------------------------");
        driver.manage().deleteAllCookies();
        cookies=driver.manage().getCookies();
        for (Cookie cookie:cookies) {
            System.out.println("cookie.getName() = " + cookie.getName()+" --cookie.value : "+cookie.getValue());
        }

    }
}
