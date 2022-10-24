import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    WebDriver driver;

    private By place = By.xpath("//*[@id=\"SearchBoxContainer\"]/div[1]/div/div[2]/div/div/div[1]/div/div/input");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void setPlace(String place1) throws InterruptedException {
        driver.findElement(place).sendKeys(place1);
        Thread.sleep(2000);
        driver.findElement(place).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        driver.findElement(place).sendKeys(Keys.ENTER);
        Thread.sleep(2000);


    }

    public void setDate() throws InterruptedException {


        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"SearchBoxContainer\"]/div[1]/div/div[2]/div/div/div[5]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[4]/div[6]/div/div")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"SearchBoxContainer\"]/div[1]/div/div[2]/div/div/div[5]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[4]/div[7]/div/div")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"SearchBoxContainer\"]/div[1]/div/div[2]/div/div/div[4]/div/div/div/div[1]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"SearchBoxContainer\"]/div[2]/button")).click();

    }

}
