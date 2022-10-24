import org.testng.annotations.Test;

public class Home_Test extends Base_Test {

    @Test
    public void home_page() throws InterruptedException {
        homePage.setPlace("Eskişehir");
        homePage.setDate();
        listOfHotels.hotels();
    }
}
