package Scenario2;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Assert.*;

public class LoginPage {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;



    public LoginPage(AndroidDriver<MobileElement> driver){
        this.driver = driver;
    }

    public void setEmail(String email){

        wait = new WebDriverWait(driver, 20);
        try{
            Thread.sleep(5000);
        }
        catch (Exception e){}

        WebElement txtEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")));
        txtEmail.click();
        txtEmail.sendKeys(email);
        WebElement btnGiris = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.widget.Button")));
        btnGiris.click();
    }

    public void setPass(String pass){
        wait = new WebDriverWait(driver, 20);

        WebElement txtPass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")));
        txtPass.click();
        txtPass.sendKeys(pass);


        WebElement btnGiris2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.widget.Button"));
        btnGiris2.click();

        WebElement loginMessage = wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/message")));
        org.testng.Assert.assertEquals(driver.findElement((By) loginMessage).getText(), "Hoş geldin Burak Alkan. Keyifli alışverişler dileriz.", "LOGIN ERROR");

        WebElement acceptMessage = wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
        acceptMessage.click();

        WebElement geri = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.pozitron.hepsiburada:id/leftIcon")));
        geri.click();

    }
    public void favControl(){
        wait = new WebDriverWait(driver, 20);

        WebElement fav = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.pozitron.hepsiburada:id/nav_graph_my_list")));
        fav.click();

        WebElement close = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Kapat")));
        close.click();

        WebElement list = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\\\"Beğendiklerim Gizli liste Ürün ekle\\\"]/android.widget.TextView[3]")));
        list.click();

        Assert.assertEquals(driver.findElement(By.xpath("//android.view.View[@content-desc=\"58AU7000 58\" 147 Ekran Uydu Alıcılı 4K Ultra HD Smart LED TV\"]/android.widget.TextView")),"Samsung 58AU7000 58\" 147 Ekran Uydu Alıcılı 4K Ultra HD Smart LED TV","ERROR");

    }
}
