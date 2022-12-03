package Scenario2;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    public ProductPage(AndroidDriver<MobileElement> driver){
        this.driver = driver;
    }

    public void productOperations() {
        wait = new WebDriverWait(driver, 20);

        swipePhoto();
        swipePhoto();

        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"ürün fotoğrafı\"]")));
        product.click();

        WebElement fav = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"favoriye ekle\"]")));
        fav.click();
        fav.click();

    }
    public void swipePhoto(){
            WebElement photo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"ürün fotoğrafı\"]")));

            Dimension dimension = photo.getSize();

            int Anchor = photo.getSize().getHeight()/2;

            Double ScreenWidthStart = dimension.getWidth() * 0.8;
            int scrollStart = ScreenWidthStart.intValue();

            Double ScreenWidthEnd = dimension.getWidth() * 0.2;
            int scrollEnd = ScreenWidthEnd.intValue();

            new TouchAction((PerformsTouchActions) driver)
                    .press(PointOption.point(scrollStart, Anchor))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(scrollEnd, Anchor))
                    .release().perform();
        }

}

