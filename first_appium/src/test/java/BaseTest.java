import Scenario1.CategoriesPage;
import Scenario1.LocationPage;
import Scenario2.LoginPage;
import Scenario2.ProductPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
public class BaseTest {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    LocationPage locationPage;
    CategoriesPage categoriesPage;
    ProductPage productPage;
    LoginPage loginPage;


    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "sdk_gphone64_x86_64");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("appPackage", "com.pozitron.hepsiburada");
        caps.setCapability("appActivity","com.hepsiburada.ui.startup.SplashActivity");

        driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 20);

        locationPage = new LocationPage(driver);
        categoriesPage = new CategoriesPage(driver);
        productPage = new ProductPage(driver);
        loginPage = new LoginPage(driver);

    }
    public void dialogsCloseAndCloseAnimation(){
        WebElement check = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_button")));
        check.click();
        WebElement devam = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.pozitron.hepsiburada:id/featureImage")));
        devam.click();

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
