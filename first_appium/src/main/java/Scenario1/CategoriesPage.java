package Scenario1;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.tools.ant.taskdefs.Touch;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.time.Duration.ofMillis;
import static java.util.Collections.singletonList;

public class CategoriesPage {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    public CategoriesPage(AndroidDriver<MobileElement> driver){
        this.driver = driver;
    }


    public void categories() {
        wait = new WebDriverWait(driver, 20);

        WebElement categoryTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Kategorilerim']")));
        categoryTab.click();

        WebElement clothing = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Giyim']")));
        clothing.click();

        try {
            Thread.sleep(3000);
        }
        catch (Exception e) {
        }

        WebElement homeTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Anasayfam']")));
        homeTab.click();

        try {
            Thread.sleep(3000);
        }
        catch (Exception e) {
        }

        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Süper Fiyat, Süper Teklif\").instance(0))";
        driver.findElementByAndroidUIAutomator(scrollElement).click();

        try{
            WebElement tumu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Tümü']")));
            tumu.click();
        }
        catch (Exception e){}



    }

}
