import org.testng.annotations.Test;

public class Scenario_Tests extends BaseTest {

    @Test
    public void Scenario_1_Tests(){
        dialogsCloseAndCloseAnimation();
        locationPage.location();
        categoriesPage.categories();
        productPage.productOperations();
        loginPage.setEmail("email");
        loginPage.setPass("sifre");
        loginPage.favControl();

    }
}
