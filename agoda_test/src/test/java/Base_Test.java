import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Base_Test {

    WebDriver driver;
    private By closePopup = By.xpath("//html/body/div[13]/div[2]/button");
    private By popUpImage = By.xpath("//html/body/div[12]/div[2]/div[1]/img");
    HomePage homePage;
    ListOfHotels listOfHotels;
    @BeforeSuite
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.agoda.com/tr-tr/?device=c&network=g&adid=577846848941&rand=5038072065642033926&expid=&adpos=&aud=kwd-2230651387&site_id=1891458&tag=4cfc9a64-5b98-9b1f-6abb-67a0bc11a306&gclid=CjwKCAjw-rOaBhA9EiwAUkLV4gniBip4KaAHm5edPI_Z6UPIfZ19nGzdqGQBPQaA4nSwjlAVX5eLIhoCxYEQAvD_BwE");

        Duration time = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(popUpImage));

        Actions act = new Actions(driver);
        act.moveByOffset(913, 477).click().build().perform();

        homePage = new HomePage(driver);
        listOfHotels = new ListOfHotels(driver);

    }
    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

}
