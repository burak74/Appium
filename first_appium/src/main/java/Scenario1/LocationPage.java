package Scenario1;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import static org.testng.Assert.*;


public class LocationPage {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;


    public LocationPage(AndroidDriver<MobileElement> driver){
        this.driver = driver;
    }

    public void location(){
        wait = new WebDriverWait(driver, 20);

        WebElement location = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.pozitron.hepsiburada:id/textViewLocation")));
        location.click();

        WebElement selectCity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"İl seçin\"]")));
        selectCity.click();
        WebElement selectCityName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Adana']")));
        selectCityName.click();

        WebElement selectDistrict = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"İlçe seçin\"]")));
        selectDistrict.click();
        WebElement selectDistrictName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Çukurova']")));
        selectDistrictName.click();

        WebElement selectNeighbourHood = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Mahalle seçin\"]")));
        selectNeighbourHood.click();
        WebElement selectNeigName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Belediye Evleri']")));
        selectNeigName.click();


        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.pozitron.hepsiburada:id/button")));
        saveButton.click();

        WebElement title = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.pozitron.hepsiburada:id/tvTitle")));
        org.testng.Assert.assertEquals(title.getText(),"Konumunuz kaydedildi.");

    }
}
