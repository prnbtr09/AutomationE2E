package stepDefs;

import driverManager.drivers.CreateDriver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomePageStepDef {
    WebDriver driver= CreateDriver.getInstance().getDriver();
    HomePage homePageObjects;

    @Given("user click on {string}")
    public void clickElement(String option){
        homePageObjects=new HomePage(driver);
        homePageObjects.addToCart.click();

    }
}
