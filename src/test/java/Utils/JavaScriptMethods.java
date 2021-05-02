package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class JavaScriptMethods {

    public static void drawBorder(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public static void takeScreenShot(WebDriver driver, WebElement element, String filename) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File trg = new File(".\\screenshots\\" + "filename" + ".png");
        try {
            FileUtils.copyFile(src, trg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTitle(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title;").toString();
        return title;
    }

    public static void clickElementByJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void generateAlert(WebDriver driver, String message) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('"+message+"')");

    }

    public static void refreshBrowser(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("history.go(0)");
    }

    public static void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public static void scrollUp(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

    }

    public static void zoomPageJS(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='50%'");

    }

    public static void flash(WebDriver driver,WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String bgcolor = element.getCssValue("backgroundColor");
        for (int i = 0; i <50 ; i++) {
            changeColor(driver,element,"#000000");
            changeColor(driver,element,bgcolor);
        }
    }

    public static void changeColor(WebDriver driver,WebElement element,String color){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",element);
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
