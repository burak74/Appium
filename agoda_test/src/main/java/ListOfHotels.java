import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;


public class ListOfHotels {

    WebDriver driver;

    public ListOfHotels(WebDriver driver){
        this.driver = driver;
    }

    public void hotels() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(1000,2000)");
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(2000,3000)");
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(3000,4000)");

        List<WebElement> hotels = driver.findElements(By.cssSelector("div[class='Box-sc-kv6pi1-0 bWGdbw PropertyCardPrice PropertyCardPrice--Display']"));
        for (WebElement tmpHotels: hotels) {

            String texts = tmpHotels.getText();
            System.out.println(texts);
        }
    }

    }
